package web.quan.ly.entity;

import jakarta.persistence.*;
import web.quan.ly.entity.enums.Gender;
import web.quan.ly.entity.Cv_certificate;
import web.quan.ly.entity.Cv_education;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "cv")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cv")
    private List<Cv_certificate> cvCertificates;

    @OneToMany(mappedBy = "cv")
    private List<Cv_education> cvEducations;

    @OneToMany(mappedBy = "cv")
    private List<Cv_experience> cvExperiences;


    private String title;

    private String fullName;

    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthday;

    private String address;

    private String position;

    private String careerObjective;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.isDelete = false;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCareerObjective() {
        return careerObjective;
    }

    public void setCareerObjective(String careerObjective) {
        this.careerObjective = careerObjective;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public List<Cv_certificate> getCvCertificates() {
        return cvCertificates;
    }

    public void setCvCertificates(List<Cv_certificate> cvCertificates) {
        this.cvCertificates = cvCertificates;
    }

    public List<Cv_education> getCvEducations() {
        return cvEducations;
    }

    public void setCvEducations(List<Cv_education> cvEducations) {
        this.cvEducations = cvEducations;
    }

    public List<Cv_experience> getCvExperiences() {
        return cvExperiences;
    }

    public void setCvExperiences(List<Cv_experience> cvExperiences) {
        this.cvExperiences = cvExperiences;
    }

}
