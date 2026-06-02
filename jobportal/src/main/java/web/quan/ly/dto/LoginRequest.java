package web.quan.ly.dto;

public class LoginRequest {

    private String username;
    private String passHash;

    public String getUsername(){
        return  username;
    }

    public void setUsername(String username) {
        this.username= username;
    }

    public String getPassHash(){
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}

