package web.quan.ly.controller;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import web.quan.ly.entity.Application;
import web.quan.ly.service.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    @PreAuthorize("hasRole('RECRUITER')")
    public List<Application> getAll() {
        return applicationService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('RECRUITER','CANDIDATE')")
    public Application getById(@PathVariable Integer id) {
        return applicationService.getById(id);
    }

    @PostMapping("/{jobId}")
    @PreAuthorize("hasRole('CANDIDATE')")
    public Application apply(@PathVariable Integer jobId,
                             Authentication auth) {

        String username = auth.getName();

        return applicationService.apply(jobId, username);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('RECRUITER')")
    public Application updateStatus(@PathVariable Integer id,
                                    @RequestBody Application application) {

        return applicationService.update(id, application);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Integer id) {
        applicationService.delete(id);
    }
}