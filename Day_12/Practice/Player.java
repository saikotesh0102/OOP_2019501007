public class Player {
    
    private String playerName;
    private int playerScore;

    Player(final String playerName1, final int playerScore1) {
        this.playerName = playerName1;
        this.playerScore = playerScore1;
    }
   
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(final String playerName1) {
        this.playerName = playerName1;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(final int playerScore1) {
        this.playerScore = playerScore1;
    }
}