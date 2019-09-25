public class Yahtzee {

    public static int rollDice() {
        //This method is used to create a random number between 1 to 6
        double randomNumber = Math.random();
        //Takes random values in the range of 0 to 1(exclusive)
        randomNumber = (randomNumber * 6) + 1 ;
        //To increase the range to 1 to 7(exclusive)
        int randomInt = (int) randomNumber ;
        //Gives the Integers in between 1 to 7(exclusive)
        return randomInt ;
    }
    
    public static int keepRolling() {
        //This method is used to roll the dice number of times 
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