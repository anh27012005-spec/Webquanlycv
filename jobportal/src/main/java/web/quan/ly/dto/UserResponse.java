package web.quan.ly.dto;

import web.quan.ly.entity.Role;
import web.quan.ly.entity.User;
import web.quan.ly.entity.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserResponse {

    private Integer id;
    private String username;
    private String name;
    private String email;
    private String sdt;
    private String gender;
    private LocalDate birthday;
    private Role role;
    private Status status;
    private LocalDateTime createdAt;

    public UserResponse() {
    }

    public UserResponse(
            Integer id,
            String username,
            String name,
            String email,
            String sdt,
            String gender,
            LocalDate birthday,
            Role role,
            Status status,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.sdt = sdt;
        this.gender = gender;
        this.birthday = birthday;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getEmail(),
                user.getSdt(),
                user.getGender(),
                user.getBirthday(),
                user.getRole(),
                user.getStatus(),
                user.getCreatedAt()
        );
    }
}