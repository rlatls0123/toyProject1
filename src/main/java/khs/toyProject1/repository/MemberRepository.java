package khs.toyProject1.repository;

import khs.toyProject1.member.Member;

public interface MemberRepository {

    Member save(Member member);

    Member findById(Long id);

    void update(Long id, String name, Integer age, String password);

    void delete(Long memberId);
}