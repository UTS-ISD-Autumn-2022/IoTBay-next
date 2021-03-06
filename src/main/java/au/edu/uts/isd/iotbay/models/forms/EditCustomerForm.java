package au.edu.uts.isd.iotbay.models.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class EditCustomerForm implements Serializable {
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
