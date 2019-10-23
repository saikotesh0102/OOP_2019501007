import java.util.*;

public class Hangman {
    private MovieDatabase moviesDatabase;
    private Player[] players;

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(final Player[] players) {
        this.players = players;
    }

    public MovieDatabase getMovie() {
        return moviesDatabase;
    }

    public void setMovie(final MovieDatabase moviesDatabase) {
        this.moviesDatabase = moviesDatabase;
    }

    public Hangman(final int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        moviesDatabase = new MovieDatabase();
    }
    
    private String pickLevel() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n1 : easy \n2 : medium\n3 : Hard \n 4 : computer \nenter a level number only. ");
        int levelChoice;
        String choosenLevel = "";
        final int three = 3;
        final int four = 4;
        try {
            if (scan.hasNext()) {
                levelChoice = scan.nextInt();
            } else {
                System.out.println(" wrong input...default level is medium ");
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
            System.out.println("wrong input...default level is medium ");
            return "medium";
        }
    }

    /**
     * iterates through the details string array.
     * The four consecutive indexes of details consists of
     * movie name, level, cast, production.
     * creates a movie object for each movie.
     * if the level is easy adds the movie
     * to easyMovies ArrayList in moviesDatabase.
     * if the level is medium adds the movie
     * to mediumMovies ArrayList in moviesDatabase.
     * if the level is hard adds the movie
     * to hardMovies ArrayList in moviesDatabase.
     * @param details contains the information of the movies as string array .
     */
    public void setDetails(final String[] details) {
        //create MoviesInfo object
        final int three = 3;
        final int four = 4;
        for (int i = 0; i < details.length; i = i + four) {
            String movieName = details[i].toLowerCase();
            String level = details[i + 1].toLowerCase();
            String production = details[i + 2];
            String cast = details[i + three];
            Movie movie = new Movie(movieName, level, production, cast);
            if (level.equals("easy")) {
                this.moviesDatabase.setEasyMovies(movie);
            } else if (level.equals("medium")) {
                this.moviesDatabase.setMediumMovies(movie);
            } else if (level.equals("hard")) {
                this.moviesDatabase.setHardMovies(movie);
            }
        }
    }
    /**
     * depending upon the choosen level movies arraylist is returned.
     * if the choosen level is easy
     * easyMovies from movies Database is returned.
     * if the choosen level is medium
     * mediumMovies from movies Database is returned.
     * if the choosen level is hard
     * hardMovies from movies Database is returned.
     * @param choosenLevel level of the movies .
     * @return a arraylist of movies of choosen level.
     */
    private ArrayList<Movie> getDetails(final String choosenLevel) {
        if (choosenLevel.equals("easy")) {
               return this.moviesDatabase.getEasyMovies();
        } else if (choosenLevel.equals("medium")) {
            return this.moviesDatabase.getMediumMovies();
        } else if (choosenLevel.equals("hard")) {
            return this.moviesDatabase.getHardMovies();
        } else {
            return this.moviesDatabase.getMediumMovies();
        }
    }
    /**
     * generates a random integer in the range of zero and size of levelmovies.
     * based on the random integer movie at that
     * postion in level movies is selected.
     * that selected movie is returned .
     * @param levelMovies an arraylist consists of movies of particular level.
     * @return an Movie object generated randomly.
     */
    private Movie selectRandomMovie(final ArrayList<Movie> levelMovies) {
        int randomIndex = (int) (Math.random() * levelMovies.size());
        Movie randomMovie = levelMovies.get(randomIndex);
        return randomMovie;
    }
    /**
     * asks the user to enter an input .
     * if input is empty returns empty string.
     * if input is hint returns "hint".
     * if input is not hint and length > 1 returns "oneCharacterOnly"
     * if input is not hint and length = 1 and
     * input is alphabet returns input else returns "alphabetsOnly"
     * @return returns the string based on input .
     */
    private String takeInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a character or hint ");
        String guess = "";
        if (scan.hasNext()) {
            guess = scan.next();
        } else {
            return guess;
        }
        if (guess.equals("hint")) {
            return guess;
        }
        if (guess.length() != 1) {
            System.out.println(" enter only a alphabet of length 1 ");
            return "oneCharacterOnly";
        }
        int ascii = (int) (guess.charAt(0));
        final int start = 97;
        final int end = 122;
        if (ascii >= start && ascii <= end) {
            return guess;
        } else {
            System.out.println(" enter only a alphabet ");
            return "alphabetsOnly";
        }
    }
    /**
     * checks if the letter is in already guessed string or not.
     * if letter is already guessed returns false else returns true
     * @param alreadyGuessed string consists of guessed letters.
     * @param guess the letter which is to be checked.
     * @return boolean based on the letter present or not .
     */
    private boolean isAlreadyGuessed(final String alreadyGuessed,
            final String guess) {
        int flag = alreadyGuessed.indexOf(guess);
        if (flag == -1) {
            return false;
        }
        return true;
    }

    /**
     * creates a string where each character is seperated by comma.
     * @param form string .
     * @return string with , separated.
     */
    private String format(final String form) {
        String temp = "";
        for (int i = 0; i < form.length(); i++) {
            temp = temp + form.charAt(i) + ",";
        }
        return temp;
    }

    /**
     * creates a string where each string array element is seperated by space.
     * @param form string array .
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
     * checks if the guessed letter is in movie name or not.
     * if guessed letter is in movieName returns true else returns false .
     * @param randomMovie string movie name .
     * @param guess a letter .
     * @return boolean based on if letter in movie name.
     */
    private boolean checkGuess(final String randomMovie, final String guess) {
        int flag = randomMovie.indexOf(guess);
        if (flag == -1) {
            return false;
        }
        return true;
    }

    /**
     * counts the number of times the letter is in the movieName
     * gussed movie name string array.
     * @param randomMovieName string name of the movie.
     * @param guessedMovieName the string array which consists of underscores
     * and letters that have been revealed so far.
     * @param guess a letter.
     * @return int frequency of guess
     */
    private int getFrequency(final String randomMovieName,
            final String guess,
            final String[] guessedMovieName) {
        int frequency = 0;
        for (int i = 0; i < randomMovieName.length(); i++) {
            if (Character.toString(randomMovieName.charAt(i)).equals(guess)
                &&
                !guessedMovieName[i].equals(guess)) {
                frequency = frequency + 1;
            }
        }
        return frequency;
    }

    /**
     * replaces the guess letter in guessed movie array
     * at same postion as in movie name.
     * @param randomMovieName string name of the movie .
     * @param guess guess letter .
     * @param guessedMovieName consists of underscore and
     * letters revealed so far .
     * @param frequency number of times the guess letter
     *  is in movie name.
     * @return int array
     */
    private String[] replaceWithGuess(final String randomMovieName,
            final String guess,
            final String[] guessedMovieName,
            final int frequency) {
        int index = -1;
        String[] tempGuessMovie = guessedMovieName;
        for (int i = 0; i < frequency; i++) {
            System.out.println(" correct !!! ");
            index = randomMovieName.indexOf(guess, index);
            if (!tempGuessMovie[index].equals(guess)) {
                tempGuessMovie[index] = guess;
            } else {
                index = randomMovieName.indexOf(guess, index + 1);
                if (index != -1) {
                    tempGuessMovie[index] = guess;
                }
            }
            index = index + 1;
        }
        return tempGuessMovie;
    }
    /**
     * creates a new string array of movieName length.
     * this array consists of underscores at each postion.
     * special characters are placed in same postion as in movie name.
     * returns that array
     * @param movieName string name of the movie.
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
     * displays the information .
     * @param alphabetsRemaining string alphabets remaining.
     * @param alphabetsGuessed string alphabets guessed so far .
     * @param guessedMovieName string movie name revealed so far.
     */
    private void displayInfo(final String alphabetsRemaining,
                    final String alphabetsGuessed,
                    final String[] guessedMovieName) {
        System.out.println(" availableAlphabets = "
            + this.format(alphabetsRemaining));
        System.out.println(" alphabetsGuessed = "
            + this.format(alphabetsGuessed));
        System.out.println(" guessedMovieName = "
            + this.arrToStr(guessedMovieName));
    }
    /**
     * replaces the 1/3rd of characters in the movie to be
     *  guessed array with certain letters of movie .
     * @param movieName name of the movie .
     * @param guessedMovieName movie name guessed so far .
     * @return string array guessed movie name .
     */
    private String[] putRandomChars(final String movieName,
                final String[] guessedMovieName) {
        final int three = 3;
        String[] temp = guessedMovieName;
        for (int i = 0; i < movieName.length() / three; i++) {
            int randomIndex = (int) (Math.random() * movieName.length());
            char c = movieName.charAt(randomIndex);
            temp[randomIndex] = Character.toString(c);
        }
        return temp;
    }
    /**
     * finds the total numbers of letters which have not been guessed yet.
     * @param guessedMovieName string array name of the movie guessed so far.
     * @return int  .
     */
    private int numberOfLettersLeft(final String[] guessedMovieName) {
        int count = 0;
        for (int i = 0; i < guessedMovieName.length; i++) {
            if (guessedMovieName[i].equals("_")) {
                count++;
            }
        }
        return count;
    }
    /**
     * reads the player name from the user.
     * creates a player object with name as input and score as 0.
     * adds this player object to players array
     * @param count int number of players .
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
     * displays the length of movie to be guessed .
     * displays the number of missing letters.
     * displays the movie name with 1/3rd letters.
     * and asks the user to guess the movie .
     * asks the user to guess or take a hint.
     * takes an input from user.
     * checks if the input is valid or not.
     * for each correct guess a point is added and
     * for each wrong guess a point deducted and maxGuesses are decreased
     * if hint is not taken bonus points of 100 is added
     * game is terminated if the maxGuessed are zero or
     *  number of missing letters are zero.
     * at the end sets the score to the player
     * @param current integer the current player index.
     */
    public void playHangman(final int current) {

        try {
            System.out.println("Chance of Player Name "
                + this.players[current].getPlayerName());
            String choosenLevel = this.pickLevel();
            ArrayList<Movie> levelMovies = this.getDetails(choosenLevel);
            Movie randomMovie = this.selectRandomMovie(levelMovies);
            String randomMovieName = randomMovie.getMovieName();
            int randomMovieLength = randomMovie.getMovieName().length();
            String alphabetsRemaining = "abcdefghijklmnopqrstuvwxyz";
            String alphabetsGuessed = "";
            String[] guessedMovieName =
                this.replaceWithUnderScores(randomMovieName);
            int playerScore = 0;
            boolean hintTaken = false;
            guessedMovieName =
                this.putRandomChars(randomMovieName, guessedMovieName);
            int numberOfLettersLeft =
                this.numberOfLettersLeft(guessedMovieName);
            int maxGuesses = numberOfLettersLeft;
            System.out.println(" randomMovieName " + randomMovieName);
            System.out.println(" randomMovieLength " + randomMovieLength);
            System.out.println(" number of letters to guess "
                + numberOfLettersLeft);
            while (maxGuesses != 0 && numberOfLettersLeft != 0) {
                this.displayInfo(alphabetsRemaining,
                    alphabetsGuessed, guessedMovieName);
                String guess = this.takeInput();
                if (guess.equals("hint")) {
                    System.out.println(randomMovie.getCast() + " "
                         + randomMovie.getProduction());
                    hintTaken = true;
                    continue;
                }
                if (guess.length() != 1) {
                    continue;
                }
                boolean isGuessed = this.isAlreadyGuessed(alphabetsGuessed,
                            guess);
                if (!isGuessed) {
                    boolean isPresent = this.checkGuess(randomMovieName, guess);
                    if (isPresent) {
                        int frequency = this.getFrequency(randomMovieName,
                            guess, guessedMovieName
                            );
                        guessedMovieName =
                          this.replaceWithGuess(randomMovieName,
                             guess, guessedMovieName,
                             frequency
                             );
                        numberOfLettersLeft =
                             this.numberOfLettersLeft(
                                guessedMovieName
                                );
                        playerScore = playerScore + frequency;
                    } else {
                        System.out.println(" wrong !!! ");
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
            System.out.println(" Name " + this.players[current].getPlayerName()
                +
                " playerScore " + this.players[current].getPlayerScore());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}