package songdaesun.com.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // MVC가 있다면, Controller-Templete이 static보다 우선권을 가진다.
    public String home(){
        return "home";
    }
}
