// Author: Elias Nahas
// Bookings class for bookings table

package sample;

public class Booking {
    // private data
    private int BookingId;
    private String BookingDate;
    private String BookingNo;
    private Double TravelerCount;
    private Integer CustomerId;
    private String TripTypeId;
    private Integer PackageId;

    // getters and setters
    public int getBookingId() {
        return BookingId;
    }

    public void setBookingId(int bookingId) {
        BookingId = bookingId;
    }

    public String getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(String bookingDate) {
        BookingDate = bookingDate;
    }

    public String getBookingNo() {
        return BookingNo;
    }

    public void setBookingNo(String bookingNo) {
        BookingNo = bookingNo;
    }

    public Double getTravelerCount() {
        return TravelerCount;
    }

    public void setTravelerCount(Double travelerCount) {
        TravelerCount = travelerCount;
    }

    public Integer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Integer customerId) {
        CustomerId = customerId;
    }

    public String getTripTypeId() {
        return TripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        TripTypeId = tripTypeId;
    }

    public Integer getPackageId() {
        return PackageId;
    }

    public void setPackageId(Integer packageId) {
        PackageId = packageId;
    }

    // constructors

    public Booking(int bookingId, String bookingDate, String bookingNo, Double travelerCount, Integer customerId, String tripTypeId, Integer packageId) {
        BookingId = bookingId;
        BookingDate = bookingDate;
        BookingNo = bookingNo;
        TravelerCount = travelerCount;
        CustomerId = customerId;
        TripTypeId = tripTypeId;
        PackageId = packageId;
    }

    public Booking() {
    }
}
