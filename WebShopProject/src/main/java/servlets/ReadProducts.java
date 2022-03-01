package servlets;

import beans.category.Category;
import beans.category.CategoryList;
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

public class ReadProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        File file_product = new File("/opt/tomcat/webapps/db_files/products.xml");
        File file_category = new File("/opt/tomcat/webapps/db_files/category.xml");

        XmlMapper xmlMapper = new XmlMapper();

//        if (!file_product.exists() && !file_category.exists()) {
//            response.sendError(404, "File not found!");
//        }


        try {
            int category_id = 0;
            String category_type = request.getParameter("category_type");
            CategoryList category_list = xmlMapper.readValue(file_category, CategoryList.class);
            ProductList productListRead = xmlMapper.readValue(file_product, ProductList.class);

            if (category_type == null || category_type.equals("All Product")) {
                request.setAttribute("productList", productListRead.getProductList());
            } else {
                for (Category category : category_list.getCategory()) {
                    if (category_type.equals(category.getCategory_name())) {
                        category_id = category.getCategory_id();
                    }
                }

                ProductList productListSorted = new ProductList();
                for (Product product : productListRead.getProductList()) {
                    if (category_id == product.getCategory_id()) {
                        productListSorted.addProduct(product);
                    }
                }
                request.setAttribute("productList", productListSorted.getProductList());
            }
            request.setAttribute("selected_category", category_type);
            request.setAttribute("category_list", category_list.getCategory());
        }catch(FileNotFoundException e){
            CategoryList category_list = new CategoryList();
            ProductList product_list = new ProductList();
            request.setAttribute("productList", product_list.getProductList());
            request.setAttribute("selected_category", "All Product");
            request.setAttribute("category_list", category_list.getCategory());
        }

        request.getRequestDispatcher("./index.jsp").forward(request, response);
    }

}


