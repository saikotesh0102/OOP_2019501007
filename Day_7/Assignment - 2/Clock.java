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
    public Clock(int h, int m) {

    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.

    public Clock(String s) {

    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {

    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        
    }

    private void check() {
        
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        
    }

    // Adds Δ min to the time on this clock.
    public void toc(int delta) {
        
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock = new Clock("13:01");
        clock.toc(660);
        System.out.println(clock);
    }
}