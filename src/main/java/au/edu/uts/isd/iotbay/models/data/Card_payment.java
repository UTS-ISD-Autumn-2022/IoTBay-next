package au.edu.uts.isd.iotbay.models.data;

import java.util.UUID;

import au.edu.uts.isd.iotbay.models.forms.Cardpaymentform;




public class Card_payment  implements java.io.Serializable {
    UUID _id;
    String _card_name ;
    int _card_number ;
    int _card_cvc ;
   int _card_expiry_month;
   int _card_expiry_year;


    public Card_payment (UUID _id,String card_name ,int card_number ,int card_cvc ,int card_expiry_month , int card_expiry_year){

        this(card_name , card_number , card_cvc ,card_expiry_month , card_expiry_year);
        this._id = _id;


    }

    public Card_payment (String card_name ,int card_number ,int card_cvc ,int card_expiry_month , int card_expiry_year){
        
       this. _card_name=card_name;
       this. _card_number=card_number;
       this. _card_cvc=card_cvc;
       this. _card_expiry_month=card_expiry_month;
       this._card_expiry_year=card_expiry_year;
            }

public Card_payment (Cardpaymentform cardpaymentform){

     _id=UUID.randomUUID();
     _card_name=cardpaymentform.get_card_name() ;
     _card_number=cardpaymentform.get_card_number() ;
     _card_cvc =cardpaymentform.get_card_cvc();
    _card_expiry_month=cardpaymentform.get_card_expiry_month();
    _card_expiry_year=cardpaymentform.get_card__expiry_year();
}

}
