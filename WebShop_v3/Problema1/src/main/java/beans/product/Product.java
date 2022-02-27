package beans.product;

public class Product implements java.io.Serializable{
    private int product_id = 0;
    private String name = null;
    private String description = null;
    private int category_id = 0;
    private float price = 0;
    private int stock_available = 0;

    public Product(){
    }

    public Product(int product_id, String name, String description, int category_id, float price, int stock_available) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.category_id = category_id;
        this.price = price;
        this.stock_available = stock_available;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public float getPrice() {
        return price;
    }

    public int getStock_available() {
        return stock_available;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStock_available(int stock_available) {
        this.stock_available = stock_available;
    }
}
