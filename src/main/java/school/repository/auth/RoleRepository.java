package school.repository.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import school.model.auth.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
