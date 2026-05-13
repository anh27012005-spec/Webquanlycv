package web.quan.ly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.quan.ly.entity.Job;


public interface JobRepository extends JpaRepository<Job, Integer> {

}
