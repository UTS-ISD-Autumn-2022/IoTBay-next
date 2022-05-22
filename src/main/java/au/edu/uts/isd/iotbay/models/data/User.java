package au.edu.uts.isd.iotbay.models.data;

import au.edu.uts.isd.iotbay.models.forms.RegisterForm;
import au.edu.uts.isd.iotbay.models.forms.UserForm;
import lombok.*;

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

    public User(final RegisterForm registerForm) {
        id = UUID.randomUUID();

        username = registerForm.getUsername();
        email = registerForm.getEmail();

        firstName = registerForm.getFirstName();
        lastName = registerForm.getLastName();
    }

    public User(final UserForm userForm) {
        id = UUID.randomUUID();
        username = userForm.getUsername();
        email = userForm.getEmail();
        firstName = userForm.getFirstName();
        lastName = userForm.getLastName();
    }
}
