package songdaesun.com.hellospring.controller;

import org.springframework.stereotype.Controller;

public class MemberForm {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;


}
