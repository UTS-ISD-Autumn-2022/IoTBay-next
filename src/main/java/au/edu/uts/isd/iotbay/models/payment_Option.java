package au.edu.uts.isd.iotbay.models;

import java.io.Serializable;

public class payment_Option implements Serializable {
    final int _id;
    final int _customer_id;

    public payment_Option(int id, int customer_id) {
        _id = id;
        _customer_id = customer_id;
    }

    public int get_id() {
        return this._id;
    }


    public int get_customer_id() {
        return this._customer_id;
    }
    
}