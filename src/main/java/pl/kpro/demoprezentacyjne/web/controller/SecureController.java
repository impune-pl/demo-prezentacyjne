package pl.kpro.demoprezentacyjne.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Controller
@RequestMapping("/secure")
public class SecureController
{
    @GetMapping
    public String SecurePage(Model model)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("Username", username);
        return "secure";
    }
}
