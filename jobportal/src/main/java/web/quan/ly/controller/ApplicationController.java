package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.quan.ly.entity.Application;
import web.quan.ly.service.ApplicationService;

import java.util.List;

@RestController
@RequestMapping("api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<Application> getAll() {
        return applicationService.getAll();
    }

    @GetMapping("/{id}")
    public Application getById(@PathVariable Integer id) {
        return applicationService.getById(id);
    }

    @PostMapping
    public Application create(@RequestBody Application application) {
        return applicationService.create(application);
    }

    @PutMapping("/{id}")
    public Application update(
            @PathVariable Integer id,
            @RequestBody Application application) {

        return applicationService.update(id, application);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        applicationService.delete(id);
    }
}