import java.lang.*;
import java.util.*;
import java.io.*;

public class Hangman{
    public static void main(String[] args) throws Exception {
        File file = new File("movies.txt");
        Scanner scan = new Scanner(file);

        String str = "" ;

        while(scan.hasNextLine()){
            str = str + scan.nextLine() + "]";
        }

        if (str.charAt(str.length()-1) == ']'){
            str = str.substring(0, str.length() - 2);
        }
        // System.out.println(str);
        String [] strArray = str.split("]");
        // for (int i = 0; i < strArray.length; i++){
        //     System.out.println(strArray[i]);
        // }

        String [] hardMovies = new String [7];
        int indexHard = 0;

        for (int i = 0; i < strArray.length - 2; i++){
            if(strArray[i].equals("Hard")){
                hardMovies[indexHard] = strArray[i-1];
                indexHard++;
            }
        }
        // System.out.println(strArray[strArray.length - 1]);
        // for(int i = 0; i < hardMovies.length; i++){
        //     System.out.println(hardMovies[i]);
        // }
        // System.out.println(hardMovies.length);

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

        String [] easyMovies = new String [8];
        int indexEasy = 0;

        for (int i = 0; i < strArray.length - 2; i++){
            if(strArray[i].equals("Easy")){
                easyMovies[indexEasy] = strArray[i-1];
                indexEasy++;
            }
        }

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
            if (number == "1" || number == "2" || number == "3" || number == "4"){
                break;
            }else{
                System.out.print("----------------------------\nNumber must be 1 or 2 or 3 or 4\n");
            }
        }

        // System.out.println("You Entered " + number);
    }
}