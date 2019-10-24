public class Movie {
    private String movieName;
    private String level;
    private String production;
    private String cast;

    Movie(final String movieName, final String level, final String production, final String cast) {
        this.movieName = movieName;
        this.level = level;
        this.production = production;
        this.cast = cast;
    }
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(final String movieName) {
        this.movieName = movieName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(final String level) {
        this.level = level;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(final String production) {
        this.production = production;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(final String cast) {
        this.cast = cast;
    }

}