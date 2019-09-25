import java.lang.*;
public class Test {
    public static void main(String[] args) {
       int a = 10 ;
        int b = a++ ;
        System.out.println(a + " " + b) ;
        a = b-- ;
        System.out.println(a + " " + b) ;
        a = b++ ;
        System.out.println(a + " " + b) ;
        b = b-- ;
        a = a++ ;
        System.out.println(a + " " + b) ;
    }
}