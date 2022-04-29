package mvc_pattern.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // "/"는 제일 처음 주소
    public String home() {
        return "home";
    }


}
