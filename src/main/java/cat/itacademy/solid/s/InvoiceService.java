package cat.itacademy.solid.s;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class InvoiceService {

    public void saveToFile(Invoice invoice, Path destination) {
        String lineSeparator = System.lineSeparator();
        StringBuilder text = new StringBuilder();
        text.append("INVOICE").append(lineSeparator);
        text.append("Number: ").append(invoice.number()).append(lineSeparator);
        text.append("Customer: ").append(invoice.customerName()).append(lineSeparator);
        text.append(lineSeparator);

        for (InvoiceLine line : invoice.lines()) {
            BigDecimal lineTotal = line.calculateTotal();

            text.append(line.description())
                    .append(" - ").append(line.quantity())
                    .append(" x ").append(line.unitPrice())
                    .append(" = ").append(lineTotal)
                    .append(lineSeparator);
        }

        text.append(lineSeparator).append("TOTAL: ").append(invoice.calculateTotal());

        try {
            Files.writeString(destination, text.toString());
        } catch (IOException exception) {
            throw new UncheckedIOException(
                    "Could not save invoice: " + invoice.number(),
                    exception
            );
        }
    }

}
