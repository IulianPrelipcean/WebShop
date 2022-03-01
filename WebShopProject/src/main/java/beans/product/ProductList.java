package beans.product;

import java.util.ArrayList;
import java.util.List;

public class ProductList implements java.io.Serializable{
    private List<Product> productList;

    public ProductList(){
        productList = new ArrayList<>();
    }

    public List<Product> getProductList(){
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product){
        productList.add(product);
    }


}
