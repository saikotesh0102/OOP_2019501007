public class Medium{

    public int randomInteger(){
        double randomNumber = Math.random();
        //Takes random values in the range of 0 to 1(exclusive)
        randomNumber = (randomNumber * mediumMovies.length) + 1 ;
        //To increase the range to 1 to Medium Movies array length(exclusive)
        int randomInt = (int) randomNumber ;
        //Gives the Integers in between 1 to Medium Movies array length(exclusive)
        return randomInt ;
    }
}