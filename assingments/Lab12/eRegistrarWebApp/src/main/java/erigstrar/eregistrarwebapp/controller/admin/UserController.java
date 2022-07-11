package erigstrar.eregistrarwebapp.controller.admin;


import erigstrar.eregistrarwebapp.model.User;
import erigstrar.eregistrarwebapp.service.RoleService;
import erigstrar.eregistrarwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;


@Controller
public class UserController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = {"/eregistrar/admin/user","/eregistrar/admin/user/list"})
    public ModelAndView displayUsersList() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("users", userService.getAllUsers());
//        mav.addObject("users", new ArrayList<User>()); // to test empty list
        mav.setViewName("/admin/list");
        return mav;
    }

    @GetMapping(value = {"/eregistrar/admin/user/new"})
    public ModelAndView displayNewUserForm() {
        ModelAndView mav = new ModelAndView();
        User user = new User();
        mav.addObject("user", user);
        mav.addObject("roles", roleService.getAllRoles());
        mav.setViewName("/admin/new");
        return mav;
    }

    @PostMapping(value = {"/eregistrar/admin/user/new"})
    public String addNewUser(@Valid @ModelAttribute("user") User user,
                             Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/admin/new";
        }
        User newAddedUser = userService.saveUser(user);
        return "redirect:/eregistrar/admin/user/list";
    }

    @GetMapping(value = {"/eregistrar/admin/user/edit/{userId}"})
    public String editUser(@PathVariable Integer userId, Model model) {
        User user = userService.getUserById(userId);
        if(user != null) {
            user.setPassword("");
            model.addAttribute("user", user);
            model.addAttribute("roles", roleService.getAllRoles());
            return "/admin/edituser";
        }
        return "redirect:/eregistrar/admin/user/list";
    }

    @PostMapping(value = {"/eregistrar/admin/user/edit"})
    public String updateUser(@Valid @ModelAttribute("user") User user,
                             Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/admin/edituser";
        }
        user = userService.saveUser(user);
        return "redirect:/eregistrar/admin/user/list";
    }
}
