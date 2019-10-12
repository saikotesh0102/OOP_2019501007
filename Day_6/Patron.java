//import sun.awt.ModalExclude;
import java.lang.*;
import java.util.*;

public class Patron{
    private String name;
    private String mobileNumber;

    public Patron(final String name, final String mobileNumber){
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public void setName(final String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMobileNumber(final String mobileNumber){
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String toString() {
        return "Patron [Mobile Number= " + mobileNumber + ", Name = " + name + "]";
    }
}