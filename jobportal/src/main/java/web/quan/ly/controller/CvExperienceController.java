package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.quan.ly.entity.CvExperience;
import web.quan.ly.service.CvExperienceService;

import java.util.List;

@RestController
@RequestMapping("/api/cvexperience")
public class CvExperienceController {

    @Autowired
    private CvExperienceService cvExperienceService;

    @GetMapping
    public List<CvExperience> getAll() {
        return cvExperienceService.getAll();
    }

    @GetMapping("/{id}")
    public CvExperience getById(@PathVariable Integer id) {
        return cvExperienceService.getById(id);
    }

    @PostMapping
    public CvExperience create(@RequestBody CvExperience cvExperience) {
        return cvExperienceService.save(cvExperience);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cvExperienceService.delete(id);
    }
}