package softwareproject.masterplan.board.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
