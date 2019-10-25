/**
 * This is a user defined class that throws an Exception
 *  to the user when the user created an object to this class.
 * 
 * @author Siva Sankar
 */

public class InvalidIndexException extends Exception {

    public static final long serialVersionUID = 1L;

    /**
     * This is a constructor used to construct the 
     * InvalidIndexException. This calls the super class constructor
     * which is an Exception used to set the message (String variable)
     * in the super class.
     * 
     * @param message to be set to super class's message.
     */
    public InvalidIndexException(String message) {
        super(message);
    }
}