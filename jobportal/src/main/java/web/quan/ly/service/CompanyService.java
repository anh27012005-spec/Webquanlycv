package web.quan.ly.service;
import web.quan.ly.dto.CompanyRequest;
import web.quan.ly.entity.Company;

import java.util.List;


public interface CompanyService {

    List<Company> getAll();

    Company getById(Integer id);

    Company save(CompanyRequest companyRequest);

    Company update(Integer id, CompanyRequest companyRequest);

    void delete(Integer id);
}