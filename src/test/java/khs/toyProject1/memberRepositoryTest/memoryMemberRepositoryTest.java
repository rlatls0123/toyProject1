package khs.toyProject1.memberRepositoryTest;

import khs.toyProject1.member.Member;
import khs.toyProject1.repository.MemberRepository;
import khs.toyProject1.repository.exMemberRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class memoryMemberRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(memoryMemberRepositoryTest.class);
    MemberRepository memberRepository = new exMemberRepository();


    @Test
    void save() {
        Member member = new Member();
        member.setAge(20);
        member.setName("test1");
        member.setPassword("1234");
        Member saved = memberRepository.save(member);
        log.info("member={}",memberRepository.findById(saved.getId()));

    }
}
