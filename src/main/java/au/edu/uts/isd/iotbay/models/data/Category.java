package au.edu.uts.isd.iotbay.models.data;


import lombok.Data;

@Data// Java bean class, just like in the labs
public class Category implements java.io.Serializable {
    final int _id;
    String _name;
    String _description;
    String _imgUrl;
}
