import java.sql.Date;
import java.lang.*;
import java.util.*;

public class Show {
    private String nameOfTheMovie;
    private String dateTime; 
    private String [] seats;
    private int tickets;
    private String [] ticketHolderDetails;

    public Show(final String nameOfTheMovie, final String dateTime, final String[] seats){
        this.nameOfTheMovie = nameOfTheMovie;
        this.dateTime = dateTime;
        this.seats = seats;
        final int capacity = 20;
        this.ticketHolderDetails = new String[capacity];
        this.tickets = 0;
    }

    public void setNameOfTheMovie(final String nameOfTheMovie) {
        this.nameOfTheMovie = nameOfTheMovie;
    }

    public String getNameOfTheMovie(){
        return nameOfTheMovie;
    }

    public void setDateTime(final String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime(){
        return dateTime;
    }

    public void setSeats(final String[] seats) {
        this.seats = seats;
    }

    public String[] seats(){
        return seats;
    }

    public void setTickets(final int tickets) {
        this.tickets = tickets;
    }

    public int getTickets(){
        return tickets;
    }

    public void setTicketHolderDetails(final String[] ticketHolderDetails){
        this.ticketHolderDetails = ticketHolderDetails;
    }

    public String[] getTicketHolderDetails(){
        return ticketHolderDetails;
    }

    public void update(final int midx) {
        int seatIndex = midx;
        for (int index = midx + 1; index < seats.length; index++) {
            seats[seatIndex] = seats[index];
            seatIndex++;
        }
        seats = Arrays.copyOfRange(seats, 0, seats.length - 1);
    }

    public void bookAShow(final Patron patron, final String[] seats1) {
        int count = 0;
        for (int i = 0; i < seats1.length; i++) {
            for (int j = 0; j < this.seats.length; j++) {
                if (seats1[i].equals(seats[j])) {
                    seats[j] = null;
                    count++;
                    update(j);
                    break;
                }
            }
        }

        if (count == seats1.length) {
            if (ticketHolderDetails.length == tickets) {
                ticketHolderDetails = Arrays.copyOf(ticketHolderDetails, tickets * 2);
            }
            ticketHolderDetails[tickets] = patron.getName() + " : " + Arrays.toString(seats1);
            tickets++;
        } else {
            System.out.println(patron.getName() + " Some Seats are already booked So Please book seats in Available seats : " + Arrays.toString(seats));
            }
    }

    public void printTickets(final Patron user) {
        int len = user.getName().length();
        boolean booked = false;
        int index;
        for (index = 0; index < tickets; index++) {
            if (ticketHolderDetails[index] != null && ticketHolderDetails[index].substring(0, len).equals(user.getName())) {
                booked = true;
                break;
            }
        }   
        if (booked) {
            System.out.println(ticketHolderDetails[index]);
        } else {
            System.out.println(user.getName() + " has not booked any tickets");
        }
    }

    public String toString() {
        return "Show [Movie Name = " + nameOfTheMovie + ", Date and Time = " + dateTime + "]";
    }
}