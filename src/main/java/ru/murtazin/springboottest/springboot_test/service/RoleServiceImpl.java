package ru.murtazin.springboottest.springboot_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.murtazin.springboottest.springboot_test.dao.RoleDao;
import ru.murtazin.springboottest.springboot_test.model.Role;


import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional

public class RoleServiceImpl implements RoleService{

    private RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }

    @Override
    public void removeRoleById(Long id) {
        roleDao.removeRoleById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role findRoleByName(String name) {
        return roleDao.findRoleByName(name);
    }

    @Override
    public HashSet<Role> getSetOfRoles(String[] roleSet) {
        return roleDao.getSetOfRoles(roleSet);
    }
}
