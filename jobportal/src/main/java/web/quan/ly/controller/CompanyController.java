package web.quan.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Company create(@RequestBody Company company) {
        return companyService.create(company);
    }

    @PutMapping("/{id}")
    public Company update(@PathVariable Integer id,
                          @RequestBody Company company) {

        return companyService.update(id, company);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        companyService.delete(id);
    }
}