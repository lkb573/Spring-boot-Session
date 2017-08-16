package kr.re.kitri.domain;


public class Memeber {

    private String userId;
    private String userName;

    @Override
    public String toString() {
        return "Memeber{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public Memeber() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Memeber(String userId, String userName) {

        this.userId = userId;
        this.userName = userName;
    }
}