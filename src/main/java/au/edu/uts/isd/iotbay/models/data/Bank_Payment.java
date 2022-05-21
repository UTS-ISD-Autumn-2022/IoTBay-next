package au.edu.uts.isd.iotbay.models.data;

import java.util.UUID;

import au.edu.uts.isd.iotbay.models.forms.Bankpaymentform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;





public class Bank_Payment {
UUID _id;
String _BANK_NAME;
int  _BANK_ACCOUNT_NUMBER; 
int  _BSB_NUMBER; 


    public Bank_Payment(UUID _id, String _BANK_NAME, int _BANK_ACCOUNT_NUMBER, int _BSB_NUMBER) {
        this._id = _id;
        this._BANK_NAME = _BANK_NAME;
        this._BANK_ACCOUNT_NUMBER = _BANK_ACCOUNT_NUMBER;
        this._BSB_NUMBER = _BSB_NUMBER;
    }


/*public Bank_Payment(Bankpaymentform bankpaymentform){
    _id = UUID.randomUUID();
    _BANK_NAME = bankpaymentform.get_BANK_NAME();
    _BANK_ACCOUNT_NUMBER = bankpaymentform.get_BANK_ACCOUNT_NUMBER();
    _BSB_NUMBER = bankpaymentform.get_BSB_NUMBER();
}
*/






    public UUID get_id() {
        return this._id;
    }

 

    public String get_BANK_NAME() {
        return this._BANK_NAME;
    }

    public void set_BANK_NAME(String _BANK_NAME) {
        this._BANK_NAME = _BANK_NAME;
    }

    public int get_BANK_ACCOUNT_NUMBER() {
        return this._BANK_ACCOUNT_NUMBER;
    }

    public void set_BANK_ACCOUNT_NUMBER(int _BANK_ACCOUNT_NUMBER) {
        this._BANK_ACCOUNT_NUMBER = _BANK_ACCOUNT_NUMBER;
    }

    public int get_BSB_NUMBER() {
        return this._BSB_NUMBER;
    }

    public void set_BSB_NUMBER(int _BSB_NUMBER) {
        this._BSB_NUMBER = _BSB_NUMBER;
    }
}



