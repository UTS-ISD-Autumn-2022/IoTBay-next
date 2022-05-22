package au.edu.uts.isd.iotbay.models.forms;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Bankpaymentform implements Serializable {
    

    
    @NotNull
    @Size(max = 255)
    private String  _BANK_NAME;
    
    @NotNull
    @Size(max = 13)
    private int _BANK_ACCOUNT_NUMBER;
    
    @NotNull
    @Size(max = 3)
    private int _BSB_NUMBER;

   
   

}
   

