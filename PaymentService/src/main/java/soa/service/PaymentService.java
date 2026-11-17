
package soa.service;

import org.springframework.stereotype.Service;
import soa.model.Payment;

@Service
public class PaymentService {

    public boolean validatePaymentDetails(Payment payment) {
        return payment != null
                && payment.getPayer() != null
                && !payment.getPayer().isBlank()
                && payment.getReceiver() != null
                && !payment.getReceiver().isBlank()
                && payment.getAmount() > 0
                && Double.isFinite(payment.getAmount());
    }

    public String processPayment(Payment payment) {
        if (!validatePaymentDetails(payment)) {
            throw new IllegalArgumentException(
                    "Invalid payment details");
        }

        return "Payment processed successfully";
    }
}
