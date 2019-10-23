import java.lang.*;
import java.util.*;
import java.io.*;

class Hangman {

    private Movie[] movies;
    private Movie[] easyMovies;
    private Movie[] mediumMovies;
    private Movie[] hardMovies;

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

    Hangman(final int numberOfMovies, final int numberOfPlayers) {
        movies = new Movie[numberOfMovies];
        easyMovies = new Movie[1];
        mediumMovies = new Movie[1];
        hardMovies = new Movie[1];
        players = new Player[numberOfPlayers];
    }

    private String pickLevel() {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n1 : easy\n2 : medium\n3 : Hard \n4 : computer \nenter a level number only. ");
        int levelChoice;
        String choosenLevel = "";
        final int three = 3;
        final int four = 4;
        try {
            if (scan.hasNext()) {
                levelChoice = scan.nextInt();
            } else {
                System.out.println("wrong input ... default selected level is medium");
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
            System.out.println("selected level is " + choosenLevel);
            return choosenLevel;
        } catch (InputMismatchException e) {
            System.out.println("wrong input ... default selected level is medium ");
            return "medium";
        }
    }
    
    private Movie[] resize(final Movie[] movie) {
        Movie[] temp = movie;
        temp =  Arrays.copyOf(temp, temp.length + 1);
        return temp;
    }

    public void setDetails(final String[] details) {

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
    
    private Movie selectRandomMovie(final Movie[] levelMovies) {
        int randomIndex = (int) (Math.random() * levelMovies.length);
        Movie randomMovie = levelMovies[randomIndex];
        return randomMovie;
    }
    
    private String takeInput(final Movie randomMovie) {
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
            System.out.println("enter only a alphabet of length 1");
            return "oneCharacterOnly";
        }
        int asc = (int) (guess.charAt(0));
        final int start = 97;
        final int end = 122;
        if (asc >= start && asc <= end) {
            return guess;
        } else {
            System.out.println("enter only a alphabet");
            return "alphabetsOnly";
        }
    }

    private boolean alreadyGuessed(final String alreadyGuessed, final String guess) {
        int flag = alreadyGuessed.indexOf(guess);
        if (flag == -1) {
            return true;
        }
        return false;
    }
    
    private boolean checkGuess(final String randomMovie, final String guess) {
        int flag = randomMovie.indexOf(guess);
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

    private int getFrequency(final String randomMovieName, final String guess) {
        int frequency = 0;
        for (int i = 0; i < randomMovieName.length(); i++) {
            if (Character.toString(randomMovieName.charAt(i)).equals(guess)) {
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
            tempGuessMovie[index] = guess;
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
    
    private int numberOfSpecialChars(final String movieName) {
        int count = 0;
        for (int i = 0; i < movieName.length(); i++) {
            if (movieName.charAt(i) == '\'' || movieName.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
    
    private void displayInfo(final String alphabetsRemaining, final String alphabetsGuessed, final String[] guessedMovieName) {
        System.out.println("availableAlphabets = " + this.format(alphabetsRemaining));
        System.out.println("alphabetsGuessed = " + this.format(alphabetsGuessed));
        System.out.println("guessedMovieName = " + this.arrToStr(guessedMovieName));
    }

    private String[] putRandomChars(String movieName, String[] guessedMovieName) {
        for(int i = 0; i < movieName.length()/3; i++) {
            int randomIndex = (int) (Math.random() * movieName.length());
            char c = movieName.charAt(randomIndex);
            guessedMovieName[randomIndex] = Character.toString(c);
        }
        return guessedMovieName;
    }
    
    public void readPlayerDetails(final int count) {
        Scanner sc = new Scanner(System.in);
        // System.out.println(" numberOfPlayers " + this.players.length);
        String playerName = "Player ";
        for (int i = 0; i < count; i++) {
            System.out.println("enter Player " + (i + 1) + " Name ");
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
            System.out.println("randomMovieName " + randomMovieName);
            System.out.println("randomMovieLength " + (randomMovieLength - count));

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
                        System.out.println("wrong !!!");
                        wrongGuesses++;
                        playerScore--;
                        maxGuesses--;
                    }
                    alphabetsRemaining = alphabetsRemaining.replaceAll(guess, "");
                    alphabetsGuessed = alphabetsGuessed + guess;
                } else {
                    System.out.println("letter already guessed");
                }
            }
            if (!hintTaken) {
                final int hundred = 100;
                playerScore = playerScore + hundred;
            }
            this.players[current].setPlayerScore(playerScore);
            System.out.println("playerName " + this.players[current].getPlayerName() + "playerScore " + this.players[current].getPlayerScore());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}