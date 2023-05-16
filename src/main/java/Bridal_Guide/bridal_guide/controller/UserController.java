package Bridal_Guide.bridal_guide.controller;

import Bridal_Guide.bridal_guide.model.UserModel;
import Bridal_Guide.bridal_guide.service.implementation.UserIMplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserIMplementation userService;
    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("HomePage");
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("requestLogin", new UserModel());
        return "login";
    }
    @GetMapping("/signUp")
    public String signUpPage(Model model){
        model.addAttribute("requestSignIn", new UserModel());
        return "SignUp";
    }
    @GetMapping("/registrationPage")
    public String personalPage(Model model){
        model.addAttribute("requestPersonalPage", new UserModel());
        return "registration";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel){
        System.out.println("register Request: " + userModel);
        UserModel registerUser= userService.createUser(userModel);
        return registerUser ==null ? "error_page" : "redirect:/login";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel, Model model){
        System.out.println("login Request: " + userModel);
        UserModel authenticate = userService.getUser(userModel);
        if(authenticate !=null){
            model.addAttribute("userLogin", authenticate.getEmail());
            return "personal_page";

        }else{
            return "error_page";
        }
    }


}
