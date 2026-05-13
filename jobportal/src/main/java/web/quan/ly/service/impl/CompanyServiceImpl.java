package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.quan.ly.entity.Company;
import web.quan.ly.repository.CompanyRepository;
import web.quan.ly.service.CompanyService;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getById(Integer id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company update(Integer id, Company company) {

        Company oldCompany = companyRepository.findById(id).orElse(null);

        if (oldCompany != null) {

            oldCompany.setName(company.getName());
            oldCompany.setDescription(company.getDescription());

            return companyRepository.save(oldCompany);
        }

        return null;
    }

    @Override
    public void delete(Integer id) {
        companyRepository.deleteById(id);
    }
}