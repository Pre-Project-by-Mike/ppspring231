package org.itmentor.dao;

import org.itmentor.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


@Repository
public class UserRepository {

   @PersistenceContext
   private javax.persistence.EntityManager em;

   private static org.slf4j.Logger logger = getLogger(UserRepository.class);

   public User show(int id) {
      return em.find(User.class, id);
   }

   public void add(User user) {
      em.persist(user);
      em.flush();
      logger.info("Inserting new user");
   }

   public void update(int id, User updatedUser) {
      org.itmentor.model.User userToBeUpdated = show(id);
      userToBeUpdated.setName(updatedUser.getName());
      userToBeUpdated.setSurName(updatedUser.getSurName());
      userToBeUpdated.setEmail(updatedUser.getEmail());
      logger.info("Updating user with id = " + id);
   }

   public void remove(int id) {
      User user = show(id);
      if (null == user) {
         throw new NullPointerException("User not found");
      }
      em.remove(user);
      em.flush();
      logger.info("Deleting user with id = " + id);
   }

   @SuppressWarnings("unchecked")
   public List<User> getUsers() {
      javax.persistence.Query query = em.createQuery("SELECT u FROM User u");
      return query.getResultList();
   }
}