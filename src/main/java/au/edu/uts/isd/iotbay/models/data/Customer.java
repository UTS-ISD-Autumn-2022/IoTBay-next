package au.edu.uts.isd.iotbay.models.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
    final private UUID id;
    private User userInformation;

    public Customer(User user) {
        id = UUID.randomUUID();
        userInformation = user;
    }
}
