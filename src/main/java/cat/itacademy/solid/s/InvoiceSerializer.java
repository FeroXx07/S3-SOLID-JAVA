package cat.itacademy.solid.s;

import java.math.BigDecimal;

public class InvoiceSerializer {

    public String serialize(Invoice invoice) {
        String lineSeparator = System.lineSeparator();
        StringBuilder text = new StringBuilder();

        serializeHeaders(invoice, text, lineSeparator);
        serializeLines(invoice, text, lineSeparator);
        serializeFinalTotal(invoice, text, lineSeparator);

        return text.toString();
    }
    private void serializeHeaders(Invoice invoice, StringBuilder text, String lineSeparator) {
        text.append("INVOICE").append(lineSeparator);
        text.append("Number: ").append(invoice.number()).append(lineSeparator);
        text.append("Customer: ").append(invoice.customerName()).append(lineSeparator);
    }

    private void serializeLines(Invoice invoice, StringBuilder text, String lineSeparator) {
        text.append(lineSeparator);
        for (InvoiceLine line : invoice.lines()) {
            BigDecimal lineTotal = line.calculateTotal();

            text.append(line.description())
                    .append(" - ").append(line.quantity())
                    .append(" x ").append(line.unitPrice())
                    .append(" = ").append(lineTotal)
                    .append(lineSeparator);
        }
        text.append(lineSeparator);
    }

    private void serializeFinalTotal(Invoice invoice, StringBuilder text, String lineSeparator) {
        text.append("TOTAL: ").append(invoice.calculateTotal());
    }
}
