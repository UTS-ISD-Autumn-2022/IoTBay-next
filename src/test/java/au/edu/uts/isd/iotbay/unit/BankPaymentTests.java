package au.edu.uts.isd.iotbay.unit;

import au.edu.uts.isd.iotbay.controllers.BankPaymentController;
import au.edu.uts.isd.iotbay.models.dao.BankPaymentDao;
import au.edu.uts.isd.iotbay.models.dao.BankPaymentManager;
import au.edu.uts.isd.iotbay.models.data.Bank_Payment;
import au.edu.uts.isd.iotbay.models.forms.Bankpaymentform;
import ch.qos.logback.classic.Logger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import javax.validation.Validator;

import org.hibernate.validator.internal.util.logging.LoggerFactory;

@SpringBootTest
@WebMvcTest(BankPaymentController.class)
public class BankPaymentTests {
    
    @Autowired
    Validator validator;

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private BankPaymentManager bankPaymentManager;

    @Test
    @DisplayName("P-1: save bank payment details")
    void TestsaveBank_Payment() {
        Bank_Payment bank_Payment = new Bank_Payment(null, "john citizen" , 123456 , 654321);

        int result = BankPaymentDao.saveBank_Payment(bank_Payment);
        assertTrue( result > 0);
    }

        
    }

    @Test
    @DisplayName("P-2: update bank payment details")
    void testUpdateBank_Payment() {
        fail("Unimplemented");
    }
    @Test
    @DisplayName("P-3: get bank payment details")
    void testgetBank_Payment() {
        fail("Unimplemented");
    }

    @Test
    @DisplayName("P-4: delete bank payment details")
    void testdeleteBank_Payment() {
        int result = BankPaymentDao.deleteBank_Payment(bank_Payment);
        assertTrue( result > 0);
    }

}
