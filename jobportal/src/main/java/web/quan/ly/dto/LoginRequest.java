package web.quan.ly.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Username khong duoc de trong")
    private String username;

    @NotBlank(message = "Mat khau khong duoc de trong")
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

