package au.edu.uts.isd.iotbay.models.data;

import java.sql.Timestamp;
import java.util.UUID;

import au.edu.uts.isd.iotbay.models.forms.OrderForm;
import lombok.Data;

/**
 * This here contains a java representation of the sql data,
 * I would either use a bean as per the tutorials here, or I would use
 * lombok annotations to autogenerate beans as per the user class
 */
@Data
public class Order {
    final private UUID id;
    private UUID customerId;
    private UUID addressId;
    private UUID paymentOptionId;
    private Timestamp createdAt;
    private float totalCost;
    private String status;

    public Order(UUID id) {
        this.id = id;
    }

    public Order(final OrderForm orderForm) {
        id = UUID.randomUUID();
        customerId = orderForm.getId();
        totalCost = orderForm.getTotalCost();
        status = orderForm.getStatus();
    }
}