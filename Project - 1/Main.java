import java.io.*;
import java.util.*;

public final class Main {
    /**
     * Method to read the file and split them
     * @param fileName
     * @return
     * @throws FileNotFoundException
     */
    private static String[] readFile(final String fileName) throws FileNotFoundException {
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            ArrayList<String> lines = new ArrayList<String>();
            while (scan.hasNextLine()) {
                String temp = scan.nextLine();
                if (temp.length() != 0) {
                    lines.add(temp);
                }
            }
            scan.close();
            String[] fileContents = lines.toArray(new String[lines.size()]);
            return fileContents;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    /**
     * sorts the players based on the score in descending order.
     * and displays the player name and score.
     * @param players
     */
    private static void leaderBoard(final Player[] players) {
        // System.out.println(players.length);
        if (players == null) {
            return;
        }
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = 0; j < players.length - i - 1; j++) {
                if (players[j].getPlayerScore() < players[j + 1].getPlayerScore()) {
                    Player temp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = temp;
                }
            }
        }
        System.out.println("LeaderBoard ");
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player Name : " + players[i].getPlayerName() + " PlayerScore : " + players[i].getPlayerScore());
        }
    }
    /**
     * Main Method to create the objects and call the methods 
     * @param args
     */
    public static void main(final String[] args) {
        System.out.println("Welcome to Hangman");
        System.out.println("Enter the number of Players ");
        int numberOfPlayers = 4;
        Scanner sc = new Scanner(System.in);
        try {
            if (sc.hasNext()) {
                numberOfPlayers = sc.nextInt();
            }
        } catch (InputMismatchException is) {
            System.out.println("Wrong input...default number of players is 4 ");
        }
        try {
            System.out.println("Number of players " + numberOfPlayers);
            String[] fileContents = readFile("movies.txt");
            if (fileContents == null) {
                throw new NullPointerException();
            }
            Hangman hangman = new Hangman(numberOfPlayers);
            hangman.setDetails(fileContents);
            hangman.readPlayerDetails(numberOfPlayers);
            for (int current = 0; current < numberOfPlayers; current++) {
                hangman.playHangman(current);
            }
            leaderBoard(hangman.getPlayers());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}