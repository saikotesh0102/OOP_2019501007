public class Easy{

    public int randomInteger(){
        double randomNumber = Math.random();
        //Takes random values in the range of 0 to 1(exclusive)
        randomNumber = (randomNumber * easyMovies.length) + 1 ;
        //To increase the range to 1 to Easy Movies array length(exclusive)
        int randomInt = (int) randomNumber ;
        //Gives the Integers in between 1 to Easy Movies array length(exclusive)
        return randomInt ;
    }
}