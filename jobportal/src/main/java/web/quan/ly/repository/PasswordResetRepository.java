
package web.quan.ly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.quan.ly.entity.PasswordReset;

@Repository
public interface PasswordResetRepository
        extends JpaRepository<PasswordReset, Integer> {

    PasswordReset findByEmailAndOtpAndUsedFalse(
            String email,
            String otp
    );
}