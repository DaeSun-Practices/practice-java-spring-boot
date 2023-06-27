package songdaesun.com.hellospring.controller;

import  org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // 유저의 입력을 받는 부분 : url이 들어오는 부분
    public String helloMvd(@RequestParam(value = "name", required = false, defaultValue = "Name") String name, Model model){
        model.addAttribute("name", name); // Data(Model) 할당
        return "hello-template"; //view를 지정
    }


    @GetMapping("hello-string") // 유저의 입력을 받는 부분 : url이 들어오는 부분
    @ResponseBody // http의 body에 이 데이터를 직접 넣겠다.
    public String helloString(@RequestParam(value = "name", required = false, defaultValue = "Name") String name){
        return "hello " + name; // 그대로 hello에 name을 넣어버린다. html이 아닌 문제열을 바로 return해버린다.
    }


    // APi, json 방식
    @GetMapping("hello-api") // 유저의 입력을 받는 부분 : url이 들어오는 부분
    @ResponseBody // http의 body에 이 데이터를 직접 넣겠다. ResponseBody는 http응답에 직접 보낸다.
    // viewResolver가 아니라 HttpMessageConverter가 작동하는 것이다.

    // 객체를 반환하면 기본적으로 json 방식으로 만들어서 http응답에 반환하게 된다.
    // HttpMessageConverter가 객체를 json으로 변환하는 역할을 해준다.
    public Hello helloApi (@RequestParam(value = "name", required = false, defaultValue = "Name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}


