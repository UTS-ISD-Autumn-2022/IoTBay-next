package au.edu.uts.isd.iotbay.models.data;

import java.util.UUID;

import au.edu.uts.isd.iotbay.models.forms.Bankpaymentform;


import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;


public class Bank_Payment implements java.io.Serializable {
 UUID _id;
String _BANK_NAME;
int  _BANK_ACCOUNT_NUMBER; 
int  _BSB_NUMBER; 

public Bank_Payment (UUID _id , String BANK_NAME , int BANK_ACCOUNT_NUMBER , int BSB_NUMBER ) {
    
    this(BANK_NAME, BANK_ACCOUNT_NUMBER, BSB_NUMBER) ;
    this._id = _id;
}

public Bank_Payment (String BANK_NAME , int BANK_ACCOUNT_NUMBER , int BSB_NUMBER ) {

    this._BANK_NAME =  BANK_NAME;
    this._BANK_ACCOUNT_NUMBER = BANK_ACCOUNT_NUMBER; 
    this._BSB_NUMBER = BSB_NUMBER ;
}

public Bank_Payment(Bankpaymentform bankpaymentform) {
    _id = UUID.randomUUID();

    _BANK_NAME = bankpaymentform.get_BANK_NAME();
    _BANK_ACCOUNT_NUMBER = bankpaymentform.get_BANK_ACCOUNT_NUMBER();
    _BSB_NUMBER = bankpaymentform.get_BSB_NUMBER();
}
}



