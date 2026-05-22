package web.quan.ly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.quan.ly.entity.User_Session;

import java.util.Optional;


public interface UserSessionRepository extends JpaRepository<User_Session, Integer> {

    Optional<User_Session> findByToken(String token);

    User_Session getById(Integer id);
}
