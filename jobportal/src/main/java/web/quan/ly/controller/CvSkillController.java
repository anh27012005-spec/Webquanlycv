package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.quan.ly.entity.CvSkill;
import web.quan.ly.service.CvSkillService;

import java.util.List;

@RestController
@RequestMapping("/cvskill")
public class CvSkillController {

    @Autowired
    private CvSkillService cvSkillService;

    @GetMapping
    public List<CvSkill> getAll() {
        return cvSkillService.getAll();
    }

    @GetMapping("/{id}")
    public CvSkill getById(@PathVariable Integer id) {
        return cvSkillService.getById(id);
    }

    @PostMapping
    public CvSkill create(@RequestBody CvSkill cvSkill) {
        return cvSkillService.create(cvSkill);
    }

    @PutMapping("/{id}")
    public CvSkill save(
            @PathVariable Integer id,
            @RequestBody CvSkill cvSkill) {
        return cvSkillService.save(id, cvSkill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cvSkillService.delete(id);
    }
}