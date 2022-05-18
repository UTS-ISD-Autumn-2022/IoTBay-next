package au.edu.uts.isd.iotbay.unit;

import au.edu.uts.isd.iotbay.models.forms.Bankpaymentform;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.*;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class Bank_payment_formTest {
    final Logger log = LoggerFactory.getLogger(Bank_payment_formTest.class);

    @Autowired
    Validator validator;

    @Test
    @DisplayName("Test RegisterForm Model for null field validations")
    void testNullFields() {
        Bankpaymentform form = new Bankpaymentform();

        DataBinder binder = new DataBinder(form);
        binder.addValidators(validator);

        binder.validate();

        BindingResult result = binder.getBindingResult();

        assertTrue(result.hasErrors());

        assertNull(form.get_card_name());
        assertTrue(result.hasFieldErrors("card_name"));

        assertNull(form.get_card_number());
        assertTrue(result.hasFieldErrors("card_number"));

        assertNull(form.get_card_cvc());
        assertTrue(result.hasFieldErrors("card_cvc"));

        assertNull(form.get_card_expiry_month());
        assertTrue(result.hasFieldErrors("card_expiry_month"));

        assertNull(form.get_card_expiry_year());
        assertTrue(result.hasFieldErrors("card_expiry_year"));

     
    }

    @Test
    @DisplayName("Test RegisterForm model for invalid field sizes")
    void testInvalidSizes() {
        Bankpaymentform form = new Bankpaymentform();

        DataBinder binder = new DataBinder(form);
        binder.addValidators(validator);

        binder.validate();

        BindingResult result = binder.getBindingResult();

        assertTrue(result.hasErrors());
        assertNull(form.get_card_name());
        assertTrue(result.hasFieldErrors("card_name"));

        assertNull(form.get_card_number());
        assertTrue(result.hasFieldErrors("card_number"));

        assertNull(form.get_card_cvc());
        assertTrue(result.hasFieldErrors("card_cvc"));

        assertNull(form.get_card_expiry_month());
        assertTrue(result.hasFieldErrors("card_expiry_month"));

        assertNull(form.get_card_expiry_year());
        assertTrue(result.hasFieldErrors("card_expiry_year"));
    }