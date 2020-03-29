package softwareproject.masterplan.board.repository;

import softwareproject.masterplan.board.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>{
    List<Role> findById(long Id);
}
