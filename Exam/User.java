import java.lang.*;
import java.util.*;

public class User {
    private String userName;
    private User [] connectionsOfTheUser;
    private int numberOfConnections;

    // public User(){
    //     this.userName = userName;
    //     this.numberOfConnections = numberOfConnections;
    // }

    public User(String userName, String [] connectionsOfTheUser){
        this.userName = userName;
        this.connectionsOfTheUser = new User[10];
    }

    // public User(String userName, String [] connectionsOfTheUser){
    //     this.userName = userName;
    //     this.connectionsOfTheUser = new String[10];
    // }

    public void add(String str){
        if(numberOfConnections == connectionsOfTheUser.length){
            connectionsOfTheUser = Arrays.copyOf(connectionsOfTheUser, connectionsOfTheUser.length + 10);
        }
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setNumberOfConnections(final int numberOfConnections) {
        this.numberOfConnections = numberOfConnections;
    }

    public int getNumberOfConnections() {
        return this.numberOfConnections;
    }

    public void setConnectionsOfTheUser(final User [] connectionsOfTheUser) {
        this.connectionsOfTheUser = connectionsOfTheUser;
    }

    public User[] getConnectionsOfTheUser() {
        return this.connectionsOfTheUser;
    }

    // public String toString(){
    //     if(connectionsOfTheUser != null){
    //         String str = "[";
    //         for(int i = 0; i < connectionsOfTheUser.length; i++){
    //             str = str + connectionsOfTheUser[i] ;
    //             if(i != connectionsOfTheUser.length-1){
    //                 str += ", ";
    //             }
    
    //         }
    //         str += "]";
    //         return userName + " : "+ str;
    //     }else{
    //         return userName + " : "+ "";
    //     }
       
    // }
}