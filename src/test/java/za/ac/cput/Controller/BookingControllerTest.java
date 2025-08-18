package za.ac.cput.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.Domain.Booking;
import za.ac.cput.Service.BookingService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookingController.class)
class BookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookingService bookingService;

    @Autowired
    private ObjectMapper objectMapper;

    private Booking booking;

    @BeforeEach
    void setUp() {
        booking = new Booking.Builder()
                .setBookingId(1)
                .setStudentId(1001)
                .setComputerId("COMP001")
                .setStartTime("09:00")
                .setEndTime("10:00")
                .setStatus("ACTIVE")
                .build();
    }

    @Test
    void create() throws Exception {
        when(bookingService.create(any(Booking.class))).thenReturn(booking);

        mockMvc.perform(post("/api/booking/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(booking)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.bookingId").value(1));

        verify(bookingService, times(1)).create(any(Booking.class));
    }

    @Test
    void read() throws Exception {
        when(bookingService.read(1)).thenReturn(booking);

        mockMvc.perform(get("/api/booking/read/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookingId").value(1));

        verify(bookingService, times(1)).read(1);
    }

    @Test
    void getAll() throws Exception {
        List<Booking> bookings = Arrays.asList(booking);
        when(bookingService.getAll()).thenReturn(bookings);

        mockMvc.perform(get("/api/booking/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].bookingId").value(1));

        verify(bookingService, times(1)).getAll();
    }
}
