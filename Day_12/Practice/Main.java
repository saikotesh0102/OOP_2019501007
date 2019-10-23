import java.io.*;
import java.util.*;

public final class Main {
    private Main() {
    }
    /**
     * reads the file and adds the line into ArrayList.
     * empty lines are skipped
     * converts the arrayList into a String array
     * @param fileName string . name of the file.
     * @return string array contains details of file.
     * @throws FileNotFoundException if file is not found.
     */
     private static String[] readFile(final String fileName)
            throws FileNotFoundException {
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
     * sorts the players based on the score.
     * and displays the player name and score.
     * @param players array of players .
     */
    private static void leaderBoard(final Player[] players) {
        System.out.println(players.length);
        if (players == null) {
            return;
        }
        for (int i = 0; i < players.length - 1; i++) {
            for (int j = 0; j < players.length - i - 1; j++) {
                if (players[j].getPlayerScore()
                    <
                    players[j + 1].getPlayerScore()) {
                    Player temp = players[j];
                    players[j] = players[j + 1];
                    players[j + 1] = temp;
                }
            }
        }
        System.out.println(" LeaderBoard ");
        for (int i = 0; i < players.length; i++) {
            System.out.println(" playerName = " + players[i].getPlayerName()
                + " playerScore " + players[i].getPlayerScore());
        }
    }
    /**
     * reads the numberOfPlayers .
     * if correct input is not given default number 4 is taken.
     * reads the file and stores the details of file.
     * uses a function to set the details to movie database.
     * reads the player details.
     * plays the hangman game for each player.
     * after all players are done playing leaderBoard is called
     * to dislpay positions of each player based on score.
     * @param args .
     */
    public static void main(final String[] args) {
        System.out.println(" enter the number of players ");
        int numberOfPlayers = 2 + 2;
        Scanner sc = new Scanner(System.in);
        try {
            if (sc.hasNext()) {
                numberOfPlayers = sc.nextInt();
            }
        } catch (InputMismatchException is) {
            System.out.println("wrong input...default number of players is 4 ");
        }
        try {
            System.out.println(" number of players " + numberOfPlayers);
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