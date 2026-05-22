package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.quan.ly.entity.Cv;
import web.quan.ly.service.CvService;

import java.util.List;

@RestController
@RequestMapping("/api/cv")
public class CvController {

    @Autowired
    private CvService CvService;

    @GetMapping
    public List<Cv> getAll() {
        return CvService.getAll();
    }

    @GetMapping("/{id}")
    public Cv getById(@PathVariable Integer id) {
        return CvService.getById(id);
    }

    @PostMapping
    public Cv addCv(@RequestBody Cv cv) {
        return CvService.save(cv);
    }
}