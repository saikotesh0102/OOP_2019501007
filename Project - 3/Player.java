public class Player {
    /**
     * Fields for the Class Player
     */
    private String playerName;
    private int numberOfChances;
    private boolean gameWon = false;
    private int playerPosition;
    /**
     * Constructor for the class Player
     * @param playerName
     * @param playerPosition
     * @param numberOfChances
     * @param gameWon
     */
    public Player(final String playerName, final int playerPosition,final int numberOfChances, final boolean gameWon) {
        this.playerName = playerName;
        this.numberOfChances = numberOfChances;
        this.gameWon = gameWon;
        this.playerPosition = playerPosition;
    }
    /**
     * Setters and Getters
     * @return
     */
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(final String playerName) {
        this.playerName = playerName;
    }

    public int getNumberOfChances() {
        return numberOfChances;
    }

    public void setNumberOfChances(final int numberOfChances) {
        this.numberOfChances = numberOfChances;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(final boolean gameWon) {
        this.gameWon = gameWon;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(final int playerPosition) {
        this.playerPosition = playerPosition;
    }
}