package softwareproject.masterplan.board.service;

import softwareproject.masterplan.board.model.Project;
import softwareproject.masterplan.board.model.ProjectMember;

import java.util.List;

public interface ProjectService {

    List<ProjectMember> selectProjectMemberList() throws  Exception;
    List<Project> selectProjectList(List<ProjectMember> list) throws  Exception;
    void saveProject(Project project) throws Exception;
    int pageCheck(int projectidx) throws Exception;
    int isMember(int projectidx, String username);
    void addMember(int projectidx, String username);

    List<String> selectProjectMemberListbyProjectidx(int projectidx);

    int progressBacklog(int projectidx);
    int progressBacklog_doing(int projectidx);
    int progressBacklog_done(int projectidx);

}
