package khs.toyProject1.web.login;

import jakarta.validation.Valid;
import khs.toyProject1.domain.member.Member;
import khs.toyProject1.domain.repository.MemberRepository;
import khs.toyProject1.domain.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

   private final LoginService loginService;

    @GetMapping("/login")
    public String toLogin(@ModelAttribute("LoginForm") LoginForm loginForm) {
        return "login/Login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("LoginForm") LoginForm loginForm, BindingResult bindingResult, @RequestParam(defaultValue = "/") String Url) {
        if (bindingResult.hasErrors()) {
            return "login/Login";
        }

        log.info("loginForm={}", loginForm);

        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getLoginPassword());

        if (loginMember == null) {
            return "login/Login";
        }
        return "redirect:" + Url;
    }
}
