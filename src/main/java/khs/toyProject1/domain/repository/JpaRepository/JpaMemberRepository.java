package khs.toyProject1.domain.repository.JpaRepository;

import khs.toyProject1.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {
}
