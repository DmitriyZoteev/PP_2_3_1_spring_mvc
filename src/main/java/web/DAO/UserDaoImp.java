package web.DAO;

import web.Model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void saveOrChangeUser(User user) {
      entityManager.merge(user);
   }

   @Override
   public void deleteUser(Long id) {
      entityManager.remove(getUserById(id));
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getUsers() {
      return entityManager.createQuery("from User").getResultList();
   }

   @Override
   public User getUserById(Long id) {
      return entityManager.find(User.class, id);
   }

}
