package web.quan.ly.entity;
import jakarta.persistence.*;
import web.quan.ly.entity.User;
import web.quan.ly.entity.Company;
import web.quan.ly.entity.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer job_id;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private User recruiter_id;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company_id;

    private String title;

    private String position;

    private String description;

    private String requirement ;

    private String benifit;

    private Integer salary_min;
    private Integer salary_max;

    private String location;

    private String experience;
    private String employment_type;

    private Integer quantity;

    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "is_delete")
    private Boolean isDelete;

    public Integer getJob_id() {return job_id;}
    public void setJob_id(Integer job_id){this.job_id=job_id;}

    public User getRecruiter_id() {return recruiter_id;}
    public void setRecruiter_id(User recruiter_id) {this.recruiter_id=recruiter_id;}

    public Company getCompany_id() {return company_id;}
    public void setCompany_id(Company company_id) {this.company_id=company_id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title=title;}

    public String getPosition() {return position;}
    public void setPosition(String position) {this.position=position;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description=description;}

    public String getRequirement() {return requirement;}
    public void setRequirement(String requirement) {this.requirement=requirement;}

    public String getBenifit() {return benifit;}
    public void setBenifit(String benifit) {this.benifit=benifit;}

    public Integer getSalary_min() {return salary_min;}
    public void setSalary_min(Integer salary_min) {this.salary_min=salary_min;}

    public Integer getSalary_max() {return salary_max;}
    public void setSalary_max(Integer salary_max) {this.salary_max=salary_max;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location=location;}

    public String getExperience() {return experience;}
    public void setExperience(String experience) {this.experience=experience;}

    public String getEmployment_type() {return employment_type;}
    public void setEmployment_type(String employment_type) {this.employment_type=employment_type;}

    public Integer getQuantity() {return quantity;}
    public void setQuantity(Integer quantity) {this.quantity=quantity;}

    public LocalDate getDeadline() {return deadline;}
    public void setDeadline(LocalDate deadline) {this.deadline=deadline;}

    public Status getStatus() {return status;}
    public void setStatus(Status status) {this.status=status;}

    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt=createdAt;}

    public Boolean getIsDelete() {return isDelete;}
    public void setIsDelete(Boolean isDelete) {this.isDelete=isDelete;}








}
