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

public class ReadProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        File file_product = new File("/home/iulian0user/Media/work/Interships/YoungCulture/WebShop/WebShop_v3/products.xml");
        File file_category = new File("/home/iulian0user/Media/work/Interships/YoungCulture/WebShop/WebShop_v3/category.xml");
        XmlMapper xmlMapper = new XmlMapper();

        if (!file_product.exists() && !file_category.exists()) {
            response.sendError(404, "File not found!");
        }

        int category_id = 0;
        String category_type = request.getParameter("category_type");
        CategoryList category_list = xmlMapper.readValue(file_category, CategoryList.class);
        ProductList productListRead = xmlMapper.readValue(file_product, ProductList.class);

        //request.setAttribute("category", category_type);

        if(category_type != null){

            for(Category category: category_list.getCategory()){
                if(category_type.equals(category.getCategory_name())){
                    category_id = category.getCategory_id();
                }
            }

            ProductList productListSorted = new ProductList();
            for(Product product: productListRead.getProductList()){
                if(category_id == product.getCategory_id()){
                    productListSorted.addProduct(product);
                }
            }
            request.setAttribute("productList", productListSorted.getProductList());
        }
        else{
            request.setAttribute("productList", productListRead.getProductList());
        }

        request.getRequestDispatcher("./index.jsp").forward(request, response);
    }

}


