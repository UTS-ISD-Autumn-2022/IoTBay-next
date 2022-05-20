package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EditCustomerForm {
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
