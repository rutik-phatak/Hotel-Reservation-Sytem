package Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Booking {
    private int bookingId;
    private Room room;
    private String guestName;
    private double paymentAmount;

    public Booking(int bookingId, Room room, String guestName, double paymentAmount) {
        this.bookingId = bookingId;
        this.room = room;
        this.guestName = guestName;
        this.paymentAmount = paymentAmount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Room getRoom() {
        return room;
    }

    public String getGuestName() {
        return guestName;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }
}

