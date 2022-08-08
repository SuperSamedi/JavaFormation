package brussels.digitalcity.maxdolmans.demorest.mapper;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.BookingDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Booking;
import brussels.digitalcity.maxdolmans.demorest.models.forms.BookingForm;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    public BookingDTO toDTO(Booking entity) {
        if (entity == null) {
            return null;
        }

        BookingDTO dto = new BookingDTO();

        dto.setId( entity.getId() );
        dto.setConcernedChildId( entity.getConcernedChildId() );
        dto.setDroppingTime( entity.getDroppingTime() );
        dto.setDroppingGuardianId(entity.getDroppingGuardianId() );
        dto.setPickupTime( entity.getPickupTime() );
        dto.setPickupGuardianId(entity.getPickupGuardianId() );
        dto.setCancelled( entity.isCancelled() );
        dto.setCancellationMotive( entity.getCancellationMotive() );

        return dto;
    }

    public Booking toEntity(BookingForm form) {
        if (form == null) {
            return null;
        }

        Booking booking = new Booking();

        booking.setConcernedChildId( form.getConcernedChildId() );
        booking.setDroppingTime( form.getDroppingTime() );
        booking.setDroppingGuardianId( form.getDroppingGuardianId() );
        booking.setPickupTime( form.getPickupTime() );
        booking.setPickupGuardianId( form.getPickupGuardianId() );
        booking.setCancelled( form.isCancelled() );
        booking.setCancellationMotive( form.getCancellationMotive() );
        return booking;
    }
}
