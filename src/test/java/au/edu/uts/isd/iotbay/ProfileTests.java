package au.edu.uts.isd.iotbay;

import au.edu.uts.isd.iotbay.models.dao.UserManager;
import au.edu.uts.isd.iotbay.models.data.Customer;
import au.edu.uts.isd.iotbay.models.data.User;
import au.edu.uts.isd.iotbay.models.forms.EditCustomerForm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProfileTests {
    final private Logger log = LoggerFactory.getLogger(ProfileTests.class);

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserManager userManager;

    /**
     * <h3>As a customer, I want to view my account details so that I can ensure
     * they are valid</h3>
     *
     * <ul>
     * <li><b>Given:</b> User is signed into an account with a customer role</li>
     * <li><b>When:</b> User enters his profile</li>
     * <li><b>Then:</b> The server responds with users details</li>
     * </ul>
     *
     * @result http: 200 OK, user details
     */
    @Test
    @DisplayName("UA-4: Read Customer Profile Test")
    void testViewCustomer() throws Exception {
        log.info("UA-4: Read Customer Profile Test");

        final User user = new User(UUID.randomUUID());
        user.setEmail("email@email.org");
        user.setUsername("user_name");
        user.setFirstName("First");
        user.setLastName("Last");

        final Customer customer = new Customer(UUID.randomUUID(), user);

        when(userManager.fetchCustomerByUsername(user.getUsername())).thenReturn(customer);

        mvc.perform(get("/profile").with(user("user_name").roles("CUSTOMER")))
                .andExpect(status().isOk())
                .andExpect(model().attribute("customer", customer))
                .andExpect(view().name("profile/index"));
    }

    @Test
    @DisplayName("UA-5: Update Customer Details Test")
    void testUpdateCustomer() throws Exception {
        log.info("UA-5: Update Customer Details Test");

        final User user = new User(UUID.randomUUID());
        user.setEmail("fake@email.com");
        user.setUsername("username");
        user.setFirstName("First");
        user.setLastName("Last");

        final EditCustomerForm form = new EditCustomerForm();
        form.setEmail(user.getEmail());
        form.setFirstName(user.getFirstName() + "Name");
        form.setLastName(user.getLastName() + "Name");

        final User editedUser = new User(user.getId());
        editedUser.setUsername(null);
        editedUser.setEmail(form.getEmail());
        editedUser.setFirstName(form.getFirstName());
        editedUser.setLastName(form.getLastName());

        final Customer customer = new Customer(UUID.randomUUID(), user);

        when(userManager.fetchCustomerById(customer.getId().toString()))
                .thenReturn(customer);
        when(userManager.updateUserInformation(user.getId().toString(), form))
                .thenReturn(editedUser);

        mvc.perform(get("/profile/edit/" + customer.getId().toString())
                .with(user(user.getUsername()).roles("CUSTOMER")))
                .andExpect(status().isOk());

        mvc.perform(put("/profile/edit/" + user.getId().toString())
                        .with(user(user.getUsername()).roles("CUSTOMER"))
                        .with(csrf())
                        .param("email", form.getEmail())
                        .param("firstName", form.getFirstName())
                        .param("lastName", form.getLastName()))
                .andExpect(redirectedUrl("/profile"))
                .andExpect(status().isFound());
    }
}
