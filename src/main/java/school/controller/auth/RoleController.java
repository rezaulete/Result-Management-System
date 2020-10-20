/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.controller.auth;

import school.model.auth.Role;
import school.repository.auth.RoleRepository;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/index")
    public String index(Model model, Role role) {
        model.addAttribute("list", roleRepository.findAll());
        model.addAttribute("table_name", "Role");
        return "/auth/role";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Role role, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("list", roleRepository.findAll());
            model.addAttribute("table_name", "Role");
            return "/auth/role";
        }
        roleRepository.save(role);
        return "redirect:/role/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Role role, Model model) {
        model.addAttribute("role", roleRepository.findOne(id));
        model.addAttribute("list", roleRepository.findAll());
        model.addAttribute("table_name", "Role");
        return "/auth/role";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Role role) {
        roleRepository.delete(id);
        return "redirect:/role/index";
    }

}
