package songdaesun.com.hellospring.repository;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import songdaesun.com.hellospring.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //Test가 진행될 때 마다 실행되는 코드
    // 공용코드들을 지워주는 것이 Test의 기본이다.
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result); //expectation, real
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(member1).isEqualTo(result);

        result = repository.findByName("spring2").get();
        assertThat(member2).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");

        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");

        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }
}
