package ru.murtazin.springboottest.springboot_test.dao;

import org.springframework.stereotype.Repository;
import ru.murtazin.springboottest.springboot_test.model.Role;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void removeRoleById(Long id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role findRoleByName(String roleName) {
        return (Role) entityManager.createQuery("from Role r where r.name=:role")
                .setParameter("role",roleName)
                .getSingleResult();
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleNames) {
        Set<Role> roleSet=new HashSet<>();
        for (String role:roleNames){
            roleSet.add(findRoleByName(role));
        }
        return(HashSet)roleSet;
    }
}
