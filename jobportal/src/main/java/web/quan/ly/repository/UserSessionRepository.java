package web.quan.ly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.quan.ly.entity.UserSession;

import java.util.List;
import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSession, Integer> {

    Optional<UserSession> findByUser_Id(Integer userId);

    List<UserSession> findAllByUser_Id(Integer userId);

    Optional<UserSession> findByToken(String token);

    void deleteByToken(String token);

    @Query("""
           SELECT us
           FROM UserSession us
           JOIN FETCH us.user
           WHERE us.token = :token
           """)
    Optional<UserSession> findByTokenWithUser(@Param("token") String token);
}