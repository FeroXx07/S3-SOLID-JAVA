package cat.itacademy.solid.s;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private InvoiceService invoiceService;
    private Invoice invoice;

    @BeforeEach
    void setUp() {
        invoiceService = new InvoiceService();

        invoice = new Invoice(
                "INV-2026-001",
                "Ada Lovelace",
                List.of(
                        new InvoiceLine(
                                "Mechanical keyboard",
                                2,
                                new BigDecimal("50.00")
                        ),
                        new InvoiceLine(
                                "Wireless mouse",
                                1,
                                new BigDecimal("25.00")
                        )
                )
        );
    }

    @Test
    void shouldCalculateCorrectTotal(){
        BigDecimal expectedTotalKeyboard = new BigDecimal("100.00");
        BigDecimal expectedTotalMouse = new BigDecimal("25.00");
        BigDecimal expectedFinalTotal = new BigDecimal("125.00");

        BigDecimal actualTotalKeyboard = invoice.lines().get(0).calculateTotal();
        BigDecimal actualTotalMouse = invoice.lines().get(1).calculateTotal();
        BigDecimal actualFinalTotal = invoice.calculateTotal();

        assertEquals(expectedTotalKeyboard, actualTotalKeyboard);
        assertEquals(expectedTotalMouse, actualTotalMouse);
        assertEquals(expectedFinalTotal, actualFinalTotal);
    }

    @Test
    void shouldCalculateCorrectTotalEmptyInvoice(){
        Invoice emptyInvoice = new Invoice("INV-2026-001", "Ada Lovelace", List.of());
        BigDecimal zeroTwoDecimals = new BigDecimal("0.00");

        assertEquals(emptyInvoice.calculateTotal(), zeroTwoDecimals);
    }

}