package web.quan.ly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.quan.ly.entity.UserSession;

import java.util.Optional;


public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {

    Optional<UserSession> findByToken(String token);

    UserSession getById(Integer id);
}
