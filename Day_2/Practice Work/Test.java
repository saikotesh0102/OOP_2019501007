import java.lang.*;

public class Test {
    public Test(){
        System.out.println("Base Show");
    }
}

public class Derived extends Test{
    public Derived(){
        System.out.println("Derived Show");
    }
}

public class One{
    public static void main(String[] args) {
        Test d = new Test();
        Derived b = new Derived();
        d.show();
        b.show(); 
    }
}