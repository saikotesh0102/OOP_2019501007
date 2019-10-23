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

    public Movies[] fileReading() throws Exception{
        File file = new File("movies.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNextLine()){
            String str = scan.nextLine();
            if(! str.equals(" ")){
                Movies.addMovie(new Movies(str, scan.nextLine(), scan.nextLine(), scan.nextLine()));
            }
        }
        scan.close(); 
        return movieDetails;
    }

    public Movies easyMovieDetails(){
        Movies[] movieDetails = fileReading();
        Movies [] easyMovies = new Movies [8];
        int indexEasy = 0;

        for (int i = 0; i < movieDetails.length; i++){
            if(movieDetails[i].getLevel().equals("Easy")){
                easyMovies[indexEasy++] = movieDetails[i];
            }
        }

        double randomNumber = Math.random();
        randomNumber = (randomNumber * easyMovies.length) + 1;
        int randomInt = (int) randomNumber;

        return easyMovies[randomInt];
    }

    public Movies mediumMovieDetails(){
        Movies[] movieDetails = fileReading();
        Movies [] mediumMovies = new Movies [7];
        int indexMedium = 0;

        for (int i = 0; i < movieDetails.length; i++){
            if(movieDetails[i].getLevel().equals("Medium")){
                mediumMovies[indexMedium++] = movieDetails[i];
            }
        }

        double randomNumber = Math.random();
        randomNumber = (randomNumber * mediumMovies.length) + 1;
        int randomInt = (int) randomNumber;

        return mediumMovies[randomInt];
    }

    public Movies hardMovieDetails(){
        Movies[] movieDetails = fileReading();
        Movies [] hardMovies = new Movies [7];
        int indexHard = 0;

        for (int i = 0; i < movieDetails.length; i++){
            if(movieDetails[i].getLevel().equals("Hard")){
                hardMovies[indexHard++] = movieDetails[i];
            }
        }

        double randomNumber = Math.random();
        randomNumber = (randomNumber * hardMovies.length) + 1;
        int randomInt = (int) randomNumber;

        return hardMovies[randomInt];
    }

    public Movies defaultMovieDetails(){
        Movies[] movieDetails = fileReading();
        Movies [] defaultMovies = new Movies [22];
        int indexDefault = 0;

        for (int i = 0; i < movieDetails.length; i++){
            if(movieDetails[i].getLevel().equals("Easy") || movieDetails[i].getLevel().equals("Medium") || movieDetails[i].getLevel().equals("Hard")){
                defaultMovies[indexDefault++] = movieDetails[i];
            }
        }

        double randomNumber = Math.random();
        randomNumber = (randomNumber * defaultMovies.length) + 1;
        int randomInt = (int) randomNumber;

        return defaultMovies[randomInt];
    }

    public void level(){
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("1 for Easy\n2 for Medium\n3 for Hard\n4 for Random\nEnter Number : ");
            String number = input.next();

            if (number.equals("1")) {
                easyMovieDetails();
            }else if (number.equals("2")){
                mediumMovieDetails();
            }else if (number.equals("3")){
                hardMovieDetails();
            }else if (number.equals("4")){
                defaultMovieDetails();
            }else{
                System.out.print("----------------------------\nNumber must be 1 or 2 or 3 or 4\n");
            }
            input.close();
        }
    }
}