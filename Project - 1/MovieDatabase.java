import java.util.*;
import java.io.*;

public class MovieDatabase {
    
    private ArrayList<Movie> easyMovies;
    private ArrayList<Movie> mediumMovies;
    private ArrayList<Movie> hardMovies;

    public MovieDatabase() {
        easyMovies = new ArrayList<>();
        mediumMovies = new ArrayList<>();
        hardMovies = new ArrayList<>();
    }

    public ArrayList<Movie> getEasyMovies() {
        return easyMovies;
    }

    public void setEasyMovies(final Movie easyMovies) {
        this.easyMovies.add(easyMovies);
    }

    public ArrayList<Movie> getMediumMovies() {
        return mediumMovies;
    }

    public void setMediumMovies(final Movie mediumMovies) {
        this.mediumMovies.add(mediumMovies);
    }

    public ArrayList<Movie> getHardMovies() {
        return hardMovies;
    }

    public void setHardMovies(final Movie hardMovies) {
        this.hardMovies.add(hardMovies);
    }
}