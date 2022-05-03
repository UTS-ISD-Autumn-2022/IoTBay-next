package au.edu.uts.isd.iotbay.models.data;

public class Product implements java.io.Serializable {
    final int _id;
    Category _category;
    String _name;
    String _description;
    Iterable<String> _productImages;
    int _stockLevel;
    int _orderLevel;
    float _price;

    public Product(int id, Category category, String name, String description, Iterable<String> productImages, int stockLevel, int orderLevel, float price) {
        _id = id;
        _category = category;
        _name = name;
        _description = description;
        _productImages = productImages;
        _stockLevel = stockLevel;
        _orderLevel = orderLevel;
        _price = price;
    }

    public int getId() {
        return _id;
    }

    public Category getCategory() {
        return _category;
    }

    public void setCategory(Category category) {
        _category = category;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public Iterable<String> getProductImages() {
        return _productImages;
    }

    public void setProductImages(Iterable<String> productImages) {
        _productImages = productImages;
    }

    public int getStockLevel() {
        return _stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        _stockLevel = stockLevel;
    }

    public int getOrderLevel() {
        return _orderLevel;
    }

    public void setOrderLevel(int orderLevel) {
        _orderLevel = orderLevel;
    }

    public float getPrice() {
        return _price;
    }

    public void setPrice(float price) {
        _price = price;
    }
}
