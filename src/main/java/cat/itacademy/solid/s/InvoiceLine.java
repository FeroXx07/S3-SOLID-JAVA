package cat.itacademy.solid.s;

import java.math.BigDecimal;

public record InvoiceLine(
        String description,
        int quantity,
        BigDecimal unitPrice
) {

    public BigDecimal calculateTotal() {
        BigDecimal total = Constants.ZERO_TWO_DECIMALS;
        total = unitPrice.multiply(BigDecimal.valueOf(quantity));
        return total;
    }
}
