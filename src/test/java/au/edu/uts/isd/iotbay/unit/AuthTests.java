package au.edu.uts.isd.iotbay.unit;

import au.edu.uts.isd.iotbay.controllers.AuthController;
import au.edu.uts.isd.iotbay.models.dao.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@WebMvcTest(ProfileController.class)
public class AuthTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    UserManager userManager;

}
