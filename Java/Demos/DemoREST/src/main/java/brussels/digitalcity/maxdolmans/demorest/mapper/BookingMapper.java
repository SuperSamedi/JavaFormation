package brussels.digitalcity.maxdolmans.demorest.mapper;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.BookingDTO;
import brussels.digitalcity.maxdolmans.demorest.models.entities.Booking;
import brussels.digitalcity.maxdolmans.demorest.models.forms.BookingForm;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {

    private final ChildMapper childMapper;
    private final GuardianMapper guardianMapper;

    public BookingMapper(ChildMapper childMapper, GuardianMapper guardianMapper) {
        this.childMapper = childMapper;
        this.guardianMapper = guardianMapper;
    }


    public BookingDTO toDTO(Booking entity) {
        if (entity == null) {
            return null;
        }

        BookingDTO dto = new BookingDTO();

        dto.setId( entity.getId() );
        dto.setDate( entity.getDate() );
        dto.setDroppingTime( entity.getDroppingTime() );
        dto.setPickupTime( entity.getPickupTime() );
        dto.setConcernedChild( childMapper.toDTO( entity.getConcernedChild() ) );
        dto.setDroppingGuardian( guardianMapper.toDTO( entity.getDroppingGuardian() ) );
        dto.setPickupGuardian( guardianMapper.toDTO( entity.getPickupGuardian() ) );
        dto.setCancelled( entity.isCancelled() );
        dto.setCancellationMotive( entity.getCancellationMotive() );

        return dto;
    }

    public Booking toEntity(BookingForm form) {
        if (form == null) {
            return null;
        }

        Booking booking = new Booking();

        booking.setDate( form.getDate() );
        booking.setDroppingTime( form.getDroppingTime() );
        booking.setPickupTime( form.getPickupTime() );

        return booking;
    }
}
