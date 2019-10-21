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
}