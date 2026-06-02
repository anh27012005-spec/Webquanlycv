package web.quan.ly.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cv_skill")

public class CvSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;

    private String skill_name;

    private String level;

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
    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }
    public String getLevel() {
        return  level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
