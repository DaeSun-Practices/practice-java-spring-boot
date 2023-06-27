package songdaesun.com.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import songdaesun.com.hellospring.repository.MemberRepository;
import songdaesun.com.hellospring.repository.MemoryMemberRepository;
import songdaesun.com.hellospring.service.MemberService;

//직접 Spring Bean을 연결하는 방법이다.
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
