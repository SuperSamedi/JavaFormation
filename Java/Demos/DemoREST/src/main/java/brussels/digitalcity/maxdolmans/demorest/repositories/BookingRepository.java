package brussels.digitalcity.maxdolmans.demorest.repositories;

import brussels.digitalcity.maxdolmans.demorest.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByDroppingTimeBetween(LocalDateTime dateStart, LocalDateTime dateEnd);

    List<Booking> findByConcernedChildIdAndDroppingTimeAfter(Long concernedChildId, LocalDateTime today);

    @Modifying
    @Query("UPDATE Booking b SET b.cancelled = ?2, b.cancellationMotive = ?3 WHERE b.id = ?1")
    void cancel(Long id, boolean isCancelled, String motive);

    List<Booking> findBookingsByDroppingTimeAfterAndDroppingTimeBefore(LocalDateTime today, LocalDateTime endOfMonth);
}
