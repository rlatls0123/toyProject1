package khs.toyProject1.domain.repository.JpaRepository;

import khs.toyProject1.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
//@Transactional
public interface JpaMemberRepository extends JpaRepository<Member, Long> {
    // 사용자 아이디로 회원 정보를 찾는 메서드
    Optional<Member> findByLoginId(String loginId);
}
