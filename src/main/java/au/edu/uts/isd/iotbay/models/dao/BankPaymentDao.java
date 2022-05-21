package au.edu.uts.isd.iotbay.models.dao;   
   


import java.util.UUID;

import au.edu.uts.isd.iotbay.models.data.Bank_Payment;
   
public interface BankPaymentDao{   


public int saveBank_Payment (Bank_Payment bank_Payment);

public int UpdateBank_Payment (Bank_Payment bank_Payment);

public Bank_Payment getBank_Payment(UUID _id);

public int deleteBank_Payment(UUID _id);





}