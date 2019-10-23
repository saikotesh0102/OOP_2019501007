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
        this.hints = hints;
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
}