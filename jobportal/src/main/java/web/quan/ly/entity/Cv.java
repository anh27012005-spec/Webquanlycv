package web.quan.ly.entity;

import jakarta.persistence.*;
import web.quan.ly.entity.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cv")

public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cv_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String fullname;

    private String email;

    private String sdt;

    private


}
