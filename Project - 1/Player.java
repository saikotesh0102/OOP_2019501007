public class Player {
    
    private String playerName;
    private int playerScore;

    Player(final String playerName, final int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
    }
   
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(final String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(final int playerScore) {
        this.playerScore = playerScore;
    }
}