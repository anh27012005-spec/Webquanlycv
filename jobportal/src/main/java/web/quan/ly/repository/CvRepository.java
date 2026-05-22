package web.quan.ly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.quan.ly.entity.Cv;

@Repository
public interface CvRepository extends JpaRepository<Cv, Integer> {

}

