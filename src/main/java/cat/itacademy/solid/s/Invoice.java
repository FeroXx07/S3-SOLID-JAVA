package cat.itacademy.solid.s;

import java.math.BigDecimal;
import java.util.List;

public record Invoice(
        String number,
        String customerName,
        List<InvoiceLine> lines
) {

    public Invoice {
        lines = List.copyOf(lines);
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = Constants.ZERO_TWO_DECIMALS;

        for (InvoiceLine line : lines) {
            total = total.add(line.calculateTotal());
        }

        return total;
    }
}
