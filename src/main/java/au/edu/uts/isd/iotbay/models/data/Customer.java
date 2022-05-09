package au.edu.uts.isd.iotbay.models.data;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

public class Customer extends User {
    public Customer(BCryptPasswordEncoder encoder, Optional<UUID> maybeId, Role role, String username, String password, String email, String firstName, String lastName) {
        super(encoder, maybeId, role, username, password, email, firstName, lastName);
    }
}
