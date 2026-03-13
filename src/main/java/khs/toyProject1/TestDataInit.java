package khs.toyProject1;

import jakarta.annotation.PostConstruct;
import khs.toyProject1.domain.member.Member;
import khs.toyProject1.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberRepository repository;

    @PostConstruct
    public void init() {

        Member member = new Member();
        member.setLoginId("qqq");
        member.setName("테스터");
        member.setAge(27);
        member.setPassword("111");

        repository.save(member);
    }

}
