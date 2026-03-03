package khs.toyProject1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "main";
    }


}
