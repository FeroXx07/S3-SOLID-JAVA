package cat.itacademy.solid.d.service;

import cat.itacademy.solid.d.exception.BookingAccessDeniedException;
import cat.itacademy.solid.d.model.Booking;
import cat.itacademy.solid.d.repository.BookingRepository;

import java.time.Clock;
import java.time.LocalDateTime;

public class ConcreteBookingService implements BookingService {

    private Clock clock;
    private final BookingRepository repository;

    public ConcreteBookingService(BookingRepository repository, Clock clock) {
        this.clock = clock;
        this.repository = repository;
    }

    @Override
    public void cancelBooking(String customerId, Long bookingId) {
        Booking booking = repository.findById(bookingId)
                .orElseThrow(() -> new IllegalStateException("Booking not found"));

        if (!booking.belongsTo(customerId)) {
            throw new BookingAccessDeniedException(customerId, bookingId);
        }

        LocalDateTime now = LocalDateTime.now(clock);

        booking.cancel(now);
        repository.save(booking);
    }
}
