package songdaesun.com.hellospring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import songdaesun.com.hellospring.domain.Member;
import songdaesun.com.hellospring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository repository;
    @BeforeEach
    public void beforeEach(){
         repository = new MemoryMemberRepository();
         memberService = new MemberService(repository);
    }

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());


    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        //when
        memberService.join(member1);
        //assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");

        //        try{
        //            memberService.join(member2);
        //            fail("예외가 발생해야 합니다.");
        //        }
        //        catch (IllegalStateException e){
        //            //정상의 경우 skip
        //            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        //        }
        //then



    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}