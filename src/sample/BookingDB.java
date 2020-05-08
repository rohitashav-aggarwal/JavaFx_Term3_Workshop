// Author: Elias Nahas
// Class to retrieve bookings data and create a booking object

package sample;

import java.sql.*;
import java.util.ArrayList;

public class BookingDB {

    // Retrieves all data from the bookings table and enters the data into a booking object
    public static ArrayList<Booking> getBookings() throws SQLException {
        // Empty array list to populate and return
        ArrayList<Booking> bookingList = new ArrayList<>();

        // SQL query to get all rows from bookings table
        String query = "SELECT * FROM bookings";

        // Initialize ResultSet
        ResultSet results = DatabaseUtility.getResults(query);

        // Recursively create Booking objects and add them to the bookingList array
        while(results.next()) {
            Booking booking = new Booking(
                    (int)results.getObject(1),
                    String.valueOf((Timestamp)results.getObject(2)),
                    (String)results.getObject(3),
                    (Double)results.getObject(4),
                    (Integer)results.getObject(5),
                    (String)results.getObject(6),
                    (Integer)results.getObject(7));
            bookingList.add(booking);
        }

        // Return the bookingList
        return bookingList;
    }

    public static Booking getBooking(int id) throws SQLException {
        Booking booking = new Booking();

        String query = "Select * from Bookings where BookingId = " + id;

        // Initialize ResultSet
        ResultSet results = DatabaseUtility.getResults(query);

        // Recursively create Booking objects and add them to the bookingList array
        while(results.next()) {
            booking = new Booking(
                    (int)results.getObject(1),
                    String.valueOf((Timestamp)results.getObject(2)),
                    (String)results.getObject(3),
                    (Double)results.getObject(4),
                    (Integer)results.getObject(5),
                    (String)results.getObject(6),
                    (Integer)results.getObject(7));
        }
        return booking;
    }

    public static void updateBooking(Booking booking){
        try{
            // SQL query to update bookings table
            String query = "UPDATE bookings SET BookingDate = ?, BookingNo = ?, TravelerCount = ?, CustomerID = ?, " +
                    "TripTypeId = ?, PackageId = ? WHERE BookingId = ?";

            // Create a prepared statement
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            // Set the values in the statement
            statement.setString(1, String.valueOf(booking.getBookingDate()));
            statement.setString(2, booking.getBookingNo());
            statement.setString(3, String.valueOf(booking.getTravelerCount()));
            statement.setString(4, String.valueOf(booking.getCustomerId()));
            statement.setString(5, booking.getTripTypeId());
            statement.setString(6, String.valueOf(booking.getPackageId()));
            if (booking.getPackageId() != null)
                statement.setString(7, String.valueOf(booking.getBookingId()));
            else
                statement.setString(7, "");

            // Execute update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void insertBooking(Booking booking){
        try{
            // SQL query to insert booking into bookings table
            String query;
            if (booking.getPackageId()!= null) {
                query = "INSERT INTO bookings (BookingDate, BookingNo, TravelerCount, CustomerID, TripTypeId, " +
                        "PackageId) VALUES (?,?,?,?,?,?)";
            }
            else {
                query = "INSERT INTO bookings (BookingDate, BookingNo, TravelerCount, CustomerID, TripTypeId) " +
                        "VALUES (?,?,?,?,?)";
            }
            // Create a prepared statement
            PreparedStatement statement = DatabaseUtility.updateDatabase(query);

            // Set the values in the statement
            statement.setString(1, String.valueOf(booking.getBookingDate()));
            statement.setString(2, booking.getBookingNo());
            statement.setString(3, String.valueOf(booking.getTravelerCount()));
            statement.setString(4, String.valueOf(booking.getCustomerId()));
            statement.setString(5, booking.getTripTypeId());
            if (booking.getPackageId() != null)
                statement.setString(6, String.valueOf(booking.getPackageId()));

            // Execute update statement
            statement.executeUpdate();
        }
        catch (NullPointerException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
