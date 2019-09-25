public class Yahtzee {
    public static void main(String[] args) {
        public int rollDice() {
            double randomNumber = Math.random();
            randomNumber = (randomNumber * 6) + 1 ;
            int randomInt = (int) randomNumber ;
            return randomInt ;
        }
        public int keepRolling(int dice1, int dice2, int dice3, int dice4, int dice5) {
            dice1 = rollDice() ;
            dice2 = rollDice() ;
            dice3 = rollDice() ;
            dice4 = rollDice() ;
            dice5 = rollDice() ;
            count = 1 ;
           
            while(!(dice1 == dice2 && dice2 == dice3 && dice3 == dice4 && dice4 == dice5)){
                dice1 = rollDice() ;
                dice2 = rollDice() ;
                dice3 = rollDice() ;
                dice4 = rollDice() ;
                dice5 = rollDice() ; 
                count = count + 1 ;
            }
        }
        return count ;
        keepRolling() ;  
    }
}