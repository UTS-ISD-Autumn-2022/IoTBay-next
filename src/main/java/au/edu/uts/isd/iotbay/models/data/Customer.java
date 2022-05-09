package au.edu.uts.isd.iotbay.models.data;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

@Data
public class Customer {
    final User userCredentials;
}
