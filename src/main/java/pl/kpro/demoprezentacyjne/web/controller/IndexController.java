package pl.kpro.demoprezentacyjne.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Controller
@RequestMapping("/")
public class IndexController
{
    @GetMapping
    public String Index(Model model)
    {
        model.addAttribute("Message", "Hello world!");
        return "index";
    }
}
