import java.lang.*;
import java.util.*;

public class User {
    private String userName;
    private String [] connectionsOfTheUser;
    private int numberOfConnections;

    public User(String userName, int numberOfConnections){
        this.userName = userName;
        this.numberOfConnections = numberOfConnections;
        this.connectionsOfTheUser = new String[10];
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

    public String getNumberOfConnections() {
        return this.numberOfConnections;
    }

    public void setConnectionsOfTheUser(final String [] connectionsOfTheUser) {
        this.connectionsOfTheUser = connectionsOfTheUser;
    }

    public String getConnectionsOfTheUser() {
        return this.connectionsOfTheUser;
    }
}