import java.lang.*;
import java.util.*;
import java.io.*;

public class Movies{
    private String movieName;
    private String level;
    private String hint1;
    private String hint2;

    public Movies(final String movieName, final String level, final String hint1, final String hint2){
        this.movieName = movieName;
        this.level = level;
        this.hint1 = hint1;
        this.hint2 = hint2;
    }

    public void setMovieName(final String movieName){
        this.movieName = movieName;
    }

    public String getMovieName(){
        return movieName;
    }

    public void setLevel(final String level){
        this.level = level;
    }

    public String getLevel(){
        return level;
    }

    public void setHint1(final String hint1){
        this.hint1 = hint1;
    }

    public String getHint1(){
        return hint1;
    }

    public void setHint2(final String hint2){
        this.hint2 = hint2;
    }

    public String getHint2(){
        return hint2;
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

    public String[] easyMovieDetails(){
        String[] movieDetails = fileReading();
        String [] easyMovies = new String [8];
        int indexEasy = 0;

        for (int i = 0; i < movieDetails.length - 2; i++){
            if(movieDetails[i].equals("Easy")){
                easyMovies[indexEasy] = movieDetails[i-1];
                indexEasy++;
            }
        }
        return easyMovies;
    }

    public String[] mediumMovieDetails(){
        String[] movieDetails = fileReading();
        String [] easyMovies = new String [7];
        int indexMedium = 0;

        for (int i = 0; i < movieDetails.length - 2; i++){
            if(movieDetails[i].equals("Medium")){
                easyMovies[indexEasy] = movieDetails[i-1];
                indexMedium++;
            }
        }
        return mediumMovies;
    }

    public String[] hardMovieDetails(){
        String[] movieDetails = fileReading();
        String [] hardMovies = new String [7];
        int indexHard = 0;

        for (int i = 0; i < movieDetails.length - 2; i++){
            if(movieDetails[i].equals("Hard")){
                hardMovies[indexHard] = movieDetails[i-1];
                indexHard++;
            }
        }
        return hardMovies;
    }

    public String[] defaultMovieDetails(){
        String[] movieDetails = fileReading();
        String [] defaultMovies = new String [7];
        int indexDefault = 0;

        for (int i = 0; i < strArray.length - 2; i++){
            if(movieDetails[i].equals("Easy") || movieDetails[i].equals("Medium") || movieDetails[i].equals("Hard")){
                defaultMovies[indexDefault] = strArray[i-1];
                indexDefault++;
            }
        }
        return defaultMovies;
    }
}