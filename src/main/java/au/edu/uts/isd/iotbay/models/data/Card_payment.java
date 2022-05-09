package au.edu.uts.isd.iotbay.models.data;

import java.sql.Date;

public class Card_payment  implements java.io.Serializable {
    final int _id;
    String _card_name ;
    char _card_number ;
    char _card_cvc ;
    Date _card_expiry_Date;


    public Card_payment (int id,String card_name ,char card_number ,char card_cvc ,Date card_expiry_Date){
_id = id;
_card_name=card_name;
_card_number=card_number;
_card_cvc=card_cvc;
_card_expiry_Date=card_expiry_Date;
    }


    public int get_id() {
        return  _id;
    }


    public String get_card_name() {
        return _card_name;
    }

    public void set_card_name(String card_name) {
       _card_name = card_name;
    }

    public char get_card_number() {
       return  _card_number;
    }

    public void set_card_number(char card_number) {
        _card_number = card_number;
    }

    public char get_card_cvc() {
       return  _card_cvc;
    }

    public void set_card_cvc(char card_cvc) {
        _card_cvc = card_cvc;
    }

    public Date get_card_expiry_Date() {
        return _card_expiry_Date;
    }

    public void set_card_expiry_Date(Date card_expiry_Date) {
        _card_expiry_Date = card_expiry_Date;
    }
 
}
