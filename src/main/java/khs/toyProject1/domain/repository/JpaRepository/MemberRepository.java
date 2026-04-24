package khs.toyProject1.domain.repository.JpaRepository;

import khs.toyProject1.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final SpringDataJpaMemberRepository repository;

    public void save(Member member) {
        repository.save(member);
    }

    public Member findById(Long id) {
        Optional<Member> optionalMember = repository.findById(id);
        if (optionalMember.isPresent()) {
            return optionalMember.get();
        } else {
            throw new IllegalStateException("멤버가 없습니다.");
        }
    }

}
