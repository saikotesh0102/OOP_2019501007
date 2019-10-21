import java.lang.*;
import java.util.*;
import java.io.*;

public class Hangman{

    public static void main(String[] args) throws Exception {

        String [] mediumMovies = new String [7];
        int indexMedium = 0;

        for (int i = 0; i < strArray.length - 2; i++){
            if(strArray[i].equals("Medium")){
                mediumMovies[indexMedium] = strArray[i-1];
                indexMedium++;
            }
        }

        // for(int i = 0; i < mediumMovies.length; i++){
        //     System.out.println(mediumMovies[i]);
        // }

        

        // for(int i = 0; i < easyMovies.length; i++){
        //     System.out.println(easyMovies[i]);
        // }

        String [] defaultMovies = new String [22];
        int indexDefault = 0;

        for (int i = 0; i < strArray.length - 2; i++){
            if(strArray[i].equals("Easy") || strArray[i].equals("Medium") || strArray[i].equals("Hard")){
                defaultMovies[indexDefault] = strArray[i-1];
                indexDefault++;
            }
        }

        // for(int i = 0; i < defaultMovies.length; i++){
        //     System.out.println(defaultMovies[i]);
        // }
        // System.out.println(defaultMovies.length);

        while(true){
            Scanner input = new Scanner(System.in);
            System.out.print("1 for Easy\n2 for Medium\n3 for Hard\n4 for Random\nEnter Number : ");
            String number = input.next();
            // if (number != "1" || number != "2" || number != "3" || number != "4"){
            if (number.equals("1") || number.equals("2") || number.equals("3") || number.equals("4")){
                break;
            }else{
                System.out.print("----------------------------\nNumber must be 1 or 2 or 3 or 4\n");
            }
            input.close();
        }
    }
}