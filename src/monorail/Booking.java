package Monorail.src.monorail;

import java.util.Scanner;
import java.util.ArrayList; // import the ArrayList class

public class Booking {
    protected int id;
    protected Route route = new Route();
    protected int departureTime;
    protected String fullName;
    protected int ssn;

    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public Booking(String fullName, int ssn, int route, int departureTime, int seats) {
        for (int i = 200000; i < 300000; i++) {
            // Check for a unique booking ID
            if (unique) {
                id = i;
            }
        }
        this.fullName = fullName;
        this.ssn = ssn;
        // Search for the route in the route list by id
        
        for (int i = 0; i< seats; i++){
            // Use the ticket constructor to add a ticket
            
            tickets.add(new Ticket())
        }
    }

    public void displayBooking() {
        System.out.printf("Booking %d %n", id);
        System.out.printf("Name %s %n", fullName);
        System.out.printf("SSn %d %n", ssn);
        System.out.printf("Train %d %n", route.train.get(0).id);
        System.out.printf("Origin %s %n", route.origin);
        System.out.printf("Destination %s %n", route.destination);
        System.out.printf("Distance %d %n", route.distance);
        System.out.printf("Number of tickets %d %n", tickets.size());
        System.out.printf("Total cost %d %n", tickets.size() * route.ticketFare);
        System.out.print("Seats: ");
        for (int i = 0; i < tickets.size; i++) {
            System.out.printf("%d, ", tickets.get(i).seatNumber);
        }
    }
}
