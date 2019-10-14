import java.util.*;
/**
 * @author Sai Kotesh
 */
public class User {

    String userName;
    String[] userConnections;

    public User(String userName, String[] userConnections) {
        this.userName = userName;
        this.userConnections = userConnections;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] getUserConnections() {
        return userConnections;
    }

    public void setUserConnections(String[] userConnections) {
        this.userConnections = userConnections;
    }
}