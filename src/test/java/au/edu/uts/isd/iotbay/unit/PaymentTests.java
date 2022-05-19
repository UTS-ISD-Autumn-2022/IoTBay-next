package au.edu.uts.isd.iotbay.unit;

import au.edu.uts.isd.iotbay.controllers.PaymentController;
import au.edu.uts.isd.iotbay.models.dao.BankPaymentManager;
import au.edu.uts.isd.iotbay.models.dao.CardPaymentManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@WebMvcTest(PaymentController.class)
public class PaymentTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardPaymentManager cardPaymentManager;

    @MockBean
    private BankPaymentManager bankPaymentManager;

    @Test
    @DisplayName("P-1: delete payment details")
    void testDeletePaymentDetails() {
        fail("Unimplemented");
    }

    @Test
    @DisplayName("P-2: update payment details")
    void testUpdatePaymentDetails() {
        fail("Unimplemented");
    }
    @Test
    @DisplayName("P-3: pay with saved payment details")
    void testPayWithSavedDetails() {
        fail("Unimplemented");
    }

    @Test
    @DisplayName("P-5: verify customers payment details")
    void testVerifyCustomersPaymentDetails() {
        fail("Unimplemented");
    }

    @Test
    @DisplayName("P-6: handle when users payment details has been declined")
    void testHandleDeclinedPaymentDetails() {
        fail("Unimplemented");
    }
}
