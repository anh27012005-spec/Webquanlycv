package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.quan.ly.entity.Cv;
import web.quan.ly.entity.Cv_education;
import web.quan.ly.service.Cv_educationService;

import java.util.List;

@RestController
@RequestMapping("/api/cveducation")
public class Cv_educationController {

    @Autowired
    private Cv_educationService cv_educationService;

    @GetMapping
    public ResponseEntity<List<Cv_education>> getAllCv_education() {

        return ResponseEntity.ok(
                cv_educationService.getAll()
        );
    }
    @PostMapping
    public Cv_education addCv_education(@RequestBody Cv_education cv_education) {
        return cv_educationService.create(cv_education);
    }

}