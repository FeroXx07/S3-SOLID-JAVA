package cat.itacademy.solid.s;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class InvoiceService {

    public void saveToFile(Invoice invoice, Path destination) {
        String serializedContent = InvoiceSerializer.serialize(invoice);
        openWriteFile(invoice, destination, serializedContent);
    }

    private static void openWriteFile(Invoice invoice, Path destination, String serializedContent) {
        try {
            Files.writeString(destination, serializedContent);
        } catch (IOException exception) {
            throw new UncheckedIOException(
                    "Could not save invoice: " + invoice.number(),
                    exception
            );
        }
    }
}
