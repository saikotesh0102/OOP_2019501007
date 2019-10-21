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

    public String toString(){
        return "User Name = " + this.name + "Score = " + this.score;
    }
}