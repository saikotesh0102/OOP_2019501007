import java.lang.*;
import java.io.*;
import java.util.*;

public class MoviesCatalog{
    int index;
    Movies [] movieDetails;

    public MoviesCatalog(){
        movieDetails = new Movies[22];
        index = 0;
    }

    public void addMovie(Movies movie){
        movieDetails[index] = movie;
        index++;
    }

    public void fileReading() throws Exception{
        File file = new File("movies.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){
            String str = scan.nextLine();
            if(! str.equals(" ")){
                movie.add(new Movies(str, scan.nextLine(), scan.nextLine(), scan.nextLine()));
            }
        }
        scan.close();
    }

    public Movies easyMovieDetails(){
        Movies[] movieDetails = fileReading();
        Movies [] easyMovies = new Movies [8];
        int indexEasy = 0;

        for (int i = 0; i < movieDetails.length; i++){
            if(movieDetails[i].getlevel().equals("Easy")){
                easyMovies[indexEasy++] = movieDetails[i];
            }
        }

        double randomNumber = Math.random();
        randomNumber = (randomNumber * easyMovies.length) + 1;
        int randomInt = (int) randomNumber;

        return easyMovies[randomInt].getMovieName();
    }

    public Movies mediumMovieDetails(){
        Movies[] movieDetails = fileReading();
        Movies [] mediumMovies = new Movies [7];
        int indexMedium = 0;

        for (int i = 0; i < movieDetails.length; i++){
            if(movieDetails[i].getlevel().equals("Medium")){
                mediumMovies[indexMedium++] = movieDetails[i];
            }
        }

        double randomNumber = Math.random();
        randomNumber = (randomNumber * mediumMovies.length) + 1;
        int randomInt = (int) randomNumber;

        return mediumMovies[randomInt].getMovieName();
    }

    public Movies hardMovieDetails(){
        Movies[] movieDetails = fileReading();
        Movies [] hardMovies = new Movies [7];
        int indexHard = 0;

        for (int i = 0; i < movieDetails.length; i++){
            if(movieDetails[i].getlevel().equals("Hard")){
                hardMovies[indexHard++] = movieDetails[i];
            }
        }

        double randomNumber = Math.random();
        randomNumber = (randomNumber * hardMovies.length) + 1;
        int randomInt = (int) randomNumber;

        return hardMovies[randomInt].getMovieName();
    }

    public Movies defaultMovieDetails(){
        Movies[] movieDetails = fileReading();
        Movies [] defaultMovies = new Movies [22];
        int indexDefault = 0;

        for (int i = 0; i < movieDetails.length; i++){
            if(movieDetails[i].getlevel().equals("Easy") || movieDetails[i].getlevel().equals("Medium") || movieDetails[i].getlevel().equals("Hard")){
                defaultMovies[indexDefault++] = movieDetails[i];
            }
        }

        double randomNumber = Math.random();
        randomNumber = (randomNumber * defaultMovies.length) + 1;
        int randomInt = (int) randomNumber;

        return defaultMovies[randomInt].getMovieName();
    }

    public void level(){
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("1 for Easy\n2 for Medium\n3 for Hard\n4 for Random\nEnter Number : ");
            String number = input.next();

            if (number.equals("1") || number.equals("2") || number.equals("3") || number.equals("4")){
                break;
            }else{
                System.out.print("----------------------------\nNumber must be 1 or 2 or 3 or 4\n");
            }
            input.close();
        }
    }
}