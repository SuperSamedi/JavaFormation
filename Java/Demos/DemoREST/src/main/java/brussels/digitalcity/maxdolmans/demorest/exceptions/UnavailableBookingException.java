package brussels.digitalcity.maxdolmans.demorest.exceptions;

import java.time.LocalDate;
import java.time.LocalTime;

public class UnavailableBookingException extends RuntimeException {

    private final LocalDate date;
    private final LocalTime droppingTime;
    private final LocalTime pickupTime;

    public UnavailableBookingException(LocalDate date, LocalTime droppingTime, LocalTime pickupTime) {
        super("Booking hours are not available.");
        this.date = date;
        this.droppingTime = droppingTime;
        this.pickupTime = pickupTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getDroppingTime() {
        return droppingTime;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }
}
