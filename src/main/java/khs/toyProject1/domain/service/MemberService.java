package khs.toyProject1.domain.service;

import khs.toyProject1.domain.member.Member;
import khs.toyProject1.domain.repository.JpaRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    public void save(Member member) {
        repository.save(member);
    }

    public Member findById(Long id) {
        return repository.findById(id);
    }

}
