package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.models.dtos.BookingDTO;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.ChildDTO;
import brussels.digitalcity.maxdolmans.demorest.models.forms.BookingForm;
import brussels.digitalcity.maxdolmans.demorest.services.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(path = "/api/booking")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }


    @PostMapping(path = "/add")
    public BookingDTO create(@Valid @RequestBody BookingForm form) {
        return service.create(form);
    }

    @GetMapping(path = "/all")
    public List<ChildDTO> getAllChildBookedAtDate(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return service.getAllChildrenBookedAtDate(date);
    }

    @Transactional
    @PatchMapping(path = "/cancel/{id:[0-9]+}")
    public BookingDTO cancelBooking(@PathVariable Long id, @RequestParam boolean isCancelled, @RequestParam String motive) {
        return service.cancel(id, isCancelled, motive);
    }

    @GetMapping(path = "/future-bookings/{id:[0-9]+}")
    public List<BookingDTO> getAllFutureBookingsForChild(@PathVariable Long id) {
        return service.getAllFutureBookingsOfChild(id);
    }

    @GetMapping(path = "/remaining-of-month")
    public List<BookingDTO> getAllRemainingBookingsOfCurrentMonth() {
        return service.getAllRemainingBookingsOfCurrentMonth();
    }

    @GetMapping(value = "/check", params = {"date", "droppingTime, pickupTime"})
    public boolean checkAvailable(
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date,
            @RequestParam @DateTimeFormat(pattern = "hh:mm")LocalTime droppingTime,
            @RequestParam @DateTimeFormat(pattern = "hh:mm")LocalTime pickupTime
            ) {
        return service.isAvailable(date, droppingTime, pickupTime);
    }
}
