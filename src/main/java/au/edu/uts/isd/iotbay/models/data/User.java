package au.edu.uts.isd.iotbay.models.data;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
public class User {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    final private BCryptPasswordEncoder encoder;

    private UUID id;

    private Role role;

    private String username;

    private String passwordHash;
    private String email;

    private String firstName;

    private String lastName;

    public User(Optional<UUID> maybeId, Role role, String username, String password, String email, String firstName, String lastName) {
        this.encoder = new BCryptPasswordEncoder();
        this.id = maybeId.orElse(UUID.randomUUID());
        this.role = role;
        this.username = username;
        this.passwordHash = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void encodePassword(String password) {
        passwordHash = encoder.encode(password);
    }

    public boolean verifyPassword(String password) {
        return encoder.matches(password, passwordHash);
    }
}
