package au.edu.uts.isd.iotbay.models.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Customer {
    final private UUID id;
    private User userInformation;

    public Customer(User user) {
        id = UUID.randomUUID();
        userInformation = user;
    }
}
