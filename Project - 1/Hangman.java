import java.util.*;
import java.io.*;
import java.lang.*;

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
        System.out.println("\n1 : easy \n2 : medium\n3 : hard \n4 : computer \nenter a level number only. ");
        int levelChoice;
        String choosenLevel = "";
        
        try {
            if (scan.hasNext()) {
                levelChoice = scan.nextInt();
            } else {
                System.out.println("wrong input...default level is Medium ");
                return "medium";
                // levelChoice = 2;
            }
            switch (levelChoice) {
                case 1:choosenLevel = "easy";
                break;
                case 2:choosenLevel = "medium";
                break;
                case 3:choosenLevel = "hard";
                break;
                case 4: int randomLevel = (int) (Math.random() * 3) + 1;
                    switch (randomLevel) {
                        case 1:choosenLevel = "easy";
                        break;
                        case 2:choosenLevel = "medium";
                        break;
                        case 3:choosenLevel = "hard";
                        break;
                    }
                break;
                default : choosenLevel = "medium";
            }
            System.out.println("Selected level is " + choosenLevel);
            return choosenLevel;
        } catch (InputMismatchException e) {
            System.out.println("Wrong input...default level is medium ");
            return "medium";
        }
    }

    public void setDetails(final String[] details) {
        //create MoviesInfo object
        for (int i = 0; i < details.length; i = i + 4) {
            String movieName = details[i].toLowerCase();
            String level = details[i + 1].toLowerCase();
            String production = details[i + 2];
            String cast = details[i + 3];
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
    
    private Movie selectRandomMovie(final ArrayList<Movie> levelMovies) {
        int randomIndex = (int) (Math.random() * levelMovies.size());
        Movie randomMovie = levelMovies.get(randomIndex);
        return randomMovie;
    }
    
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
            System.out.println("enter only a alphabet of length 1 ");
            return "one Character Only";
        }
        int ascii = (int) (guess.charAt(0));
        if (ascii >= 97 && ascii <= 122) {
            return guess;
        } else {
            System.out.println("enter only a alphabet ");
            return "alphabets Only";
        }
    }
    
    private boolean isAlreadyGuessed(final String alreadyGuessed,final String guess) {
        int flag = alreadyGuessed.indexOf(guess);
        if (flag == -1) {
            return false;
        }
        return true;
    }

    private String format(final String form) {
        String temp = "";
        for (int i = 0; i < form.length(); i++) {
            temp = temp + form.charAt(i) + ",";
        }
        return temp;
    }

    private String arrToStr(final String[] form) {
        String temp = "";
        for (int i = 0; i < form.length; i++) {
            temp = temp + form[i] + " ";
        }
        temp = temp.substring(0, temp.length() - 1);
        return temp;
    }

    private boolean checkGuess(final String randomMovie, final String guess) {
        int flag = randomMovie.indexOf(guess);
        if (flag == -1) {
            return false;
        }
        return true;
    }

    private int getFrequency(final String randomMovieName,final String guess,final String[] guessedMovieName) {
        int frequency = 0;
        for (int i = 0; i < randomMovieName.length(); i++) {
            if (Character.toString(randomMovieName.charAt(i)).equals(guess) && !guessedMovieName[i].equals(guess)) {
                frequency = frequency + 1;
            }
        }
        return frequency;
    }

    private String[] replaceWithGuess(final String randomMovieName, final String guess, final String[] guessedMovieName, final int frequency) {
        int index = -1;
        String[] tempGuessMovie = guessedMovieName;
        for (int i = 0; i < frequency; i++) {
            System.out.println("correct !!! ");
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
    
    private void displayInfo(final String alphabetsRemaining, final String alphabetsGuessed,final String[] guessedMovieName) {
        System.out.println("Available Alphabets = " + this.format(alphabetsRemaining));
        System.out.println("Alphabets Guessed = " + this.format(alphabetsGuessed));
        System.out.println("Guessed Movie Name = " + this.arrToStr(guessedMovieName));
    }
    
    private String[] putRandomChars(final String movieName,final String[] guessedMovieName) {
        String[] temp = guessedMovieName;
        for (int i = 0; i < movieName.length() / 3; i++) {
            int randomIndex = (int) (Math.random() * movieName.length());
            char c = movieName.charAt(randomIndex);
            temp[randomIndex] = Character.toString(c);
        }
        return temp;
    }
    
    private int numberOfLettersLeft(final String[] guessedMovieName) {
        int count = 0;
        for (int i = 0; i < guessedMovieName.length; i++) {
            if (guessedMovieName[i].equals("_")) {
                count++;
            }
        }
        return count;
    }
    
    public void readPlayerDetails(final int count) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(" numberOfPlayers " + this.players.length);
        String playerName = "player ";
        for (int i = 0; i < count; i++) {
            System.out.println("enter player " + (i + 1) + " name ");
            if (sc.hasNext()) {
                playerName = sc.next();
            } else {
                System.out.println("wrong input ... default name is used ");
                playerName = playerName + (i + 1);
            }
            Player temp = new Player(playerName, 0);
            this.players[i] = temp;
        }
    }
    
    public void playHangman(final int current) {

        try {
            System.out.println("chance of player : " + this.players[current].getPlayerName());
            String choosenLevel = this.pickLevel();
            ArrayList<Movie> levelMovies = this.getDetails(choosenLevel);
            Movie randomMovie = this.selectRandomMovie(levelMovies);
            String randomMovieName = randomMovie.getMovieName();
            int randomMovieLength = randomMovie.getMovieName().length();
            String alphabetsRemaining = "abcdefghijklmnopqrstuvwxyz";
            String alphabetsGuessed = "";
            String[] guessedMovieName = this.replaceWithUnderScores(randomMovieName);
            int playerScore = 0;
            int count = 0;
            guessedMovieName = this.putRandomChars(randomMovieName, guessedMovieName);
            int numberOfLettersLeft = this.numberOfLettersLeft(guessedMovieName);
            int maxGuesses = numberOfLettersLeft;
            System.out.println("movie Name : " + randomMovieName);
            System.out.println("movie Length : " + randomMovieLength);
            System.out.println("number of letters to guess : " + numberOfLettersLeft);
            while (maxGuesses != 0 && numberOfLettersLeft != 0) {
                this.displayInfo(alphabetsRemaining, alphabetsGuessed, guessedMovieName);
                String guess = this.takeInput();
                if (guess.equals("hint")) {
                    count++;
                    if(count == 1){
                        System.out.println(randomMovie.getCast());
                    } else if (count == 2){
                        System.out.println(randomMovie.getProduction());
                    }
                    continue;
                }
                if (guess.length() != 1) {
                    continue;
                }
                boolean isGuessed = this.isAlreadyGuessed(alphabetsGuessed, guess);
                if (!isGuessed) {
                    boolean isPresent = this.checkGuess(randomMovieName, guess);
                    if (isPresent) {
                        int frequency = this.getFrequency(randomMovieName, guess, guessedMovieName );
                        guessedMovieName = this.replaceWithGuess(randomMovieName, guess, guessedMovieName, frequency);
                        numberOfLettersLeft = this.numberOfLettersLeft(guessedMovieName);
                        playerScore = playerScore + frequency;
                    } else {
                        maxGuesses--;
                        System.out.println("Wrong !!! you have " + maxGuesses + " guesses left");
                    }
                alphabetsRemaining = alphabetsRemaining.replaceAll(guess, "");
                    alphabetsGuessed = alphabetsGuessed + guess;
                } else {
                    System.out.println("Letter already guessed ");
                }
            }
            if (count == 0) {
                playerScore = playerScore + 100;
            }else if(count == 1){
                playerScore = playerScore + 50;
            }
            this.players[current].setPlayerScore(playerScore);
            System.out.println("Name : " + this.players[current].getPlayerName() + " playerScore : " + this.players[current].getPlayerScore());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}