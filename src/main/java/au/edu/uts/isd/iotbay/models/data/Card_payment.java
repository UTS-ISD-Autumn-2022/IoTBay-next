package au.edu.uts.isd.iotbay.models.data;

import java.util.UUID;

import au.edu.uts.isd.iotbay.models.forms.Cardpaymentform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;




public class Card_payment  {
    UUID _id;
    String _card_name ;
    int _card_number ;
    int _card_cvc ;
   int _card_expiry_month;
   int _card_expiry_year;


    public Card_payment(UUID _id, String _card_name, int _card_number, int _card_cvc, int _card_expiry_month, int _card_expiry_year) {
        this._id = _id;
        this._card_name = _card_name;
        this._card_number = _card_number;
        this._card_cvc = _card_cvc;
        this._card_expiry_month = _card_expiry_month;
        this._card_expiry_year = _card_expiry_year;
    }




         /*   public Card_payment (Cardpaymentform cardpaymentform){
                _id = UUID.randomUUID();
                _card_name = cardpaymentform.get_card_name();
                _card_number=cardpaymentform.get_card_number();
                _card_cvc=cardpaymentform.get_card_cvc();
                _card_expiry_month=cardpaymentform.get_card_expiry_month();
                _card_expiry_year=cardpaymentform.get_card__expiry_year();

            } */

    public UUID get_id() {
        return this._id;
    }



    public String get_card_name() {
        return this._card_name;
    }

    public void set_card_name(String _card_name) {
        this._card_name = _card_name;
    }

    public int get_card_number() {
        return this._card_number;
    }

    public void set_card_number(int _card_number) {
        this._card_number = _card_number;
    }

    public int get_card_cvc() {
        return this._card_cvc;
    }

    public void set_card_cvc(int _card_cvc) {
        this._card_cvc = _card_cvc;
    }

    public int get_card_expiry_month() {
        return this._card_expiry_month;
    }

    public void set_card_expiry_month(int _card_expiry_month) {
        this._card_expiry_month = _card_expiry_month;
    }

    public int get_card_expiry_year() {
        return this._card_expiry_year;
    }

    public void set_card_expiry_year(int _card_expiry_year) {
        this._card_expiry_year = _card_expiry_year;
    }


}
