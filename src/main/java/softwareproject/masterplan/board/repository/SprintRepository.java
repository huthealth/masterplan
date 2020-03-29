package softwareproject.masterplan.board.repository;


import softwareproject.masterplan.board.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

    @Query("SELECT sp FROM Sprint sp where sp.projectidx = :projectidx")
    Sprint findByProjectidx(@Param("projectidx") int projectidx);

    @Query("SELECT sp FROM Sprint sp where sp.sprintid = :sprintid")
    Sprint findBySprintid(@Param("sprintid") Long sprintid);

    @Modifying
    @Transactional
    @Query("UPDATE Sprint sp SET sp.level = :level where sp.sprintid = :sprintid")
    void updateLevelBySprintid(@Param("sprintid") Long sprintid, @Param("level") int level);

    @Modifying
    @Transactional
    @Query("UPDATE Sprint sp SET sp.cycle = :cycle where sp.sprintid = :sprintid")
    void updateCycleBySprintid(@Param("sprintid") Long sprintid, @Param("cycle") int cycle);


}

