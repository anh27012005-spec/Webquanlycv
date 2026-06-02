package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.quan.ly.entity.CvEducation;
import web.quan.ly.service.CvEducationService;

import java.util.List;

@RestController
@RequestMapping("/api/cveducation")
public class CvEducationController {

    @Autowired
    private CvEducationService cv_educationService;

    @GetMapping
    public ResponseEntity<List<CvEducation>> getAllCv_education() {

        return ResponseEntity.ok(
                cv_educationService.getAll()
        );
    }
    @PostMapping
    public CvEducation addCv_education(@RequestBody CvEducation cv_education) {
        return cv_educationService.create(cv_education);
    }

}