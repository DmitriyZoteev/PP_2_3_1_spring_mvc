package web.DAO;

import web.Model.User;

import java.util.List;

public interface UserDao {
   void saveOrChangeUser(User user);
   void deleteUser(Long id);
   List<User> getUsers();
   User getUserById(Long id);
}
