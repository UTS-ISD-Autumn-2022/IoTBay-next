package au.edu.uts.isd.iotbay.models.data;

// Java bean class, just like in the labs
public class Category implements java.io.Serializable {
    final int _id;
    String _name;
    String _description;
    String _imgUrl;

    public Category(int id, String name, String description, String imgUrl) {
        _id = id;
        _name = name;
        _description = description;
        _imgUrl = imgUrl;
    }

    public int getId() {
        return _id;
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

    public String getImgUrl() {
        return _imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        _imgUrl = imgUrl;
    }
}
