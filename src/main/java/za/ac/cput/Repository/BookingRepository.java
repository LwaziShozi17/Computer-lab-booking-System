package za.ac.cput.Repository;

/*
 BookingRepository class
 Author: SM Thwabuse (220246009)
 Date: 10/08/2025
 */

import za.ac.cput.Domain.Booking;
import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    private static BookingRepository repository = null;
    private Map<Integer, Booking> bookingDB;

    private BookingRepository() {
        bookingDB = new HashMap<>();
    }

    public static BookingRepository getRepository() {
        if (repository == null) {
            repository = new BookingRepository();
        }
        return repository;

    }
        public Booking create(Booking booking) {
            bookingDB.put(booking.getBookingId(), booking);
            return booking;
        }


    public Booking read(int bookingId) {
        return bookingDB.get(bookingId);
    }

    public Booking update(Booking booking) {
        if(bookingDB.containsKey(booking.getBookingId())) {
            bookingDB.put(booking.getBookingId(), booking);
            return booking;
        }
        return null;
    }

    public boolean delete(int bookingId) {
        return bookingDB.remove(bookingId) != null;
    }

    public Map<Integer, Booking> getAll() {
        return bookingDB;
    }
}







