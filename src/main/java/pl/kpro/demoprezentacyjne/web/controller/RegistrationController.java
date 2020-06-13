package pl.kpro.demoprezentacyjne.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.kpro.demoprezentacyjne.data.service.UserService;
import pl.kpro.demoprezentacyjne.web.payload.request.UserRegistrationRequest;

/**
 * @author Krzysztof 'impune_pl' Prorok <Krzysztof1397@gmail.com>
 */
@Controller
@RequestMapping("/register")
public class RegistrationController
{
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping
    public String registration(@RequestParam(defaultValue = "false") boolean error, Model model)
    {
        if(error)
            model.addAttribute("error","T");
        else
            model.addAttribute("error","F");
        return "registration";
    }


    @PostMapping
    public String registerNew(UserRegistrationRequest request, RedirectAttributes redirectAttributes)
    {
        if(request.getPassword().equals(request.getRepeatPassword()))
        {
            userService.registerUser(request);
            return "redirect:/";
        }
        else
        {
            redirectAttributes.addAttribute("error", Boolean.TRUE);
            return "redirect:/";
        }
    }
}
