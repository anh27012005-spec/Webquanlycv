package web.quan.ly.dto;

import jakarta.validation.constraints.NotBlank;


public class CvRequest {

    @NotBlank(message = "tieu de khong duoc bo trong")
    private String title;

    @NotBlank(message = "Ten khong duoc de trong")
    private String fullname;

    @NotBlank(message = "email khong duoc de trong")
    private String email;

    @NotBlank(message = "phone khong duoc de trong")
    private String phone;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}