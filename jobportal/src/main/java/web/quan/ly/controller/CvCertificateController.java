package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import web.quan.ly.entity.CvCertificate;
import web.quan.ly.service.CvCertificateService;

import java.util.List;

@RestController
@RequestMapping("/api/cvcertificate")
public class CvCertificateController {

    @Autowired
    private CvCertificateService cvCertificateService;

    @GetMapping
    public ResponseEntity<List<CvCertificate>> getAll() {
        return ResponseEntity.ok(cvCertificateService.getAll());
    }

    @PostMapping
    public CvCertificate addCv_certificate(@RequestBody CvCertificate cv_certificate) {
        return cvCertificateService.save(cv_certificate);
    }

}