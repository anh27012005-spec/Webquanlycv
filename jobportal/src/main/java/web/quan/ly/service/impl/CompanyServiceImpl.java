package web.quan.ly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.quan.ly.common.ValidationException;
import web.quan.ly.dto.CompanyRequest;
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
    public Company save(CompanyRequest companyRequest) {

        if (companyRepository.existsByName(companyRequest.getCompanyName())) {
            throw new ValidationException("Cong ty da ton tai");
        }

        Company company = new Company();

        company.setName(companyRequest.getCompanyName());
        company.setDescription(companyRequest.getDescription());

        return companyRepository.save(company);
    }

    @Override
     public Company update(Integer id, CompanyRequest companyRequest) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Khong tim thay cong ty"));

        company.setName(companyRequest.getCompanyName());
        company.setDescription(companyRequest.getDescription());

        return companyRepository.save(company);
    }

    @Override
    public void delete(Integer id) {
        companyRepository.deleteById(id);
    }
}