package web.quan.ly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.quan.ly.entity.Company;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
