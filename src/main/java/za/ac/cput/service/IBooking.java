/*
IBooking.java
Booking Service interface
Author: SE Sibiya (230975623)
Date: 20 August 2025
*/

package za.ac.cput.service;

import za.ac.cput.domain.Booking;
import java.util.List;

public interface IBooking extends IService<Booking, Long> {
    Booking searchByBookingId(Long bookingId);
    Booking deleteByBookingId(Long bookingId);
    Booking deleteByStudentId(Long studentId);

    List<Booking> findAllBookings();
}
