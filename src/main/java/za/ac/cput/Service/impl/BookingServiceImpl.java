package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Booking;
import za.ac.cput.Repository.BookingRepository;
import za.ac.cput.Service.BookingService;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking read(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public boolean delete(Integer id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> findByStudentId(int studentId) {
        return bookingRepository.findByStudentId(studentId);
    }

    @Override
    public List<Booking> findByComputerId(String computerId) {
        return bookingRepository.findByComputerId(computerId);
    }

    @Override
    public List<Booking> findByStatus(String status) {
        return bookingRepository.findByStatus(status);
    }
}
