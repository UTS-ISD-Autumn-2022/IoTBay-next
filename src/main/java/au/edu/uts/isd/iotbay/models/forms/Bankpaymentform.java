package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Bankpaymentform {
    
   

    @NotNull
    @Size(max = 255)
    private String  _BANK_ACCOUNT_NAME;
    
    @NotNull
    @Size(max = 13)
    private int _BANK_ACCOUNT_NUMBER;
    
    @NotNull
    @Size(max = 3)
    private int _BSB_NUMBER;

    /*public String get_BANK_NAME() {
        return _BANK_ACCOUNT_NAME;
    }

    public int get_BANK_ACCOUNT_NUMBER() {
        return _BANK_ACCOUNT_NUMBER;
    }

    public int get_BSB_NUMBER() {
        return _BSB_NUMBER;
    }

   */
    }
   
   

