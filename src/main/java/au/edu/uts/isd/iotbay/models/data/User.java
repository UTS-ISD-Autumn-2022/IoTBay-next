package au.edu.uts.isd.iotbay.models.data;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
public abstract class User {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    final private BCryptPasswordEncoder encoder;

    private UUID id;

    private Role role;

    private String username;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String passwordHash;
    private String email;

    private String firstName;

    private String lastName;

    public User(BCryptPasswordEncoder encoder, Optional<UUID> maybeId, Role role, String username, String password, String email, String firstName, String lastName) {
        this.id = maybeId.orElse(UUID.randomUUID());
        this.encoder = encoder;
        this.role = role;
        this.username = username;
        this.passwordHash = encoder.encode(password);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setNewPassword(String password) {
        passwordHash = encoder.encode(password);
    }
}
