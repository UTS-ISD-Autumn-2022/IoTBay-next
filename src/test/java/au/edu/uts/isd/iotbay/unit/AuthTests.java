package au.edu.uts.isd.iotbay.unit;

import au.edu.uts.isd.iotbay.controllers.AuthController;
import au.edu.uts.isd.iotbay.models.dao.UserManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@WebMvcTest(AuthController.class)
public class AuthTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    UserManager userManager;

    @Test
    @DisplayName("UA-1: Authentication Test")
    void testAuthentication() {
        fail("Unimplemented");
    }

    @Test
    @DisplayName("UA-2: Authorisation Test")
    void testAuthorisation() {
        fail("Unimplemented");
    }

    @Test
    @DisplayName("UA-3: Read Customer Profile Test")
    void testViewCustomer() {
        fail("Unimplemented");
    }

    @Test
    @DisplayName("UA-4: Customer Registration Test")
    void testRegister() {
        fail("Unimplemented");
    }
}
