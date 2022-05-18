package au.edu.uts.isd.iotbay.models.data;



public class Card_payment  implements java.io.Serializable {
    final int _id;
    String _card_name ;
    int _card_number ;
    int _card_cvc ;
   int _card_expiry_month;
   int _card_expiry_year;


    public Card_payment (int id,String card_name ,int card_number ,int card_cvc ,int card_expiry_month , int card_expiry_year){
_id = id;
_card_name=card_name;
_card_number=card_number;
_card_cvc=card_cvc;
_card_expiry_month=card_expiry_month;
_card_expiry_year=card_expiry_year;
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

    public int get_card_number() {
       return  _card_number;
    }

    public void set_card_number(int card_number) {
        _card_number = card_number;
    }

    public int get_card_cvc() {
       return  _card_cvc;
    }

    public void set_card_cvc(int card_cvc) {
        _card_cvc = card_cvc;
    }

    public int get_card_expiry_month() {
        return _card_expiry_month;
    }

    public void set_card_expiry_month(int card_expiry_month) {
        _card_expiry_month = card_expiry_month;
    }
    public int get_card_expiry_year() {
        return _card_expiry_year;
    }

    public void set_card_expiry_year(int card_expiry_year) {
        _card_expiry_year = card_expiry_year;
    }
 
}
