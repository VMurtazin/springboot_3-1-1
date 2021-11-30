package ru.murtazin.springboottest.springboot_test.dao;



import ru.murtazin.springboottest.springboot_test.model.Role;

import java.util.HashSet;
import java.util.List;

public interface RoleDao {

    void saveRole(Role role);
    void updateRole(Role role);
    void removeRoleById (Long id);
    List<Role> getAllRoles();
    Role findRoleByName(String name);
    HashSet<Role> getSetOfRoles(String[]roleSet);
}
