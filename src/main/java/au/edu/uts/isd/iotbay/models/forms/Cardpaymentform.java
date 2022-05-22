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
    private String  card_name;
   
    @NotNull
    @Size (max = 16)
    private String card_number;

    @NotNull
    @Size (max = 3)
    private String card_cvv;
   
    @NotNull
    @Max (value = 2) 
    private int card_expiry_month;
    
    @NotNull
    @Max (value = 2)
    private int card_expiry_year ; 

}
