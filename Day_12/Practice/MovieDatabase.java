import java.util.*;

class MovieDatabase {
    /**
     * an arraylist of movies of easy level.
     */
    private ArrayList<Movie> easyMovies;
    /**
     * an arraylist of movies of medium level.
     */
    private ArrayList<Movie> mediumMovies;
    /**
     * an arraylist of movies of hard level.
     */
    private ArrayList<Movie> hardMovies;

    MovieDatabase() {
        easyMovies = new ArrayList<>();
        mediumMovies = new ArrayList<>();
        hardMovies = new ArrayList<>();
    }

    public ArrayList<Movie> getEasyMovies() {
        return easyMovies;
    }

    public void setEasyMovies(final Movie easyMovies1) {
        this.easyMovies.add(easyMovies1);
    }

    public ArrayList<Movie> getMediumMovies() {
        return mediumMovies;
    }

    public void setMediumMovies(final Movie mediumMovies1) {
        this.mediumMovies.add(mediumMovies1);
    }

    public ArrayList<Movie> getHardMovies() {
        return hardMovies;
    }

    public void setHardMovies(final Movie hardMovies1) {
        this.hardMovies.add(hardMovies1);
    }
}