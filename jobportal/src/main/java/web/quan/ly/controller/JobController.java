package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.quan.ly.entity.Job;
import web.quan.ly.service.JobService;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAll() {
        return jobService.getAll();
    }

    @GetMapping("/{id}")
    public Job getById(@PathVariable Integer id) {
        return jobService.getById(id);
    }

    @PostMapping
    public Job create(@RequestBody Job job) {
        return jobService.create(job);
    }

    @PutMapping("/{id}")
    public Job update(@PathVariable Integer id,
                      @RequestBody Job job) {

        return jobService.update(id, job);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        jobService.delete(id);
    }
}