package web.quan.ly.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import web.quan.ly.dto.CompanyRequest;
import web.quan.ly.entity.Company;
import web.quan.ly.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable Integer id) {
        return companyService.getById(id);
    }

    @PostMapping
    public Company save(@Valid @RequestBody CompanyRequest companyRequest) {
        return companyService.save(companyRequest);
    }

    @PutMapping("/{id}")
    public Company update(@PathVariable Integer id,
                          @Valid @RequestBody CompanyRequest companyRequest) {

        return companyService.update(id, companyRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        companyService.delete(id);
    }
}