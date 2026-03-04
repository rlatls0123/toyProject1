package khs.toyProject1.domain.service;

import khs.toyProject1.domain.member.Member;
import khs.toyProject1.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository repository;

   public Member login(String loginId, String password) {
        return repository.findByLoginId(loginId).filter(member -> member.getPassword()
                .equals(password)).orElse(null);
    }


}
