/**
 * This class implements all the methods of the SocialNetrorkInterface 
 * You are free to add your own behaviours to this class.
 * 
 * @author Siva Sankar
 * @author Sai Kotesh
 * 
 */

import java.util.*;

public class SocialNetwork {

    /**
     * users indicates the actual users in the network
     */
    User[] users;

    /**
     * The size indicates the numebr of users in the network
     */
    int size;

    /**
     * Initializes the default values of the social network.
     */
    public SocialNetwork() {
        // TODO
        // Your code goes here
        users = new User[1];
        size = 0;
    }

    private void reSize() {
        if (size == users.length) {
            users = Arrays.copyOf(users, users.length + 1);
        }
    }
    /**
     * This method takes the string as a parameter which is used
     * to create a network. do nothing if the string is empty.
     * 
     * @param str to be used to create a network.
     */

    private String[] increaseUserConOne(String[] cons, String str) {
        if(cons != null && str != ""){
            cons = Arrays.copyOf(cons, cons.length + 1);
            cons[cons.length - 1] = str;
            return cons;
        } else {
            String[] tempCons = new String[1];
            tempCons[0] = str;
            return tempCons;
        }
    }
    private String[] increaseUserCon(String[] cons, String str) {
        if(cons != null && str != ""){
            String[] newStr = str.split(",");
            cons = Arrays.copyOf(cons, cons.length + newStr.length);
            for (int i = cons.length, j = 0; i < cons.length + newStr.length && j < newStr.length; i++, j++) {
                cons[i] = newStr[j];
            }
            return cons;
        }
        return null;
    }
    
    public void createDataStructure(String str) {
        // TODO
        // Your code goes here
        if (str!= "") {
            String[] eachUserStrings = str.split(";");
            if(eachUserStrings.length != 0) {
                for (int i = 0; i < eachUserStrings.length; i++) {
                    String[] currentUser = eachUserStrings[i].split(" is connected to ");
                    // System.out.println(" i " + i + " size " + size + " curr User " + currentUser[0]);
                    if(currentUser.length == 2 ) {
                            boolean currentUserPresent = false;

                            for (int j = 0; j < size; j++) {
                                if(users[j].userName.equals(currentUser[0])) {
                                    currentUserPresent = true;
                                    if(users[j].userConnections == null || users[j].userConnections.length == 0) {
                                        String[] currentConnections = currentUser[1].split(",");
                                        users[j].userConnections = currentConnections;
                                    }
                                    else {
                                        users[j].userConnections = increaseUserCon(users[j].userConnections, currentUser[1]);
                                    }
                                    break;
                                }
                            }
                            if (!currentUserPresent) {
                                reSize();
                                String[] yescons =  currentUser[1].split(",");
                                User tempNewUser = new User(currentUser[0],yescons);
                                users[size] = tempNewUser;
                                size = size + 1;

                            }
                            // System.out.println("curr " +currentUser[0] + " pre? " +currentUserPresent);
                            String[] currentUserConnections = currentUser[1].split(",");
                            // System.out.println("cur con  " +currentUserConnectionsString);

                            for (int k = 0; k < currentUserConnections.length; k++) {
                                boolean conUserPresent = false;

                                for (int m = 0; m < size; m++) {
                                    if(currentUserConnections[k].equals(users[m].userName)) {
                                        conUserPresent = true;
                                        // reSize();
                                        // User tempCurrentUserConnections = new User(currentUserConnections[k], null);
                                        // users[size] = tempCurrentUserConnections;
                                        break;
                                    }
                                }
                                if(!conUserPresent) {
                                    reSize();
                                    User tempNewUser = new User(currentUserConnections[k],null);
                                    users[size] = tempNewUser;
                                    size = size + 1;
                                }
                            }
                    }
                    else {
                        reSize();
                        User tempNewUser = new User(currentUser[0], null);
                        users[size] = tempNewUser;
                        size = size + 1;
                    }

                    // for (int p = 0 ; p < size ; p ++ ) {
                    //     System.out.print(users[p].userName + "   " + getCurrCon(users[p]));
                    //     System.out.println();
                    // }
                    // System.out.println("----------------------------");

                    // System.out.println(users[i].userName + "   " + users[i].userConnections.length);
                }

            }
        }
        // for (int i = 0 ; i < size ; i ++ ) {
        //     System.out.println(users[i].userName + "   " +  getCurrCon(users[i]));
        // }
        return;
    }

    private String getCurrCon(User user) {
        
        String con = "";
        if(user.userConnections == null) {
            return "";
        }

        for(int i = 0; i<user.userConnections.length;i++){
            con = con + user.userConnections[i]+", ";
        }
        con = con.substring(0, con.length()-2);
        return con;
    }

    private boolean searchUser(User user) {
        for (int i = 0; i < size; i++) {
            if (user.equals(users[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Please don't modify the follwoing code.
     * This method returns the User based on the userName.
     * 
     * @param userName the string to be used to search for the user.
     * @return the User object based on the userName. 
     * Returns null otherwise
     */
    public User getUser(String userName1) {
        for (int i = 0; i < size; i++) {
            if (userName1.equals(this.users[i].userName)) {
                return users[i];
            }
        }
        return null;
    }

    /**
     * This method adds a new User (object) that is passed as 
     * argument to the social network if the user is not currently 
     * on the social network.
     * @param userA to be added to the social network.
     */
    public void addUser(User userA) {
        // TODO
        // Your code goes here
        
        if (userA != null && userA.userName != "") {
            boolean alreadyPresent = true;
            int userIndex = -1;
            for (int i = 0; i < size; i++) {
                if(this.users[i].userName.equals(userA.userName)){
                    alreadyPresent = false;
                    userIndex = i;
                    break;
                }
            }
            if(alreadyPresent) {
                reSize();
                this.users[size] = userA;
                size = size + 1;
            }
            // else {
            //     users[userIndex].userConnections = userA.userConnections;
            // }
        }
        return;
    }

    /**
     * This method takes two users (objects) as arguments and 
     * connects them on the network. userA and userB are 
     * the users that are passed as parameters to this function, 
     * then add userB to userA’s connections
     * 
     * Note: Both userA and userB should be there on the network.
     * if anyone of them are not on the network, then do nothing.
     * 
     * @param userA the userB is to be added to userA connections
     * @param userB to be added to userA connections
     */
    public void addConnection(User userA, User userB) {
        // TODO
        // Your code goes here

        if (userA != null && userB != null) {
            boolean userAPresent = false;
            boolean userBPresent = false;
            int userAIndex = -1;
            int userBIndex = -1;

            for (int i = 0; i < size; i++) {
                if(userA.userName.equals(this.users[i].userName)) {
                    userAPresent = true;
                    userAIndex = i;
                }
                if(userA.userName.equals(this.users[i].userName)) {
                    userBPresent = true;
                    userBIndex = i;
                }
            }

            if(userAPresent && userBPresent) {
                users[userAIndex].userConnections = increaseUserConOne(userA.userConnections, userB.userName);
            }
        }
    }

    /**
     * This method takes a user object as an argument that returns the 
     * connections of this user. Return null if the user is not in 
     * the network.
     * 
     * @param userA the user object used to return the 
     * connections of this user.
     * 
     * @return the list of connections of userA. otherwise return null
     */
    public User[] getConnections(User userA) {
        // TODO
        // Your code goes here
        if (userA != null && userA.userName != "" && userA.userName != null && userA.userConnections != null){
            String[] userAConnectionsString = userA.userConnections;

            for (int i = 0; i < userAConnectionsString.length; i++) {
                userAConnectionsString[i] = userAConnectionsString[i].replaceAll(" ", "");
            }

            User[] userAConnections = new User[userAConnectionsString.length];

            for (int j = 0; j < userAConnectionsString.length; j++) {
                userAConnections[j] = getUser(userAConnectionsString[j]);
            }

            return userAConnections;
        }
        return null;
    }

    /**
     * This method returns the common connections of userA and userB.
     * Note: both userA and userB should be on the network. if anyone 
     * of them is not in the network, then return null
     * 
     * @param userA the first user
     * @param userB the second user
     * 
     * @return the common connections of both userA and userB if they 
     * both are in the network, otherwise return null
     */
    public User[] getCommonConnections(User userA, User userB) {
        // TODO
        // Your code goes here
        if (userA != null && userB != null && userA.userName != "" && userA.userName != null
                 && userB.userName != "" && userB.userName != null && userA.userConnections != null && userB.userConnections != null) {

            boolean userAPresent = false;
            boolean userBPresent = false;
            int userAIndex = -1;
            int userBIndex = -1;

            for (int i = 0; i < size; i++) {
                if(userA.userName.equals(users[i].userName)) {
                    userAPresent = true;
                    userAIndex = i;
                }
            }

            for (int i = 0; i < size; i++) {
                if(userA.userName.equals(users[i].userName)) {
                    userBPresent = true;
                    userBIndex = i;
                }
            }

            if(userAPresent && userBPresent) {
                String[] userAConnections = userA.userConnections;
                String[] userBConnections = userB.userConnections;

                String commonConnections = "";

                    for (int i = 0; i < userAConnections.length; i++) {
                        for (int j= 0; j< userBConnections.length; j++) {
                            if(userAConnections[i].equals(userBConnections[j])) {
                                commonConnections = commonConnections + userAConnections[i] + ",";
                                break;
                            }
                        }
                    }

                    String[] commonConnectionsString = commonConnections.split(",");

                    User[] commonConnectionsObj = new User[commonConnectionsString.length];
                    for (int i = 0; i < commonConnectionsString.length; i++) {
                        commonConnectionsObj[i] = getUser(commonConnectionsString[i]);
                    }
                return commonConnectionsObj;
                }
        }
        return null;
    }

    /**
     * This reutrns the String version of the social network.
     * 
     * @return the String version of the network, return an empty string
     * if there are no users in the network.
     */

    public String toString() {
        if (size == 0) {
            return "";
        }

        String complete ="";

        for (int i = 0 ; i < size ; i ++ ) {
            String currCons = getCurrCon(users[i]);
            if(currCons == "") {
                complete = complete + users[i].userName + " : "  + "\n";
            } 
            else {
                complete = complete + users[i].userName + " : " + "[" + currCons + "]" + "\n";
            }
        }
        complete = complete.substring(0, complete.length()-1);
        
        // System.out.println(complete);
   
        return complete;
    } 

}