package songdaesun.com.hellospring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import songdaesun.com.hellospring.domain.Member;
import songdaesun.com.hellospring.repository.MemberRepository;
import songdaesun.com.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//@Service // 순수한 Class를 Spring이 직접 관리할 수 있도록 Annotation을 붙혀줘야 한다.
public class MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    //@Autowired // 생성자에 Repository 의존성을 자동으로 넣어준다.
    public MemberService(MemberRepository memberRepository){

        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * 같은 이름이 있는 회원은 가입이 안된다.
     */
    public Long join(Member member){
        //        Optional<Member> result =  memberRepository.findByName(member.getName());
        //
        //        result.ifPresent(m -> {
        //            throw new IllegalStateException("이미 존재하는 회원입니다");
        //        });

        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다");
            });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
