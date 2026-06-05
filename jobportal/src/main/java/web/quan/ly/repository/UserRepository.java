package web.quan.ly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.quan.ly.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsBySdt(String sdt);
}
