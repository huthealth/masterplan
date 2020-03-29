package softwareproject.masterplan.board.controller;

import softwareproject.masterplan.board.model.User;
import softwareproject.masterplan.board.service.SecurityService;
import softwareproject.masterplan.board.service.UserService;
import softwareproject.masterplan.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";

        }

        userService.save(userForm);
/*
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
*/
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model, String error/*, String logout*/) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        return "login";
    }

}
