package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.quan.ly.entity.Job;
import web.quan.ly.service.JobService;
import jakarta.validation.Valid;
import web.quan.ly.dto.JobRequest;

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
    public Job create(@Valid @RequestBody JobRequest request) {
        return jobService.create(request);
    }

    @PutMapping("/{id}")
    public Job update(@PathVariable Integer id,
                      @Valid @RequestBody JobRequest request) {

        return jobService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        jobService.delete(id);
    }
}