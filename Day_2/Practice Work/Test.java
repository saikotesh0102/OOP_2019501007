import java.lang.*;

public class Test {
//     public Test(){
//         System.out.println("Base Show");
//     }
// }

// public class Derived extends Test{
//     public Derived(){
//         System.out.println("Derived Show");
//     }
// }

// public class One{
//     public static void main(String[] args) {
//         Test d = new Test();
//         Derived b = new Derived();
//         d.show();
//         b.show(); 
//     }
    int a,b;
    // public float add(int a, float b){
    //     return a+b;
    // }

    public float add(float a, float b){
        return a+b;
    }

    public static void main(String[] args) {
        Test T = new Test();
        // System.out.println(T.add(10,11.5f));
        System.out.println(T.add(10,6.5f));
    }
}