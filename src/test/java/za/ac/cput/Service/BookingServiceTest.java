package za.ac.cput.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.Domain.Booking;
import za.ac.cput.Repository.BookingRepository;
import za.ac.cput.Service.impl.BookingServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        Booking booking = new Booking.Builder()
                .setBookingId(1)
                .setStudentId(1001)
                .setComputerId("COMP001")
                .setStartTime("09:00")
                .setEndTime("10:00")
                .setStatus("ACTIVE")
                .build();

        when(bookingRepository.save(booking)).thenReturn(booking);

        Booking created = bookingService.create(booking);
        assertNotNull(created);
        assertEquals(1, created.getBookingId());
        verify(bookingRepository, times(1)).save(booking);
    }

    @Test
    void read() {
        Booking booking = new Booking.Builder()
                .setBookingId(1)
                .setStudentId(1001)
                .setComputerId("COMP001")
                .setStartTime("09:00")
                .setEndTime("10:00")
                .setStatus("ACTIVE")
                .build();

        when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));

        Booking found = bookingService.read(1);
        assertNotNull(found);
        assertEquals(1, found.getBookingId());
    }

    @Test
    void update() {
        Booking booking = new Booking.Builder()
                .setBookingId(1)
                .setStudentId(1001)
                .setComputerId("COMP001")
                .setStartTime("09:00")
                .setEndTime("10:00")
                .setStatus("COMPLETED")
                .build();

        when(bookingRepository.save(booking)).thenReturn(booking);

        Booking updated = bookingService.update(booking);
        assertNotNull(updated);
        assertEquals("COMPLETED", updated.getStatus());
    }

    @Test
    void delete() {
        when(bookingRepository.existsById(1)).thenReturn(true);
        doNothing().when(bookingRepository).deleteById(1);

        boolean deleted = bookingService.delete(1);
        assertTrue(deleted);
        verify(bookingRepository, times(1)).deleteById(1);
    }

    @Test
    void getAll() {
        Booking booking1 = new Booking.Builder()
                .setBookingId(1)
                .setStudentId(1001)
                .setComputerId("COMP001")
                .setStartTime("09:00")
                .setEndTime("10:00")
                .setStatus("ACTIVE")
                .build();

        Booking booking2 = new Booking.Builder()
                .setBookingId(2)
                .setStudentId(1002)
                .setComputerId("COMP002")
                .setStartTime("10:00")
                .setEndTime("11:00")
                .setStatus("ACTIVE")
                .build();

        when(bookingRepository.findAll()).thenReturn(Arrays.asList(booking1, booking2));

        List<Booking> bookings = bookingService.getAll();
        assertEquals(2, bookings.size());
    }

    @Test
    void findByStudentId() {
        Booking booking = new Booking.Builder()
                .setBookingId(1)
                .setStudentId(1001)
                .setComputerId("COMP001")
                .setStartTime("09:00")
                .setEndTime("10:00")
                .setStatus("ACTIVE")
                .build();

        when(bookingRepository.findByStudentId(1001)).thenReturn(Arrays.asList(booking));

        List<Booking> bookings = bookingService.findByStudentId(1001);
        assertEquals(1, bookings.size());
        assertEquals(1001, bookings.get(0).getStudentId());
    }
}
