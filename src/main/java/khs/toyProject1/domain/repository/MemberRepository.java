package khs.toyProject1.domain.repository;

import khs.toyProject1.domain.member.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Member findById(Long id);

    Optional<Member> findByLoginId(String loginId);

    void update(Long id, String loginId, String name, Integer age, String password);

    void delete(Long memberId);
}