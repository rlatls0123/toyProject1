package khs.toyProject1.web.login;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/login")
    public String toLogin(@ModelAttribute("LoginForm") LoginForm loginForm) {
        return "login/Login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("LoginForm") LoginForm loginForm, BindingResult bindingResult, @RequestParam(defaultValue = "/") String Url) {
        if (bindingResult.hasErrors()) {
            return "login/Login";

        }
        return "redirect:" + Url;
    }
}
