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
import java.io.IOException;

public class AddProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException {

        File file_product = new File("/opt/tomcat/webapps/db_files/products.xml");
        File file_category = new File("/opt/tomcat/webapps/db_files/category.xml");

        XmlMapper xmlMapper = new XmlMapper();

        try {
            // populate product file
            Product product_1 = new Product(1, "Lenovo", "foarte bun", 2, 20, 10);
            Product product_2 = new Product(2, "MacBook", "foarte bun", 2, 40, 15);
            Product product_3 = new Product(3, "Samsung", "foarte bun", 4, 30, 20);
            Product product_4 = new Product(4, "IPhone", "foarte bun", 4, 30, 20);
            Product product_5 = new Product(5, "Philips", "foarte bun", 3, 30, 20);
            Product product_6 = new Product(6, "LG", "foarte bun", 3, 30, 20);

            ProductList productList = new ProductList();
            productList.addProduct(product_1);
            productList.addProduct(product_2);
            productList.addProduct(product_3);
            productList.addProduct(product_4);
            productList.addProduct(product_5);
            productList.addProduct(product_6);

            xmlMapper.writeValue(file_product, productList);


            // populate category file
            Category category_1 = new Category(1, "All Product");
            Category category_2 = new Category(2, "laptop");
            Category category_3 = new Category(3, "TV");
            Category category_4 = new Category(4, "phone");

            CategoryList categoryList = new CategoryList();
            categoryList.addCategory(category_1);
            categoryList.addCategory(category_2);
            categoryList.addCategory(category_3);
            categoryList.addCategory(category_4);

            xmlMapper.writeValue(file_category, categoryList);
        }catch(Exception e){
            httpServletResponse.sendError(404, "Failed to populate files!");
        }

        httpServletResponse.getWriter().print("\n\nProducts added");
    }


}
