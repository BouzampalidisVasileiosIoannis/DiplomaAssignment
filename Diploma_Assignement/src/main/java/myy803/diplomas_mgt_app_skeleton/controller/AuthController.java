package myy803.diplomas_mgt_app_skeleton.controller;

import myy803.diplomas_mgt_app_skeleton.model.Role;
import myy803.diplomas_mgt_app_skeleton.model.Student;
import myy803.diplomas_mgt_app_skeleton.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import myy803.diplomas_mgt_app_skeleton.model.User;
import myy803.diplomas_mgt_app_skeleton.service.UserService;



@Controller
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;

    public AuthController() {
    	super();
    }

    @RequestMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }


    @RequestMapping("/login")
    public String login() {
        return "auth/login";
    }



    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @RequestMapping("/save")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        if (user.getUsername() == null || user.getUsername().isEmpty() || user.getPassword() == null || user.getPassword().isEmpty()) {
            model.addAttribute("errorMessage", "Invalid Attributes");
            return "auth/error";
        }

        if (userService.isUserPresent(user)) {
            model.addAttribute("errorMessage", "User already registered!");
            return "auth/error";
        }
        else{
            userService.saveUser(user);
            model.addAttribute("successMessage", "User registered successfully!");
        }


        return "auth/login";
    }

}