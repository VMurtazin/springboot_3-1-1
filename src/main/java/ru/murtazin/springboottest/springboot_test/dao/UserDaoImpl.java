package ru.murtazin.springboottest.springboot_test.dao;


import org.springframework.stereotype.Repository;
import ru.murtazin.springboottest.springboot_test.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUserById(long id) {
        entityManager.createQuery("delete from User where id=:id")
                .setParameter("id",id).executeUpdate();

    }

    @Override
    public void update(User updateUser) {
        entityManager.merge(updateUser);

    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        return (User) entityManager.createQuery("from User u where u.username=:username")
                .setParameter("username",username).getSingleResult();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class)
                .getResultList();
    }
}
