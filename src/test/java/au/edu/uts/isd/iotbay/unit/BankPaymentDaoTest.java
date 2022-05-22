/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package au.edu.uts.isd.iotbay.models.dao;

import au.edu.uts.isd.iotbay.models.dao.BankPaymentDao;
import au.edu.uts.isd.iotbay.models.dao.Bankpaymentimp;
import au.edu.uts.isd.iotbay.models.data.Bank_Payment;
import au.edu.uts.isd.iotbay.models.forms.Bankpaymentform;
import static java.lang.Math.log;
import static java.lang.StrictMath.log;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BankPaymentDaoTest {
    final private Logger log = LoggerFactory.getLogger(BankPaymentDaoTest.class);
    @Autowired
    private MockMvc mvc;

    @MockBean
    private Bankpaymentimp bankpaymentimp;
    
    public BankPaymentDaoTest() {
        
    }

    @Test
    public void testSaveBank_Payment() {
        System.out.println("saveBank_Payment");
        Bankpaymentform bankpaymentform = null;
        BankPaymentDao instance = new Bankpaymentimp();
        int expResult = 0;
        int result = instance.saveBank_Payment(bankpaymentform);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateBank_Payment()throws Exception {
       log.info(" Update Customer Details Test");
       final Bankpaymentform form = new Bankpaymentform(UUID.randomUUID());
       
       
    }

    @Test
    @DisplayName( "Get Bank Payment Details Test")
    public void testGetBank_Payment() throws Exception {
      log.info("view Bank Payment details Test");
         final Bank_Payment bank_payment = new Bank_Payment(UUID.randomUUID());
        Bank_Payment.setBank_NAME("John Citizen");
        Bank_Payment.setBANK_ACCOUNT_NUMBER("123456");
        Bank_Payment.setBSB_NUMBER("654321");
       

        final Bank_Payment bank_payment= new Bank_Payment(UUID.randomUUID(), bank_payment);

        when(userManager.fetchCustomerByUsername(Bank_Payment.getUsername())).thenReturn(customer);

        mvc.perform(get("/profile").with(user("user_name").roles("CUSTOMER")))
                .andExpect(status().isOk())
                .andExpect(model().attribute("customer", customer))
                .andExpect(view().name("profile/index"));
      
       
      
    }

    @Test
    @DisplayName("Delete Bank Payment Details")
    public void testDeleteBank_Payment() throws Exception {
        log.info(" delete Bank Details Test");
                mvc.perform(post("/profile/delete/fakeuser")
                .with(csrf()).with(Bank_Payment("fakeuser").roles("CUSTOMER")))
                .andExpect(redirectedUrl("/logout"))
                .andExpect(status().isTemporaryRedirect());
    }

    
}