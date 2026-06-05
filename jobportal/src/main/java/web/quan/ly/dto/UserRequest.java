package web.quan.ly.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserRequest {

    @NotBlank(message = "ten khong duoc de trong")
    private String name;

    @NotBlank(message = "email khong duoc de trong")
    @Email(message = "email khong hop le")
    private String email;

    @NotBlank(message = "sdt khong duoc de trong")
    @Pattern(
            regexp = "^(03|05|07|08|09)\\d{8}$",
            message = "sdt khong hop le"
    )
    private String sdt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

}
