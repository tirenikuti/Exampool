package comp3350.exampool.objects;

public class User {
    final int userID;
    private String accountType;
    private String userName;

    public User(int userID, String accountType, String userName) {
        this.userID = userID;
        this.accountType = accountType;
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

