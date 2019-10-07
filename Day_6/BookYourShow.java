import java.lang.*;
import java.util.*;

public class BookYourShow{
    int index;
    Show [] shows;

    public BookYourShow(){
        shows = new Show[10];
        index = 0;
    }

    public void addAShow(Show addition){
        shows[index] = addition;
        index++;
    }

    public Show getAShow(String nameOfTheMovie){
        for(int i = 0; i < shows.length; i++) {
            if(shows[i].nameOfTheMovie.equals(nameOfTheMovie)) {
                return shows[i];
            }
        }return null;
    }

    public Show bookAShow(String name, String mobileNumber, String dateTime, int numberOfSeats){
        if (numberOfSeats <= seats.length){
            
        }
    }
}