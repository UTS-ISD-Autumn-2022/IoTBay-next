package au.edu.uts.isd.iotbay.unit;

import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
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
public class RegisterFormValidationsTests {
    final Logger log = LoggerFactory.getLogger(RegisterFormValidationsTests.class);

    @Autowired
    Validator validator;

    @Test
    @DisplayName("Test RegisterForm Model for null field validations")
    void testNullFields() {
        RegisterForm form = new RegisterForm();

        DataBinder binder = new DataBinder(form);
        binder.addValidators(validator);

        binder.validate();

        BindingResult result = binder.getBindingResult();

        assertTrue(result.hasErrors());

        assertNull(form.getUsername());
        assertTrue(result.hasFieldErrors("username"));

        assertNull(form.getPassword());
        assertTrue(result.hasFieldErrors("password"));

        assertNull(form.getPasswordVerification());
        assertTrue(result.hasFieldErrors("passwordVerification"));

        assertNull(form.getFirstName());
        assertTrue(result.hasFieldErrors("firstName"));

        assertNull(form.getLastName());
        assertTrue(result.hasFieldErrors("lastName"));

        assertNull(form.getEmail());
        assertTrue(result.hasFieldErrors("email"));
    }

    @Test
    @DisplayName("Test RegisterForm model for invalid field sizes")
    void testInvalidSizes() {
        RegisterForm form = new RegisterForm();

        DataBinder binder = new DataBinder(form);
        binder.addValidators(validator);

        binder.validate();

        BindingResult result = binder.getBindingResult();

        assertTrue(result.hasErrors());

        assertNull(form.getUsername());
        assertTrue(result.hasFieldErrors("username"));

        assertNull(form.getPassword());
        assertTrue(result.hasFieldErrors("password"));

        assertNull(form.getPasswordVerification());
        assertTrue(result.hasFieldErrors("passwordVerification"));

        assertNull(form.getFirstName());
        assertTrue(result.hasFieldErrors("firstName"));

        assertNull(form.getLastName());
        assertTrue(result.hasFieldErrors("lastName"));

        assertNull(form.getEmail());
        assertTrue(result.hasFieldErrors("email"));
    }
}
