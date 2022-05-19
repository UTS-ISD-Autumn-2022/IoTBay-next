package au.edu.uts.isd.iotbay.unit;

import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.*;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@WebMvcTest(User)
public class ProfileTests {
    final private Logger log = LoggerFactory.getLogger(ProfileTests.class);

    /**
     *
     * <h3>User Story:</h3>
     *
     * <ul>
     *     <li><b>Given:</b> an anonymous user enters registration details</li>
     *     <li><b>When:</b> </li>
     * </ul>
     *
     * @result form has invalid field errors on null fields
     */
    @Test
    @DisplayName("Test RegisterForm model for invalid field sizes")
    void testNullFields() {
    }

}
