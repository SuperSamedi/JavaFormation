package brussels.digitalcity.maxdolmans.demorest.repositories;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Get all future bookings of child
    @Query("SELECT b FROM Booking b WHERE b.id = ?1 AND b.date > current_date ")
    List<Booking> getFutureBookingsOfChild(Long concernedChildId);

    // Cancel booking
    @Modifying
    @Transactional
    @Query("UPDATE Booking b SET b.cancelled = ?2, b.cancellationMotive = ?3 WHERE b.id = ?1")
    void cancel(Long id, boolean isCancelled, String motive);

    // Get all bookings of the remaining of the month
    // Methode 1
//    List<Booking> findBookingsByDroppingDateAfterAndDroppingDateBefore(LocalDate today, LocalDate endOfMonth);
    // Methode 2
    @Query("SELECT b FROM Booking b WHERE MONTH(CURRENT_DATE) = MONTH(b.date) AND b.date >= CURRENT_DATE AND b.cancelled = false")
    List<Booking> findRemainingCurrentMonth();

    // Get all bookings of a particular day
    List<Booking> findBookingsByDate(LocalDate date);

    // Check availability of a booking attempt
    @Query("SELECT (COUNT(b) < 10) FROM Booking b WHERE b.date = ?1 AND NOT(b.pickupTime < ?2 OR b.droppingTime > ?3) AND b.cancelled = false")
    boolean checkAvailable(LocalDate date, LocalTime dropping, LocalTime pickup);


}
