import java.lang.*;
import java.util.*;
import java.io.*;

public class Hangman{
    public static void main(String[] args) throws Exception {
        File file = new File("movies.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        // Scanner scan = new Scanner(file);

        String str ;
        // while(scan.hasNextLine()){
        //     str = str + scan.nextLine() + ",";
        // }
        // System.out.println(str);
        while ((str = br.readLine()) != null){
            System.out.println(str); 
        }
    }
}