import java.sql.Date;
import java.lang.*;
import java.util.*;

public class Show {
    public String nameOfTheMovie;
    public String dateTime; 
    public String [] seats;

    public Show(final String nameOfTheMovie, final String dateTime, final String[] seats){
        this.nameOfTheMovie = nameOfTheMovie;
        this.dateTime = dateTime;
        this.seats = new String [20];
    }

    // public void setNameOfTheMovie(final String nameOfTheMovie) {
    //     this.nameOfTheMovie = nameOfTheMovie;
    // }

    // public String getNameOfTheMovie(){
    //     return nameOfTheMovie;
    // }

    // public void setDateTime(final String dateTime) {
    //     this.dateTime = dateTime;
    // }

    // public String getDateTime(){
    //     return dateTime;
    // }

    // public void setSeats(final String[] seats) {
    //     this.seats = seats;
    // }

    // public String[] seats(){
    //     return seats;
    // }
}