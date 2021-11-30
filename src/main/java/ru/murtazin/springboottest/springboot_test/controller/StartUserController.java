package ru.murtazin.springboottest.springboot_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.murtazin.springboottest.springboot_test.model.Role;
import ru.murtazin.springboottest.springboot_test.model.User;
import ru.murtazin.springboottest.springboot_test.service.RoleService;
import ru.murtazin.springboottest.springboot_test.service.UserService;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class StartUserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public StartUserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void startUsers(){
        roleService.saveRole(new Role("ROLE_ADMIN"));
        roleService.saveRole(new Role("ROLE_USER"));

        Set<Role>roles1=new HashSet<>();
        roles1.add(roleService.findRoleByName("ROLE_USER"));
        roles1.add(roleService.findRoleByName("ROLE_ADMIN"));

        User user=new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setCity("City1");
        user.setEmail("admin@admin.ru");
        user.setRoles(roles1);
        userService.saveUser(user);

        Set<Role>roles2=new HashSet<>();
        roles2.add(roleService.findRoleByName("ROLE_USER"));

        User user1=new User();
        user1.setUsername("user");
        user1.setPassword("user");
        user1.setCity("City2");
        user1.setEmail("user@user.ru");
        user1.setRoles(roles2);
        userService.saveUser(user1);

    }

}
