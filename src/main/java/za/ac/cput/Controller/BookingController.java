package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Booking;
import za.ac.cput.Service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> create(@RequestBody Booking booking) {
        Booking createdBooking = bookingService.create(booking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Booking> read(@PathVariable Integer id) {
        Booking booking = bookingService.read(Long.valueOf(id));
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<Booking> update(@RequestBody Booking booking) {
        Booking updatedBooking = bookingService.update(booking);
        if (updatedBooking != null) {
            return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean deleted = bookingService.delete(Long.valueOf(id));
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Booking>> getAll() {
        List<Booking> bookings = bookingService.getAll();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/findByStudentId/{studentId}")
    public ResponseEntity<List<Booking>> findByStudentId(@PathVariable int studentId) {
        List<Booking> bookings = bookingService.findByStudentId(Long.valueOf(studentId));
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/findByComputerId/{computerId}")
    public ResponseEntity<List<Booking>> findByComputerId(@PathVariable String computerId) {
        List<Booking> bookings = bookingService.findByComputerId(computerId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/findByStatus/{status}")
    public ResponseEntity<List<Booking>> findByStatus(@PathVariable String status) {
        List<Booking> bookings = bookingService.findByStatus(status);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}
