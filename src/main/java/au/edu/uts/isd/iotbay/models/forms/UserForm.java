package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserForm {
    @Size(max = 50)
    @NotNull
    private String username;

    @Size(min = 8)
    @NotNull
    private String password;

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

    @NotNull
    private boolean isCustomer;

    @NotNull
    private boolean isStaff;

    @NotNull
    private boolean isAdmin;
}
