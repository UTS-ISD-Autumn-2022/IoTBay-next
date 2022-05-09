package au.edu.uts.isd.iotbay.models.data;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
    final private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
}
