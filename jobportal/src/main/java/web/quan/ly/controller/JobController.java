package web.quan.ly.controller;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

import web.quan.ly.entity.Job;
import web.quan.ly.dto.JobRequest;
import web.quan.ly.service.JobService;
@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    @PreAuthorize("hasAnyRole('CANDIDATE','RECRUITER')")
    public List<Job> getAll() {
        return jobService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('CANDIDATE','RECRUITER')")
    public Job getById(@PathVariable Integer id) {
        return jobService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('RECRUITER')")
    public Job create(@Valid @RequestBody JobRequest request) {
        return jobService.create(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('RECRUITER')")
    public Job update(@PathVariable Integer id,
                      @Valid @RequestBody JobRequest request) {
        return jobService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('RECRUITER')")
    public void delete(@PathVariable Integer id) {
        jobService.delete(id);
    }
}