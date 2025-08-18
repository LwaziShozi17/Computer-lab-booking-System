package za.ac.cput.Service;

import za.ac.cput.Domain.Booking;

import java.util.List;

public interface BookingService {
    Booking create(Booking booking);
    Booking read(Integer id);
    Booking update(Booking booking);
    boolean delete(Integer id);
    List<Booking> getAll();
    List<Booking> findByStudentId(int studentId);
    List<Booking> findByComputerId(String computerId);
    List<Booking> findByStatus(String status);
}
