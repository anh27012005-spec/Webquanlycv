package web.quan.ly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.quan.ly.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
