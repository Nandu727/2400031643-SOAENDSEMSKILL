
package soa.service;

import org.junit.jupiter.api.Test;
import soa.model.Payment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentServiceTest {

    private final PaymentService paymentService =
            new PaymentService();

    @Test
    void testValidPayment() {
        Payment payment =
                new Payment("Juber", "Rahul", 1000);

        String result = paymentService.processPayment(payment);

        assertThat(result)
                .isEqualTo("Payment processed successfully");
    }

    @Test
    void testInvalidAmount() {
        Payment payment =
                new Payment("Juber", "Rahul", -100);

        assertThat(paymentService.validatePaymentDetails(payment))
                .isFalse();

        assertThatThrownBy(() -> paymentService.processPayment(payment))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid payment details");
    }

    @Test
    void testMissingDetails() {
        Payment payment =
                new Payment("Juber", "", 500);

        assertThat(paymentService.validatePaymentDetails(payment))
                .isFalse();

        assertThatThrownBy(() -> paymentService.processPayment(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
