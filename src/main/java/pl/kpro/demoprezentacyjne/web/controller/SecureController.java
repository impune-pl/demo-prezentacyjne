package pl.kpro.demoprezentacyjne.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Controller
@RequestMapping("/secure")
public class SecureController
{
    @GetMapping
    public String SecurePage(Model model,Authentication authentication)
    {
        String username = authentication.getName();
        Collection<SimpleGrantedAuthority> roles = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities();
        model.addAttribute("Username", username);
        model.addAttribute("Roles", roles);
        return "secure";
    }
}
