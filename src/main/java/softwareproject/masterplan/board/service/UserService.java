package softwareproject.masterplan.board.service;

import softwareproject.masterplan.board.model.User;

import java.util.Collection;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    User selectUsername();

    Collection<User> findByName(String username);
}
