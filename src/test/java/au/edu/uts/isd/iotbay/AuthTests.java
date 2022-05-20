package au.edu.uts.isd.iotbay;

import au.edu.uts.isd.iotbay.models.dao.UserManager;
import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.data.User;
import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthTests {

    final Logger log = LoggerFactory.getLogger(AuthTests.class);

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserManager userManager;


    /**
     * <h3>As a registered account holder, I want to authenticate with IoTBay so that I can be granted permission to
     * use restricted services</h3>
     *
     * <ul>
     *     <li><b>Given:</b> User has registered an account</li>
     *     <li><b>When:</b> User enters valid login details</li>
     *     <li><b>Then:</b> The server redirects user to home screen with login cookie</li>
     * </ul>
     *
     * @result 302: Successful redirect
     */
    @Test
    @DisplayName("UA-1: Authentication Test")
    void testAuthentication() throws Exception {
        log.info("UA-1: Authentication Test");

        // test with a not real user
        mvc.perform(formLogin().user("not-real-user").password("i"))
                .andExpect(unauthenticated())
                .andExpect(redirectedUrl("/login?error"))
                .andExpect(status().isFound());


        // Test successful interaction
        mvc
                .perform(formLogin().user("admin").password("StrongPassword"))
                .andExpect(authenticated().withRoles("ADMIN"))
                .andExpect(redirectedUrl("/"))
                .andExpect(status().isFound());
    }

    /**
     * <h3>As a registered account holder, I want to access restricted parts of the app, so I can use those features</h3>
     *
     * <ul>
     *     <li><b>Given:</b> The user is logged in</li>
     *     <li><b>When:</b> The user tries to access a hidden portion of the app</li>
     *     <li><b>Then:</b> The server responds with 200 OK</li>
     * </ul>
     *
     * @result http: 200 OK
     */
    @Test
    @DisplayName("UA-2: Authorisation Test")
    void testAuthorisation() throws Exception {
        mvc.perform(get("/profile"))
                .andExpect(redirectedUrl("http://localhost/login"))
                .andExpect(status().isFound());

        mvc.perform(get("/profile").with(
                        user("admin")
                                .password("StrongPassword")
                                .roles("ADMIN")))
                .andExpect(status().isForbidden());

        mvc.perform(get("/admin").with(
                user("admin")
                        .password("StrongPassword")
                        .roles("ADMIN")))
                .andExpect(status().isOk());

    }

    /**
     * <h3>As a registered account holder, I want to access restricted parts of the app, so I can use those features</h3>
     *
     * <ul>
     *     <li><b>Given:</b> The user is logged in</li>
     *     <li><b>When:</b> The user tries to access a hidden portion of the app</li>
     *     <li><b>Then:</b> The server responds with 200 OK</li>
     * </ul>
     *
     * @result http: 200 OK
     */
    @Test
    @DisplayName("UA-3: Customer Registration Test")
    void testRegister() throws Exception {
        RegisterForm form = new RegisterForm();
        form.setUsername("testuser");
        form.setEmail("test@email.email");
        form.setFirstName("first");
        form.setLastName("last");
        form.setPassword("password123");
        form.setPasswordVerification("password123");

        User user = new User(form);

        Customer customer = new Customer(user);

        when(userManager.registerCustomer(form)).thenReturn(customer);

        mvc.perform(post("/register").with(csrf()))
                .andExpect(unauthenticated())
                .andExpect(status().isOk());

        mvc.perform(post("/register").with(csrf())
                .param("username", form.getUsername())
                .param("email", form.getEmail())
                .param("firstName", form.getFirstName())
                .param("lastName", form.getLastName())
                .param("password", form.getPassword())
                .param("passwordVerification", form.getPasswordVerification()))
                .andExpect(authenticated().withRoles("CUSTOMER"))
                .andExpect(redirectedUrl("/"))
                .andExpect(status().isFound());
    }
}
