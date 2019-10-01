/**
 * Clock data type. Write a data type Clock.java that
 * represents time on a 24-hour clock, such as 00:00, 13:30, or
 * 23:59. Time is measured in hours (00–23) and minutes (00–59). 
 * To do so, implement the following public API:
 * 
 * @author Siva Sankar
 */

public class Clock {
    // Creates a clock whose initial time is h hrs and m min.
    /**
     * The parameterised constructor will instatiates the object with the values of
     * the parameters h and m to the respective hrs nad min.
     * @param h
     * @param m
     */
    int h;
    int m;
    public Clock(int h, int m) {
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.

    public Clock(String s) {
        this.h = Integer.parseInt(s.substring(0,2));
        this.m = Integer.parseInt(s.substring(3,5));
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String str = "";
        System.out.println(h);
        if(h < 10){
            str = str + "0" + h;
        }else{
            str = str + h;
        }   
        str = str + ":";
        System.out.println(m);
        if(m < 10){
            str = str + "0" + m;
        }else{
            str = str + m;
        }
        return str;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if(this.h <= that.h && this.m < that.m){
            return true;
        }
        return false; 
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if(h < 23 && m < 59){
            m = m + 1;
        }else if (h < 23 && m == 59) {
            h = h+1;
            m = 0;
        }else if(h == 23 && m == 59) {
            h = 0;
            m = 0;
        }
    }

    // Adds Δ min to the time on this clock.
    public void toc(int delta) {
        int num_hr = 0;
        int minutes = 0;
        if (delta > 60) {
            num_hr = delta/60;
            minutes = delta - (num_hr*60);
            h = h + num_hr;
            if (h >= 24) {
                h = h % 24;
            }
            for(int i = 0; i < minutes; i++){
                this.tic();
            }
        }else {
            for(int i = 0; i < delta; i++){
                this.tic();
            }
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock = new Clock("13:01");
        clock.toc(660);
        System.out.println(clock);
    }
}