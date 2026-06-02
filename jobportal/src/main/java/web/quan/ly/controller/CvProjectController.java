package web.quan.ly.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.quan.ly.entity.CvProject;
import web.quan.ly.service.Cv_projectService;

import java.util.List;

@RestController
@RequestMapping("/api/cvproject")
public class CvProjectController {
    @Autowired
    private Cv_projectService cv_projectService;

    @GetMapping
    public ResponseEntity<List<CvProject>> getAllCv_project(){
        return ResponseEntity.ok(
                cv_projectService.getAll()
        );
    }
    @PostMapping
    public CvProject addCv_project(@RequestBody CvProject cv_project){
        return cv_projectService.create(cv_project);
    }



}
