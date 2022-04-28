package au.edu.uts.isd.iotbay.models;

import java.util.UUID;

public class UserCredential implements java.io.Serializable {
    final UUID _id;
    String _username;
    String _passwordHash;
    String _email;
    String _firstName;
    String _lastName;

    UserCredential(UUID id, String username, String email, String password, String firstName, String lastName) {
        _id = id;
        _username = username;
        _passwordHash = password;
        _email = email;
        _firstName = firstName;
        _lastName = lastName;
    }

    public UUID getId() {
        return _id;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        _username = username;
    }

    public void setPasswordHash(String passwordHash) {
        _passwordHash = passwordHash;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getFirstName() {
        return _firstName;
    }

    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public void setLastName(String lastName) {
        _lastName = lastName;
    }
}
