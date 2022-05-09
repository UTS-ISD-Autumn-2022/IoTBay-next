package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class CardPaymentForm {
    @Max(value = 255)
    private String  card_name;
    
    @max(value = 16)
    private String card_number;

    @Max(value = 3)
    private String card_cvv;
   
    private Date card_expiry_Date ;

}
