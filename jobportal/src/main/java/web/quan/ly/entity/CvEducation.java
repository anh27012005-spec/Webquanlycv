package web.quan.ly.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "cv_education")

public class CvEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;

    private String school_name;

    private String major;

    private LocalDate  start_date;
    private LocalDate end_date;

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
    public String getSchool_name() {
        return school_name;
    }
    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public LocalDate getStart_date() {
        return start_date;
    }
    public  void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }
    public LocalDate getEnd_date() {
        return  end_date;
    }
    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }



}
