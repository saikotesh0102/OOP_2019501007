public class Player {
    
    private String playerName;
    private int numberOfChances;
    private boolean gameWon = false;
    private int playerPosition;

    public Player(final String playerName, final int playerPosition,final int numberOfChances, final boolean gameWon) {
        this.playerName = playerName;
        this.numberOfChances = numberOfChances;
        this.gameWon = gameWon;
        this.playerPosition = playerPosition;
    }

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