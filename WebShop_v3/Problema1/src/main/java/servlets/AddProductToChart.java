package servlets;

import beans.cart.Cart;
import beans.cart.CartList;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class AddProductToChart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        File file = new File("/home/iulian0user/Media/work/Interships/YoungCulture/WebShop/WebShop_v3/cart.xml");
        XmlMapper xmlMapper = new XmlMapper();

        String id_product = request.getParameter("product_id");
        String quantity_value = request.getParameter("quantity_value");

        Cart new_product = new Cart(Integer.parseInt(id_product), Integer.parseInt(quantity_value));

        try {
            CartList cartList = xmlMapper.readValue(file, CartList.class);
            cartList.getCartList().add(new_product);
            xmlMapper.writeValue(file, cartList);
        }catch(Exception e){
            response.getWriter().print(e.getMessage());
            CartList cartList = new CartList();
            cartList.getCartList().add(new_product);
            xmlMapper.writeValue(file, cartList);
        }

        response.sendRedirect("http://localhost:8080/JEE-Test_lab1/home");
    }

}

