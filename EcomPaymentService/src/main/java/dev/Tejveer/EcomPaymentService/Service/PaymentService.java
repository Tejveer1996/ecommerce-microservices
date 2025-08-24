package dev.Tejveer.EcomPaymentService.Service;

import dev.Tejveer.EcomPaymentService.DTO.PaymentRequestDTO;
import com.razorpay.RazorpayException;

public interface PaymentService {
    String generatePaymentLink(PaymentRequestDTO paymentRequestDTO) throws RazorpayException;
}
