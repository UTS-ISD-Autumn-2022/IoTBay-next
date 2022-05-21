package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class RegisterForm implements Serializable {
    @Size(max = 50)
    @NotNull
    private String username;
    
    @Size(min = 8)
    @NotNull
    private String password;

    @Size(min = 8)
    @NotNull
    private String passwordVerification;

    @Email
    @Size(max = 255)
    @NotNull
    private String email;

    @Size(max = 63)
    @NotNull
    private String firstName;

    @Size(max = 63)
    @NotNull
    private String lastName;
}
