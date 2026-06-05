package web.quan.ly.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import web.quan.ly.dto.CvRequest;
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
    public ResponseEntity<Cv> createCv(
            @Valid @RequestBody CvRequest request) {

        return ResponseEntity.ok(CvService.save(request));
    }
}