import java.lang.*;
import java.util.*;
import java.io.*;

class Hangman {
    /**
     * all movie details .
     */
    private Movie[] movies;
    /**
     *  movie details of easy level .
     */
    private Movie[] easyMovies;
    /**
     *  movie details of medium level .
     */
    private Movie[] mediumMovies;
    /**
     *  movie details of hard level .
     */
    private Movie[] hardMovies;
    /**
     * player details .
     */
    private Player[] players;

        public Movie[] getMovies() {
        return movies;
    }

    public void setMovies(Movie[] movies) {
        this.movies = movies;
    }

    public Movie[] getEasyMovies() {
        return easyMovies;
    }

    public void setEasyMovies(Movie[] easyMovies) {
        this.easyMovies = easyMovies;
    }

    public Movie[] getMediumMovies() {
        return mediumMovies;
    }

    public void setMediumMovies(Movie[] mediumMovies) {
        this.mediumMovies = mediumMovies;
    }

    public Movie[] getHardMovies() {
        return hardMovies;
    }

    public void setHardMovies(Movie[] hardMovies) {
        this.hardMovies = hardMovies;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * create the array of Movie objects and player objects.
     * @param numberOfMovies number of movies.
     * @param numberOfPlayers number of players .
     */
    Hangman(final int numberOfMovies, final int numberOfPlayers) {
        movies = new Movie[numberOfMovies];
        easyMovies = new Movie[1];
        mediumMovies = new Movie[1];
        hardMovies = new Movie[1];
        players = new Player[numberOfPlayers];
    }
    /**
     * takes an input from user as integer.
     * 1.easy 2.medium 3.hard 4.computer
     * if the input is not in the range or
     * not valid default level medium is set
     * @return a selected level.
     */
    private String pickLevel() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" \n 1 : easy \n 2 : medium \n 3 : Hard \n 4 : computer \n enter a level number only. ");
        int levelChoice;
        String choosenLevel = "";
        final int three = 3;
        final int four = 4;
        try {
            if (scan.hasNext()) {
                levelChoice = scan.nextInt();
            } else {
                System.out.println(" wrong input ... default selected level is medium ");
                return "medium";
                // levelChoice = 2;
            }
            switch (levelChoice) {
                case 1:choosenLevel = "easy";
                break;
                case 2:choosenLevel = "medium";
                break;
                case three:choosenLevel = "hard";
                break;
                case four: int randomLevel = (int) (Math.random() * three) + 1;
                    switch (randomLevel) {
                        case 1:choosenLevel = "easy";
                        break;
                        case 2:choosenLevel = "medium";
                        break;
                        case three:choosenLevel = "hard";
                        break;
                        default:
                        break;
                    }
                break;
                default : choosenLevel = "medium";
            }
            System.out.println(" selected level is " + choosenLevel);
            return choosenLevel;
        } catch (InputMismatchException e) {
            System.out.println(" wrong input ... default selected level is medium ");
            return "medium";
        }
    }
    /**
     * creates a new Movie array of size 1 greater than current movie array.
     * copies the contents of movie array into a new Movie array.
     * @param movie array
     * @return Movie array..
     */
    private Movie[] resize(final Movie[] movie) {
        Movie[] temp = movie;
        temp =  Arrays.copyOf(temp, temp.length + 1);
        return temp;
    }
    /**
     * creates a movie object for each movie.
     * and adds to the movie field that is intialised
     * @param details contains the information of the movies as string
     */
    public void setDetails(final String[] details) {
        //create MoviesInfo object
        int count = 0;
        int easy = 0;
        int medium = 0;
        int hard = 0;
        final int three = 3;
        final int four = 4;
        for (int i = 0; i < details.length; i = i + four) {
            String movieName = details[i].toLowerCase();
            String level = details[i + 1].toLowerCase();
            String production = details[i + 2];
            String cast = details[i + three];
            Movie movie = new Movie(movieName, level, production, cast);
            movies[count] = movie;
            count++;

            if (level.equals("easy")) {
               easyMovies[easy] = movie;
               easy++;
               easyMovies = resize(easyMovies);
            } else if (level.equals("medium")) {
               mediumMovies[medium] = movie;
               medium++;
               mediumMovies = resize(mediumMovies);
            } else if (level.equals("hard")) {
               hardMovies[hard] = movie;
               hard++;
               hardMovies = resize(hardMovies);
            }
        }
    }

    /**
     * checks the choosenLevel with each movie in the array.
     * finds number of movies that match the choosenLevel i.e count.
     * creates a new Movie array of size count.
     * adds all the movies that match the choosenLevel into new Movie array.
     * @param choosenLevel level choosen by user
     * @return an array of Movie
     */
    private Movie[] getDetails(final String choosenLevel) {
        if (choosenLevel.equals("easy")) {
               return easyMovies;
        } else if (choosenLevel.equals("medium")) {
            return mediumMovies;
        } else if (choosenLevel.equals("hard")) {
            return hardMovies;
        } else {
            return mediumMovies;
        }
    }
    /**
     * generates a random integer of size levelMovies.
     * based on randomInteger chooses that position movie
     * @param levelMovies consists of movies of the choosenLevel
     * @return Movie
     */
    private Movie selectRandomMovie(final Movie[] levelMovies) {
        int randomIndex = (int) (Math.random() * levelMovies.length);
        Movie randomMovie = levelMovies[randomIndex];
        return randomMovie;
    }
    /**
     * asks the user to enter an alphabet .
     * if input is empty returns empty string.
     * if input is hint returns hint.
     * if input is not hint and length > 1 returns oneCharacterOnly
     * if input is not hint and length = 1
     * and
     * input is alphabet returns guess else returns alphabetsOnly
     * @param randomMovie movie object .
     * @return .
     * @throws InputMismatchException .
     */
    private String takeInput(final Movie randomMovie) {
        // takes input from user
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a character or hint ");
        String guess = "";
        if (scan.hasNext()) {
            guess = scan.next();
        } else {
            return "";
        }
        if (guess.equals("hint")) {
            System.out.println(randomMovie.getCast() + "   " + randomMovie.getProduction());
            return guess;
        }
        if (guess.length() != 1) {
            System.out.println(" enter only a alphabet of length 1 ");
            return "oneCharacterOnly";
        }
        int asc = (int) (guess.charAt(0));
        final int start = 97;
        final int end = 122;
        if (asc >= start && asc <= end) {
            return guess;
        } else {
            System.out.println(" enter only a alphabet ");
            return "alphabetsOnly";
        }
    }
    /**
     * checks if the letter is in alreadyguessed string or not.
     * if alreadyguessed returns false else returns true
     * @param alreadyGuessed string .
     * @param guess guessed letter .
     * @return boolean.
     */
    private boolean alreadyGuessed(final String alreadyGuessed, final String guess) {
        int flag = alreadyGuessed.indexOf(guess);
        if (flag == -1) {
            return true;
        }
        return false;
    }
    /**
     * if guessed letter is in movieName or not.
     * if present returns true else returns false
     * @param randomMovie string movieName
     * @param guess guessed letter .
     * @return boolean .
     */
    private boolean checkGuess(final String randomMovie, final String guess) {
        int flag = randomMovie.indexOf(guess);
        if (flag == -1) {
            return false;
        }
        return true;
    }
    /**
     * creates a string where each character is seperated by comma.
     * @param form string
     * @return string .
     */
    private String format(final String form) {
        String temp = "";
        for (int i = 0; i < form.length(); i++) {
            temp = temp + form.charAt(i) + ",";
        }
        return temp;
    }
    /**
     * creates a string where each string array element is seperated by comma.
     * @param form string array
     * @return string .
     */
    private String arrToStr(final String[] form) {
        String temp = "";
        for (int i = 0; i < form.length; i++) {
            temp = temp + form[i] + " ";
        }
        temp = temp.substring(0, temp.length() - 1);
        return temp;
    }

    /**
     * counts the number of times the guess Letter is in the movieName.
     * @param randomMovieName string moviename .
     * @param guess guess letter
     * @return frequency.
     */
    private int getFrequency(final String randomMovieName, final String guess) {
        int frequency = 0;
        for (int i = 0; i < randomMovieName.length(); i++) {
            if (Character.toString(randomMovieName.charAt(i)).equals(guess)) {
                frequency = frequency + 1;
            }
        }
        return frequency;
    }
    /**
     * replaces guess letter in guessedMovieName array .
     * @param randomMovieName string moviename .
     * @param guess guess letter .
     * @param guessedMovieName consists of underscore and letters guessed .
     * @param frequency number of times the guess is in movie name.
     * @return int array
     */
    private String[] replaceWithGuess(final String randomMovieName, final String guess, final String[] guessedMovieName, final int frequency) {
        int index = -1;
        String[] tempGuessMovie = guessedMovieName;
        for (int i = 0; i < frequency; i++) {
            System.out.println(" correct !!! ");
            index = randomMovieName.indexOf(guess, index);
            tempGuessMovie[index] = guess;
            index = index + 1;
        }
        return tempGuessMovie;
    }
    /**
     * replaces the string array with underscores
     * creates a new string array of movieName length.
     * this array consists of underscores at each postion
     * except at \' and ' '
     * returns that array
     * @param movieName string movieName
     * @return string array
     */
    private String[] replaceWithUnderScores(final String movieName) {
        String[] guessedMovieName = new String[movieName.length()];
        for (int i = 0; i < movieName.length(); i++) {
            if (movieName.charAt(i) == '\'' || movieName.charAt(i) == ' ') {
                guessedMovieName[i] = Character.toString(movieName.charAt(i));
            } else {
                guessedMovieName[i] = "_";
            }
        }
        return guessedMovieName;
    }
    /**
     * checks the special characters and returns count .
     * @param movieName string name of the movie .
     * @return int .
     */
    private int numberOfSpecialChars(final String movieName) {
        int count = 0;
        for (int i = 0; i < movieName.length(); i++) {
            if (movieName.charAt(i) == '\'' || movieName.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
    /**
     * displays the info .
     * @param alphabetsRemaining string.
     * @param alphabetsGuessed string .
     * @param guessedMovieName string.
     */
    private void displayInfo(final String alphabetsRemaining, final String alphabetsGuessed, final String[] guessedMovieName) {
        System.out.println(" availableAlphabets = " + this.format(alphabetsRemaining));
        System.out.println(" alphabetsGuessed = " + this.format(alphabetsGuessed));
        System.out.println(" guessedMovieName = " + this.arrToStr(guessedMovieName));
    }

    private String[] putRandomChars(String movieName, String[] guessedMovieName) {
        for(int i = 0; i < movieName.length()/3; i++) {
            int randomIndex = (int) (Math.random() * movieName.length());
            char c = movieName.charAt(randomIndex);
            guessedMovieName[randomIndex] = Character.toString(c);
        }
        return guessedMovieName;
    }
    /**
     * reads the player details such as name.
     * creates a player object with name as input
     * and score as 0.
     * @param count int players .
     */
    public void readPlayerDetails(final int count) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(" numberOfPlayers " + this.players.length);
        String playerName = "Player ";
        for (int i = 0; i < count; i++) {
            System.out.println(" enter Player " + (i + 1) + " Name ");
            if (sc.hasNext()) {
                playerName = sc.next();
            } else {
                System.out.println(" wrong input ... default name is used ");
                playerName = playerName + (i + 1);
            }
            Player temp = new Player(playerName, 0);
            this.players[i] = temp;
        }
    }
    /**
     * displays the length of string .
     * and asks the user to guess it .
     * takes a character at one time from user.
     * for each correct guess a point is added and
     * for each worng guess a point deducted and maxGuesses are decreased
     * if hint is not taken bonus points of 100 is added
     * game is terminated if the maxGuessed are zero or entire word is guessed.
     * sets the score to the player
     * @param current integer the current player index.
     */
    public void playHangman(final int current) {

        try {
            System.out.println("Chance of Player Name " + this.players[current].getPlayerName());
            String choosenLevel = this.pickLevel();
            Movie[] levelMovies = this.getDetails(choosenLevel);
            Movie randomMovie = this.selectRandomMovie(levelMovies);
            String randomMovieName = randomMovie.getMovieName();
            int randomMovieLength = randomMovie.getMovieName().length();
            String alphabetsRemaining = "abcdefghijklmnopqrstuvwxyz";
            String alphabetsGuessed = "";
            String[] guessedMovieName = this.replaceWithUnderScores(randomMovieName);
            int count = this.numberOfSpecialChars(randomMovieName);
            count = count + randomMovieLength/3 ;
            int playerScore = 0;
            int maxGuesses = 6;
            int correctGuesses = 0;
            int wrongGuesses = 0;
            boolean hintTaken = false;
            guessedMovieName = this.putRandomChars(randomMovieName, guessedMovieName);
            System.out.println(" randomMovieName " + randomMovieName);
            System.out.println(" randomMovieLength " + (randomMovieLength - count));

            while (maxGuesses != 0 && (correctGuesses != (randomMovieLength - count))) {
                this.displayInfo(alphabetsRemaining, alphabetsGuessed, guessedMovieName);
                String guess = this.takeInput(randomMovie);
                if (guess.equals("hint")) {
                    hintTaken = true;
                    continue;
                }
                if (guess.length() != 1) {
                    continue;
                }
                boolean alreadyGuessed = this.alreadyGuessed(alphabetsGuessed, guess);
                if (alreadyGuessed) {
                    boolean isPresent = this.checkGuess(randomMovieName, guess);
                    if (isPresent) {
                        int frequency = this.getFrequency(randomMovieName, guess);
                        guessedMovieName =  this.replaceWithGuess(randomMovieName, guess, guessedMovieName, frequency);
                        correctGuesses = correctGuesses + frequency;
                        playerScore = playerScore + frequency;
                    } else {
                        System.out.println(" wrong !!! ");
                        wrongGuesses++;
                        playerScore--;
                        maxGuesses--;
                    }
                    alphabetsRemaining = alphabetsRemaining.replaceAll(guess, "");
                    alphabetsGuessed = alphabetsGuessed + guess;
                } else {
                    System.out.println(" letter already guessed ");
                }
            }
            if (!hintTaken) {
                final int hundred = 100;
                playerScore = playerScore + hundred;
            }
            this.players[current].setPlayerScore(playerScore);
            System.out.println(" playerName " + this.players[current].getPlayerName() + " playerScore " + this.players[current].getPlayerScore());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}