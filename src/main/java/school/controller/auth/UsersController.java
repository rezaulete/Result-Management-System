/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.controller.auth;

import school.model.auth.Users;
import school.repository.auth.RoleRepository;
import school.repository.auth.UsersRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("users", usersRepository.findAll());
        return "auth/index";
    }

    @RequestMapping("/registration")
    public String registration(Model model, Users users) {
        model.addAttribute("roles", roleRepository.findAll());
        return "auth/registration";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, Users users, @PathVariable Long id) {
        model.addAttribute("users", usersRepository.findOne(id));
        model.addAttribute("roles", roleRepository.findAll());
        return "auth/registration";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Users users, BindingResult bindingResult) {

        // userValidator.validate(users, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roleRepository.findAll());
            return "auth/registration";
        }
//        } else if (usersRepository.findByEmail(users.getEmail()) != null) {
//            model.addAttribute("roles", roleRepository.findAll());
//            model.addAttribute("status", Yes_No.values());
//            model.addAttribute("email_exist", "This email already exist. Please try another.");
//            return "auth/registration";
//        }

        usersRepository.save(users);
        return "redirect:/users/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        usersRepository.delete(id);
        return "redirect:/users/index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("attribute", "value");
        return "auth/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        redirectAttributes.addFlashAttribute("logout", "You have been successfully logout");
        return "redirect:/users/login";
    }

}
