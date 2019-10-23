import java.io.*;
import java.util.*;

public final class Main {

    private Main() {

    }

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

    private static void leaderBoard(final Player[] players) {
        System.out.println(players.length);
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
        System.out.println(" LeaderBoard ");
        for (int i = 0; i < players.length; i++) {
            System.out.println(" playerName = " + players[i].getPlayerName() + " playerScore " + players[i].getPlayerScore());
        }
    }
    public static void main(final String[] args) {
        System.out.println(" enter the number of players ");
        int numberOfPlayers = 2 + 2;
        Scanner sc = new Scanner(System.in);
        try {
            if (sc.hasNext()) {
                numberOfPlayers = sc.nextInt();
            }
        } catch (InputMismatchException is) {
            System.out.println(" wrong input is given ... default number of players is 4 ");
        }
        try {
            System.out.println(" number of players " + numberOfPlayers);
            String[] fileContents = readFile("movies.txt");
            if (fileContents == null) {
                throw new NullPointerException();
            }
            final int four = 4;
            final int numberOfMovies = fileContents.length / four;
            Hangman hangman = new Hangman(numberOfMovies, numberOfPlayers);
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