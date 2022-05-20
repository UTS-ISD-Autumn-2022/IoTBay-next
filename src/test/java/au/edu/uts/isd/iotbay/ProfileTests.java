package au.edu.uts.isd.iotbay;

import au.edu.uts.isd.iotbay.controllers.ProfileController;
import au.edu.uts.isd.iotbay.models.dao.UserManager;
import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.data.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.sql.DataSource;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/*

public class ProfileTests {
    final private Logger log = LoggerFactory.getLogger(ProfileTests.class);

    @MockBean
    private DataSource dataSource;

    @MockBean
    private UserManager userManager;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setup() {
        mvc = standaloneSetup(new ProfileController()).build();
    }

    /**
     * <h3>As a customer, I want to view my account details so that I can ensure they are valid</h3>
     *
     * <ul>
     *     <li><b>Given:</b> User is signed into an account with a customer role</li>
     *     <li><b>When:</b> User enters his profile</li>
     *     <li><b>Then:</b> The server responds with users details</li>
     * </ul>
     *
     * @result http: 200 OK, user details
     */
/*
    @Test
    @DisplayName("UA-4: Read Customer Profile Test")
    void testViewCustomer() throws Exception {
        final User user = new User(UUID.randomUUID());
        user.setEmail("email@email.org");
        user.setUsername("user_name");
        user.setFirstName("First");
        user.setLastName("Last");

        final Customer cust = new Customer(UUID.randomUUID(), user);

        given(userManager.fetchCustomerByUsername(user.getUsername())).willReturn(cust);

        mvc.perform(get("/profile")).andExpect(status().isOk());
    }

    /**
     * <h3>User Story:</h3>
     *
     * <ul>
     *     <li><b>Given:</b> an anonymous user enters registration details</li>
     *     <li><b>When:</b> </li>
     * </ul>
     *
     * @result form has invalid field errors on null fields
     */
/*
    @Test
    @DisplayName("Test RegisterForm model for invalid field sizes")
    void testNullFields() {
    }


}
*/
