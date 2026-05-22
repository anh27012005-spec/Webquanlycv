package web.quan.ly.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cv_certificate")

public class Cv_certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;

    private String license;

    private String issued_by;

    private LocalDate issued_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cv getCv() {
        return cv;
    }

    public void setCv(Cv cv) {
        this.cv = cv;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
    }

    public LocalDate getIssued_at() {
        return issued_at;
    }

    public void setIssued_at(LocalDate issued_at) {
        this.issued_at = issued_at;
    }
}