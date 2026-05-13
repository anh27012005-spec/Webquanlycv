package web.quan.ly.service;

import web.quan.ly.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();

    Company getById(Integer id);

    Company create(Company company);

    Company update(Integer id, Company company);

    void delete(Integer id);
}