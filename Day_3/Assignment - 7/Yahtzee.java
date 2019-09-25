public class Yahtzee {

    public static int rollDice() {
        double randomNumber = Math.random();
        randomNumber = (randomNumber * 6) + 1 ;
        int randomInt = (int) randomNumber ;
        return randomInt ;
    }
    
    public static int keepRolling() {
        int count = 1 ;
        int dice1 = rollDice() ;
        int dice2 = rollDice() ;
        int dice3 = rollDice() ;
        int dice4 = rollDice() ;
        int dice5 = rollDice() ;
           
        while(!(dice1 == dice2 && dice2 == dice3 && dice3 == dice4 && dice4 == dice5)){
            dice1 = rollDice() ;
            dice2 = rollDice() ;
            dice3 = rollDice() ;
            dice4 = rollDice() ;
            dice5 = rollDice() ; 
            count = count + 1 ;
        }
        return count ;
    }

    public static void main(String[] args) {
        System.out.println(keepRolling()) ;
    }
    
}