package beans.category;

import java.util.ArrayList;
import java.util.List;

public class CategoryList implements java.io.Serializable{
    private List<Category> category_list;

    public CategoryList() {
        this.category_list = new ArrayList<>();
    }

    public CategoryList(List<Category> category) {
        this.category_list = category;
    }

    public List<Category> getCategory() {
        return category_list;
    }

    public void setCategory(List<Category> category) {
        this.category_list = category;
    }

    public void addCategory(Category category){
        this.category_list.add(category);
    }
}
