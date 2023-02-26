package web.Service;

import web.DAO.UserDao;
import web.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

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
   @Transactional
   @Override
   public List<User> getUsers() {
      return userDao.getUsers();
   }
   @Transactional
   @Override
   public User getUserById(Long id) {
      return userDao.getUserById(id);
   }
}
