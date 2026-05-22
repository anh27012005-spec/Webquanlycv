package web.quan.ly.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.quan.ly.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}

