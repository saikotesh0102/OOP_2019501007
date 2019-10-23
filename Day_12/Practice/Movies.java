class Movie {
    /**
     * name of the movie .
     */
    private String movieName;
     /**
     * level of the movie .
     */
    private String level;
     /**
     * production of the movie .
     */
    private String production;
     /**
     * cast of the movie .
     */
    private String cast;

    Movie(final String movieName1, final String level1, final String production1, final String cast1) {
        this.movieName = movieName1;
        this.level = level1;
        this.production = production1;
        this.cast = cast1;
    }
    public String getMovieName() {
            return movieName;
    }

    public void setMovieName(final String movieName1) {
        this.movieName = movieName1;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(final String level1) {
        this.level = level1;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(final String production1) {
        this.production = production1;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(final String cast1) {
        this.cast = cast1;
    }

}