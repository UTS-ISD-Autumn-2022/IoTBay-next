package au.edu.uts.isd.iotbay.models.data;

import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    final private UUID id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;

    public User(RegisterForm registerForm) {
        id = UUID.randomUUID();

        username = registerForm.getUsername();
        email = registerForm.getEmail();

        firstName = registerForm.getFirstName();
        lastName = registerForm.getLastName();
    }
}
