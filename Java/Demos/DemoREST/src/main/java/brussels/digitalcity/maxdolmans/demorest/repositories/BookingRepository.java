package brussels.digitalcity.maxdolmans.demorest.repositories;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Get all future bookings of child
//    @Query("SELECT b FROM Booking b WHERE b.id = ?1 AND b.droppingTime > ?2")
    List<Booking> findByConcernedChildIdAndDroppingDateAfter(Long concernedChildId, LocalDate today);

    // Cancel booking
    @Modifying
    @Query("UPDATE Booking b SET b.cancelled = ?2, b.cancellationMotive = ?3 WHERE b.id = ?1")
    void cancel(Long id, boolean isCancelled, String motive);

    // Get all bookings of the remaining of the month
    List<Booking> findBookingsByDroppingDateAfterAndDroppingDateBefore(LocalDate today, LocalDate endOfMonth);

    // Get all bookings of a particular day
    List<Booking> findBookingsByDroppingDate(LocalDate droppingDate);
}
