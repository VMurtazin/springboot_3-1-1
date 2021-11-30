package ru.murtazin.springboottest.springboot_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.murtazin.springboottest.springboot_test.model.User;
import ru.murtazin.springboottest.springboot_test.service.RoleService;
import ru.murtazin.springboottest.springboot_test.service.UserService;

import javax.transaction.Transactional;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String listUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "admin";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "new";
    }

    @PatchMapping(value = "add-user")
    public String addUser(@ModelAttribute User user, @RequestParam(value = "nameRoles") String [] nameRoles) {
        user.setRoles(roleService.getSetOfRoles(nameRoles));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/edit/{id}")
    public String editUserForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "edit";
    }

    @PutMapping(value = "/edit")
    public String editUser(@ModelAttribute User user, @RequestParam(value = "nameRoles") String [] nameRoles) {
        user.setRoles(roleService.getSetOfRoles(nameRoles));
        userService.update(user);
        return "redirect:/admin";
    }

//    @Transactional
//    @PatchMapping(value = "/edit")
//    public String editUser(@ModelAttribute User user, @RequestParam(value = "nameRoles") String [] nameRoles) {
//        user.setRoles(roleService.getSetOfRoles(nameRoles));
//        userService.update(user);
//        return "redirect:/admin";
//    }




    @DeleteMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "redirect:/admin";
    }
}