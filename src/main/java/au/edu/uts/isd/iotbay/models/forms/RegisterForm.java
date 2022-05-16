package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class RegisterForm {
    @Size(max = 255)
    private String username;
    
    @Size(min = 8)
    private String password;

    @Size(min = 8)
    private String passwordVerification;

    @Email
    @Size(max = 255)
    private String email;

    @Size(max = 63)
    private String firstName;

    @Size(max = 63)
    private String lastName;
}
