package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Booking;
import za.ac.cput.Repository.BookingRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking read(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    public boolean delete(Long id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    public List<Booking> findByStudentId(Long studentId) {
        return bookingRepository.findByStudentId(studentId);
    }

    public List<Booking> findByComputerId(String computerId) {
        return bookingRepository.findByComputerId(computerId);
    }

    public List<Booking> findByStatus(String status) {
        return bookingRepository.findByStatus(status);
    }
}
