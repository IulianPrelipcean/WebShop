package servlets;

import beans.category.Category;
import beans.category.CategoryList;
import beans.product.Product;
import beans.product.ProductList;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class AddProduct extends HelloServlet{

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException {

        File file_product = new File("/home/iulian0user/Media/work/Interships/YoungCulture/WebShop/WebShop_v3/products.xml");
        File file_category = new File("/home/iulian0user/Media/work/Interships/YoungCulture/WebShop/WebShop_v3/category.xml");

        if (!file_product.exists()) {
            httpServletResponse.sendError(404, "File not found!");
            return;
        }

        Product product_1 = new Product(1, "produs1", "foarte bun", 1, 20, 10);
        Product product_2 = new Product(2, "produs2", "foarte rau", 2, 40, 15);
        Product product_3 = new Product(3, "produs3", "foarte satisfacator", 2, 30, 20);

        ProductList productList = new ProductList();
        productList.addProduct(product_1);
        productList.addProduct(product_2);
        productList.addProduct(product_3);


        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(file_product, productList);




        Category category_1 = new Category(1, "laptop");
        Category category_2 = new Category(2, "TV");
        Category category_3 = new Category(3, "phone");

        CategoryList categoryList = new CategoryList();
        categoryList.addCategory(category_1);
        categoryList.addCategory(category_2);
        categoryList.addCategory(category_3);

        xmlMapper.writeValue(file_category, categoryList);



        httpServletResponse.getWriter().print("\n\nProducts added");
    }


}
