package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;



import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Cardpaymentform {
    @NotNull
    @Size (max = 255)
    private String  _card_name;
   
    @NotNull
    @Size (max = 16)
    private int _card_number;

    @NotNull
    @Size (max = 3)
    private int _card_cvv;
   
    @NotNull
    @Max (value = 2) 
    private int _card_expiry_month;
    
    @NotNull
    @Max (value = 2)
    private int _card_expiry_year ;

    /*public String get_card_name() {
        return _card_name;
    }

    public int get_card_number() {
        return _card_number;
    }

    public int get_card_cvc() {
        return _card_cvv;
    }

    public int get_card_expiry_month() {
        return _card_expiry_month;
    }

    public int get_card__expiry_year() {
        return _card_expiry_year;
    } 
*/
}
