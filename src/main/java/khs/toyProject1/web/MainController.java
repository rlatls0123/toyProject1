package khs.toyProject1.web;

import khs.toyProject1.domain.member.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
public class MainController {

//    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String loginHome(@SessionAttribute(required = false) Member loginMember, Model model) {
        if (loginMember == null) {
            log.info("null session");
            return "home";
        }
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
