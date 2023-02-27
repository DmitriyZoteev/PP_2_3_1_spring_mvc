package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveOrChangeUser(User user);
    void deleteUser(Long id);
    List<User> getUsers();
    User getUserById(Long id);
}
