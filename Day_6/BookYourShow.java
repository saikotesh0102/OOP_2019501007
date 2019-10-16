import java.lang.*;
import java.util.*;

public class BookYourShow{
    int index;
    Show [] shows;

    public BookYourShow(){
        final int capacity = 50;
        shows = new Show[capacity];
        this.index = 0;
    }

    public void resize() {
        shows = Arrays.copyOf(shows, shows.length * 2);
    }

    public void addAShow(final Show show) {
        if (index == shows.length) {
            resize();
        }
        shows[index] = show;
        index++;
    }

    public Show getAShow(String nameOfTheMovie, String dateTime){
        for(int i = 0; i < shows.length; i++) {
            if(shows[i].getNameOfTheMovie().equals(nameOfTheMovie) && shows[i].getDateTime().equals(dateTime)){
                return shows[i];
            }
        }return null;
    }

    public void printTickets(){
        for(int i = 0; i < shows.length; i++){
            if(this.shows[i] != null){
                System.out.println(shows[i]);
            }
        }
    }

    public void removeAMovie(String nameOfTheMovie){
        for(int i = 0; i < shows.length; i++){
            if(shows[i].getNameOfTheMovie().equals(nameOfTheMovie)){
                shows[i] = null;
            }
        }
    }
}