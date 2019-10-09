import java.lang.*;

public class Test {
    final public void show(){
        System.out.println("Base Show");
    }
}

public class Derived extends Test{
    public void show(){
        System.out.println("Derived Show");
    }
}

public class One{
    public static void main(String[] args) {
        Derived b = new Derived();
        b.show(); 
    }
}