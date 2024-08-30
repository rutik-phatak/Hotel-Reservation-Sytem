package Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {
    private List<Room> rooms;
    private List<Booking> bookings;
    private int bookingIdCounter;

    public HotelReservationSystem() {
        this.rooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.bookingIdCounter = 1;

        // Initialize rooms
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
        rooms.add(new Room(104, "Single"));
        rooms.add(new Room(105, "Double"));
    }

    public void searchRooms(String category) {
        System.out.println("Available rooms in " + category + " category:");
        for (Room room : rooms) {
            if (room.getCategory().equals(category) && room.isAvailable()) {
                System.out.println("Room " + room.getRoomNumber());
            }
        }
    }

    public void makeReservation(String guestName, int roomNumber, double paymentAmount) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null && room.isAvailable()) {
            room.setAvailable(false);
            Booking booking = new Booking(bookingIdCounter++, room, guestName, paymentAmount);
            bookings.add(booking);
            System.out.println("Reservation successful! Booking ID: " + booking.getBookingId());
        } else {
            System.out.println("Room not available!");
        }
    }

    public void viewBookingDetails(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                System.out.println("Booking ID: " + booking.getBookingId());
                System.out.println("Room Number: " + booking.getRoom().getRoomNumber());
                System.out.println("Guest Name: " + booking.getGuestName());
                System.out.println("Payment Amount: " + booking.getPaymentAmount());
                return;
            }
        }
        System.out.println("Booking not found!");
    }

    private Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HotelReservationSystem hotel = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Search rooms by category");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            
            switch (option) {
            case 1:
                System.out.print("Enter room category: ");
                String category = scanner.next();
                hotel.searchRooms(category);
                break;
            case 2:
                System.out.print("Enter guest name: ");
                String guestName = scanner.next();
                System.out.print("Enter room number: ");
                int roomNumber = scanner.nextInt();
                System.out.print("Enter payment amount: ");
                double paymentAmount = scanner.nextDouble();
                hotel.makeReservation(guestName, roomNumber, paymentAmount);
                break;
            case 3:
                System.out.print("Enter booking ID: ");
                int bookingId = scanner.nextInt();
                hotel.viewBookingDetails(bookingId);
                break;
            case 4:
                System.out.println("Goodbye!");
                return;
            default:
                System.out.println("Invalid option!");
        }
    }
}
}