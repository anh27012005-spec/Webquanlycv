package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import web.quan.ly.entity.Cv_certificate;
import web.quan.ly.service.CvCertificateService;

import java.util.List;

@RestController
@RequestMapping("/api/cvcertificate")
public class CvCertificateController {

    @Autowired
    private CvCertificateService cvCertificateService;

    @GetMapping
    public ResponseEntity<List<Cv_certificate>> getAll() {
        return ResponseEntity.ok(cvCertificateService.getAll());
    }

    @PostMapping
    public Cv_certificate addCv_certificate(@RequestBody Cv_certificate cv_certificate) {
        return cvCertificateService.save(cv_certificate);
    }

}