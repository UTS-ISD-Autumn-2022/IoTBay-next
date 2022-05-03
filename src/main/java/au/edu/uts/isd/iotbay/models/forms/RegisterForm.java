package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class RegisterForm implements java.io.Serializable {
    @Max(value = 255)
    private String username;
    
    @Min(value = 8)
    private String password;

    @Max(value = 255)
    @Email
    private String email;

    @Max(value = 63)
    private String firstName;

    @Max(value = 63)
    private String lastname;
}
