package org.example.danet.controller;

import lombok.RequiredArgsConstructor;
import org.example.danet.service.StatementService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

    private final StatementService statementService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("statements", statementService.getAll());
        return "admin";
    }

    @PostMapping("/reject")
    public String reject(Long id) {
        statementService.reject(id);
        return "redirect:/admin";
    }

    @PostMapping("/confirm")
    public String confirm(Long id) {
        statementService.confirm(id);
        return "redirect:/admin";
    }

}
