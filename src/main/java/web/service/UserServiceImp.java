package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void saveOrChangeUser(User user) {
      userDao.saveOrChangeUser(user);
   }

   @Transactional
   @Override
   public void deleteUser(Long id) {
      userDao.deleteUser(id);
   }

   @Override
   public List<User> getUsers() {
      return userDao.getUsers();
   }

   @Override
   public User getUserById(Long id) {
      return userDao.getUserById(id);
   }
}
