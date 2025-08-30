/*
BookingRepository.java
Booking Repository interface
Author: SE Sibiya (230975623)
Date: 20 August 2025
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findByBookingId(Long bookingId);
    Booking findByStudentId(Long studentId);

    // Booking getBookingByBookingId(Long bookingId);
    // Booking findByBookingByStudentId(Long studentId);
    // Booking findByStudentId(studentId);

}
