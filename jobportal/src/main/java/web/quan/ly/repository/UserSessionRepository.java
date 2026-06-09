package web.quan.ly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.quan.ly.entity.UserSession;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {

    Optional<UserSession> findByToken(String token);

    List<UserSession> findByUser_IdAndRevokedFalse(Integer userId);
}