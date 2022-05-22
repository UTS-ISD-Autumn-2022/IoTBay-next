package au.edu.uts.isd.iotbay.models.forms;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Cardpaymentform implements Serializable {
    

    
    @NotNull
    @Size (max = 255)
    private String  _card_name;
   
    @NotNull
    @Size (max = 16)
    private int _card_number;

    @NotNull
    @Size (max = 3)
    private int _card_cvc;
   
    @NotNull
    @Max (value = 2) 
    private int _card_expiry_month;
    
    @NotNull
    @Max (value = 2)
    private int _card_expiry_year ; 

}
