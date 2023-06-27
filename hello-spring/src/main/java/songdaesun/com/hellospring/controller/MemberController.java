package songdaesun.com.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import songdaesun.com.hellospring.domain.Member;
import songdaesun.com.hellospring.service.MemberService;
import songdaesun.com.hellospring.controller.MemberForm;

import java.util.List;


@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //Spring Bean에 있는 의존 관계를 자동으로 넣어준다.
    // Controller는 Spring이 직접 관리하기에 Annotation을 써야만 한다.
    public  MemberController(MemberService memberService){
        this.memberService = memberService;
    }


    @GetMapping("members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }


    @GetMapping("members")
    public String list(Model model){
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
