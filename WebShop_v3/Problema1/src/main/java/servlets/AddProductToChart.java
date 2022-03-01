package servlets;

import beans.cart.Cart;
import beans.cart.CartList;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddProductToChart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        File file = new File("/home/iulian0user/Media/work/Interships/YoungCulture/WebShop/WebShop_v3/cart.xml");
//        FileWriter file_logs = new FileWriter("logs.txt", true);
        FileWriter file_logs = new FileWriter("/home/iulian0user/Media/work/Interships/YoungCulture/WebShop/WebShop_v3/logs.txt", true);

        XmlMapper xmlMapper = new XmlMapper();

        String id_product = request.getParameter("product_id");
        String quantity_value = request.getParameter("quantity_value");

        Cart new_product = createProduct(id_product, quantity_value);

        try {
            CartList cart_list = xmlMapper.readValue(file, CartList.class);
            Boolean product_exists = false;


            for(Cart cart: cart_list.getCartList()){
                if(String.valueOf(cart.getProduct_id()).equals(id_product)){
                    cart.setQuantity(cart.getQuantity() + new_product.getQuantity());
                    product_exists = true;
                    xmlMapper.writeValue(file, cart_list);
                    file_logs.append("Product with id = ").append(String.valueOf(new_product.getProduct_id())).append(" was added to chart.\n");
                }
            }

            if(!product_exists && validateQuantity(new_product)){
                cart_list.getCartList().add(new_product);
                xmlMapper.writeValue(file, cart_list);
                file_logs.append("Product with id = ").append(String.valueOf(new_product.getProduct_id())).append(" was added to chart.\n");
            }
        }catch(Exception e){
            CartList cart_list = new CartList();
            if(validateQuantity(new_product)) {
                cart_list.getCartList().add(new_product);
                xmlMapper.writeValue(file, cart_list);
                file_logs.append("Product with id = ").append(String.valueOf(new_product.getProduct_id())).append(" was added to chart.\n");
            }
        }
        file_logs.close();
        response.sendRedirect("http://localhost:8080/JEE-Test_lab1/home");
        //response.sendRedirect("http://localhost:8090/JEE-Test_lab1/home");
    }


    private Cart createProduct(String id_product, String quantity_value){
        try{
            int id = Integer.parseInt(id_product);
            int quantity = Integer.parseInt(quantity_value);
            Cart new_product = new Cart(id, quantity);
            return new_product;
        }catch(NumberFormatException e){
            Cart new_product = new Cart(Integer.parseInt(id_product), 0);
            return new_product;
        }
    }

    private boolean validateQuantity(Cart product){
        if(product.getQuantity() > 0){
            return true;
        }
        else{
            return false;
        }
    }

}

