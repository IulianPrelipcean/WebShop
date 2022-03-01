package servlets;

import beans.cart.Cart;
import beans.cart.CartList;
import beans.product.Product;
import beans.product.ProductList;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,  HttpServletResponse response)throws ServletException, IOException{

        File file_cart = new File("/opt/tomcat/webapps/db_files/cart.xml");
        File file_product = new File("/opt/tomcat/webapps/db_files/products.xml");

        XmlMapper xmlMapper = new XmlMapper();

        try{
            CartList cart_list = xmlMapper.readValue(file_cart, CartList.class);
            ProductList product_list = xmlMapper.readValue(file_product, ProductList.class);
            ArrayList<HashMap<String, String>> all_cart_products = new ArrayList<>();
            HashMap<String, String> data_pair = new HashMap<>();

            float total_price = 0;
            float price_per_product = 0;

            for(Cart cart: cart_list.getCartList()) {
                for (Product product : product_list.getProductList()) {
                    data_pair = new HashMap<>();
                    if (cart.getProduct_id() == product.getProduct_id()) {

                        price_per_product = cart.getQuantity() * product.getPrice();
                        total_price += price_per_product;

                        data_pair.put("product_id", String.valueOf(cart.getProduct_id()));
                        data_pair.put("name", product.getName());
                        data_pair.put("price", String.valueOf(price_per_product));
                        data_pair.put("quantity", String.valueOf(cart.getQuantity()));

                        all_cart_products.add(data_pair);
                    }
                }
            }
            request.setAttribute("cart_list", all_cart_products);
            request.setAttribute("total_price", total_price);

        }catch(FileNotFoundException e){
            request.setAttribute("total_price", 0);

        }

        request.getRequestDispatcher("./shopping_cart.jsp").forward(request, response);
    }

}
