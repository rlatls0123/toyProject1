package khs.toyProject1.repository;

import khs.toyProject1.member.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

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
    public void update(Long id, String name, Integer age, String password) {
        Member updateMember = repository.get(id);
        updateMember.setName(name);
        updateMember.setAge(age);
        updateMember.setPassword(password);
    }

    @Override
    public void delete(Long memberId) {
        repository.remove(memberId);
    }
}
