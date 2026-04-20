package khs.toyProject1.domain.service;

import khs.toyProject1.domain.member.Member;
import khs.toyProject1.domain.repository.JpaRepository.JpaMemberRepository;
import khs.toyProject1.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final MemberRepository repository;
    private final JpaMemberRepository jpaMemberRepository;

   public Member login(String loginId, String password) {
        return repository.findByLoginId(loginId).filter(member -> member.getPassword()
                .equals(password)).orElse(null);
   }

   public Member jpaLogin(String loginId, String password) {
       Member member = jpaMemberRepository.findByLoginId(loginId)
               .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다. "));

       log.info("password={},member.password={}",password,member.getPassword());
       if ( !password.equals(member.getPassword()) ) {
           throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
       }

       return member;
   }


}
