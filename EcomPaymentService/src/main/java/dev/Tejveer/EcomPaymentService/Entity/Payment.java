package dev.Tejveer.EcomPaymentService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;



import java.util.UUID;

@Getter
@Setter
@Entity(name = "Payment_Table")
public class Payment extends BaseModel{

    private double amount;
    private UUID userId;
    private String orderId;
    private String transactionId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @OneToOne
    private Currency currency;
}
