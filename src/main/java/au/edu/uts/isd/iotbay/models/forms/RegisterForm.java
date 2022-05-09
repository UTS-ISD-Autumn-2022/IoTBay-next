package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class RegisterForm {
    @Max(value = 255)
    private String username;
    
    @Min(value = 8)
    private String password;

    @Min(value = 8)
    private String passwordVerification;

    @Max(value = 255)
    @Email
    private String email;

    @Max(value = 63)
    private String firstName;

    @Max(value = 63)
    private String lastName;
}
