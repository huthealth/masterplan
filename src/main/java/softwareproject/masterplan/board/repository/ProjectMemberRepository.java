package softwareproject.masterplan.board.repository;

import softwareproject.masterplan.board.model.ProjectMember;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectMemberRepository extends CrudRepository<ProjectMember, Integer> {
        @Query("SELECT pm.id FROM ProjectMember pm where pm.projectidx = :projectidx")
        List<String> findidByProjectidx(@Param("projectidx") int projectidx);

        @Query("SELECT pm FROM ProjectMember pm where pm.id = :id")
        List<ProjectMember> findById(@Param("id") String id);

        @Query("SELECT pm FROM ProjectMember pm where pm.id = :username and pm.projectidx = :projectidx")
        ProjectMember findByProjectidxByUsername(@Param("projectidx") int projectidx, @Param("username") String username);

}
