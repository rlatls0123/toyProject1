package khs.toyProject1.domain.repository;

import khs.toyProject1.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Repository
//@RequiredArgsConstructor
public class exMemberRepository implements MemberRepository{

    private final static HashMap<Long, Member> repository = new HashMap<>();
    private static Long sequence=0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        repository.put(member.getId(), member);
        return member;
    }

    @Override
    public Member findById(Long id) {
        return repository.get(id);
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return new ArrayList<>(repository.values()).stream()
                 .filter(member -> member.getLoginId().equals(loginId))
                 .findFirst();
    }

    @Override
    public void update(Long id, String loginId, String name, Integer age, String password) {
        Member updateMember = repository.get(id);
        updateMember.setLoginId(loginId);
        updateMember.setName(name);
        updateMember.setAge(age);
        updateMember.setPassword(password);
    }

    @Override
    public void delete(Long memberId) {
        repository.remove(memberId);
    }
}
