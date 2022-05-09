package au.edu.uts.isd.iotbay.models.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Role {
    private UUID id;
    private String name;
}
