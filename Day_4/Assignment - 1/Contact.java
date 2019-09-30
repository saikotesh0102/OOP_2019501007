/**
 * This class discusses about the Contact Object.
 * The attributes of the contact object
 * are as follows.
 * name : Name of the person / friend.
 * email : mail id of the person / friend.
 * phoneNumber : Phone Number of the person / friend.
 * 
 * @author Siva Sankar
 */

//  Your code goes here... For Contact class
public class Contact{
    /**
     * This Class is used to declare the fields
     * The Fields are Name, Email and Phone Number
     */
    private String name, email;
    private String phoneNumber;

    public Contact(final String name, final String email, final String phoneNumber) {
        //This method acts as a Constructor 
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setName(final String name) {
        //This acts as a settser to set the name of the person
        this.name = name;
    }

    public String getName() {
        //This acts as a getter to get the name of the person
        return this.name;
    }

    public void setEmail(final String email ) {
        //This acts as a setter to set the Email of the person
        this.email = email;
    }

    public String getEmail() {
        //This acts as a getter to get the Email of the person
        return this.email;
    }

    public void setPhoneNumber(final String phoneNumber) {
        //This acts as a setter to set the Phone Number of the person
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() { 
        //This acts as a getter to get the Phone Number of the person
        return this.phoneNumber;
    }

    public String toString() {
        /** ToString Method id used to print the way as user defined
         * 
         */
        String output = "{ Name = " + this.name + "," + " Email = "
        + this.email + "," + " Phone Number = " + this.phoneNumber + " }";
        return output;
    }
}
