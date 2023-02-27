package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
   void saveOrChangeUser(User user);
   void deleteUser(Long id);
   List<User> getUsers();
   User getUserById(Long id);
}
