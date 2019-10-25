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