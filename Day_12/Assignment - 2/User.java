import java.lang.*;
import java.util.*;
import java.io.*;

public class User{
    private String name;
    private int score;
    
    public User(final String name, final int score){
        this.name = name;
        this.score = score;
    }

    public void setUserName(final String name){
        this.name = name;
    }

    public String getUserName(){
        return name;
    }

    public void setUserScore(final int score){
        this.score = score;
    }

    public String getUserScore(){
        return score;
    }

    public String[] fileReading() throws Exception{
        File file = new File("movies.txt");
        Scanner scan = new Scanner(file);

        String str = "" ;

        while(scan.hasNextLine()){
            str = str + scan.nextLine() + "]";
        }
        scan.close();

        String [] strArray = str.split("]");
        return strArray;
    }

    String[] movieDetails = fileReading();

    public String[] hardMovieDetails(){
        String [] hardMovies = new String [7];
        int indexHard = 0;

        for (int i = 0; i < movieDetails.length - 2; i++){
            if(strArray[i].equals("Hard")){
                hardMovies[indexHard] = movieDetails[i-1];
                indexHard++;
            }
        }
        return hardMovies;
    }

    public String[] easyMovieDetails(){
        String [] easyMovies = new String [8];
        int indexEasy = 0;

        for (int i = 0; i < movieDetails.length - 2; i++){
            if(strArray[i].equals("Easy")){
                easyMovies[indexEasy] = movieDetails[i-1];
                indexEasy++;
            }
        }
        return easyMovies;
    }

    public String[] mediumMovieDetails(){
        String [] easyMovies = new String [7];
        int indexMedium = 0;

        for (int i = 0; i < movieDetails.length - 2; i++){
            if(strArray[i].equals("Medium")){
                easyMovies[indexEasy] = movieDetails[i-1];
                indexMedium++;
            }
        }
        return mediumMovies;
    }

}