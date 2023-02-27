package web.controller;

import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/allUsers")
    public String getUsers(Model model) {
        model.addAttribute("usersList", userService.getUsers());
        return "users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model){
        model.addAttribute("user", new User());
        return "user-info";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveOrChangeUser(user);
        return "redirect:/allUsers";
    }
    @RequestMapping("/updateInfo/{id}")
    public String updateUser(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-info";
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/allUsers";
    }
}
