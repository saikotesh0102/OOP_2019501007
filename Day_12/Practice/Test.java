import java.lang.*;
import java.util.*;
import java.io.*;

public class Test{
    public static void main(String[] args) {
        File file = new File("movies.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNext()){
            String str = scan.nextLine();
            if(! str.equals(" ")){
                
            }
        }
        scan.close();
    }
}