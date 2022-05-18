package au.edu.uts.isd.iotbay.unit;

import au.edu.uts.isd.iotbay.models.forms.Cardpaymentform;

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
public class Card_payment_formTest {
    final Logger log = LoggerFactory.getLogger(Card_payment_formTest.class);

    @Autowired
    Validator validator;

    @Test
    @DisplayName("Test RegisterForm Model for null field validations")
    void testNullFields() {
        Cardpaymentform form = new Cardpaymentform();

        DataBinder binder = new DataBinder(form);
        binder.addValidators(validator);

        binder.validate();

        BindingResult result = binder.getBindingResult();

        assertTrue(result.hasErrors());

        assertNull(form.get_BANK_NAME());
        assertTrue(result.hasFieldErrors("BANK_NAME"));

        assertNull(form.get_BANK_ACCOUNT_NUMBER());
        assertTrue(result.hasFieldErrors("BANK_ACCOUNT_NUMBER"));

        assertNull(form.get_BSB_NUMBER());
        assertTrue(result.hasFieldErrors("BSB_NUMBER"));

     
    }

    @Test
    @DisplayName("Test RegisterForm model for invalid field sizes")
    void testInvalidSizes() {
        Cardpaymentform form = new Cardpaymentform();

        DataBinder binder = new DataBinder(form);
        binder.addValidators(validator);

        binder.validate();

        BindingResult result = binder.getBindingResult();

        assertTrue(result.hasErrors());
        assertNull(form.get_BANK_NAME());
        assertTrue(result.hasFieldErrors("BANK_NAME"));

        assertNull(form.get_BANK_ACCOUNT_NUMBER());
        assertTrue(result.hasFieldErrors("BANK_ACCOUNT_NUMBER"));

        assertNull(form.get_BSB_NUMBER());
        assertTrue(result.hasFieldErrors("BSB_NUMBER"));
    }