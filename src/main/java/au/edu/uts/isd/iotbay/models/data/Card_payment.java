package au.edu.uts.isd.iotbay.models.data;

import au.edu.uts.isd.iotbay.models.forms.Cardpaymentform;
import lombok.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Card_payment{
    final private UUID _id;
    private String _card_name ;
    private int _card_number ;
    private int _card_cvc ;
   private int _card_expiry_month;
   private int _card_expiry_year;


public Card_payment (Cardpaymentform cardpaymentform){
    
_id = UUID.randomUUID();
_card_name = cardpaymentform.get_card_name();
_card_number = cardpaymentform.get_card_number();
_card_cvc = cardpaymentform.get_card_cvc();
_card_expiry_month = cardpaymentform.get_card_expiry_month();
_card_expiry_year = cardpaymentform.get_card_expiry_year();
       
    }   
}
