package au.edu.uts.isd.iotbay.models.forms;

import java.security.Timestamp;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * this here directly maps to the html forms
 */
@Data
public class OrderForm {
    @Size(max = 50)
    @NotNull
    private UUID id;

    @Size(max = 50)
    @NotNull
    private UUID customerId;

    @Size(max = 250)
    @NotNull
    private String addressId;

    @Size(max = 50)
    @NotNull
    private Timestamp createdAt;

    @Size(max = 50)
    @NotNull
    private UUID paymentOption;

    @Size(max = 50)
    @NotNull
    private Float totalCost;

    @Size(max = 50)
    @NotNull
    private String status;
}
