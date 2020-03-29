package softwareproject.masterplan.board.repository;

import softwareproject.masterplan.board.model.SprintTodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SprintTodoRepository extends JpaRepository<SprintTodo, Long> {

    @Query("SELECT sptodo FROM SprintTodo sptodo where sptodo.sprintid = :sprintid")
    List<SprintTodo> findBySprintid(@Param("sprintid") Long sprintid);

    @Query("SELECT sptodo FROM SprintTodo sptodo where sptodo.sprintid = :sprintid and sptodo.isdoing ='Y'")
    List<SprintTodo> findDoingBySprintid(@Param("sprintid") Long sprintid);

    @Query("SELECT sptodo FROM SprintTodo sptodo where sptodo.sprintid = :sprintid and sptodo.isdone ='Y'")
    List<SprintTodo> findDoneBySprintid(@Param("sprintid") Long sprintid);

    @Transactional
    @Modifying
    @Query("UPDATE SprintTodo std SET std.isdoing =:isdoing, std.isdone =:isdone ,std.username =:username WHERE std.todoid =:todoId")
    void updateInquiry(@Param("todoId") Long todoId, @Param("isdoing") String isdoing, @Param("isdone") String isdone, @Param("username") String username);

    @Query("SELECT sptodo.username FROM SprintTodo sptodo WHERE sptodo.todoid =:todoid")
    String findusernamebytodoid(@Param("todoid") Long todoid);

    @Modifying
    @Transactional
    @Query("delete from SprintTodo sptodo where sptodo.sprintid = :sprintid")
    void deleteUsingSingleQuery(@Param("sprintid") Long sprintid);
}
