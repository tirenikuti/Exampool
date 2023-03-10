package comp3350.exampool.objects;
/**
 * Summary: User Object class, used to interact with the DB and assign files and changes to a specific user
 * Parameters: One constructor takes: Int userId, String accountType and String userName
 * Returns: Three getters that return the private and final values the class holds.
 * Description: Basic User object class implementation, UserId is final as it will be used as a primary key
 * and therefore doesn't have a setter for use after the construction.
 */
public class User {

    //User Object Variables
    final int userID;
    private String accountType;
    private String userName;

    /**
     * Constructor for User Object
     * @param userID Type: Int Primary key
     * @param accountType Type: String
     * @param userName Type: String
     */
    public User(int userID, String accountType, String userName) {
        this.userID = userID;
        this.accountType = accountType;
        this.userName = userName;
    }

    /**
     * Getter for User ID
     * @return userID Type: Int
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Getter for account type
     * @return accountType Type: String
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Setter for account Type
     * @param accountType Type: String
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * Getter for userName
     * @return userName Type: String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for UserName
     * @param userName Type: String
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}

