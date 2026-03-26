package khs.toyProject1;

import jakarta.annotation.PostConstruct;
import khs.toyProject1.domain.diary.Diary;
import khs.toyProject1.domain.member.Member;
import khs.toyProject1.domain.repository.DiaryMemoryRepository;
import khs.toyProject1.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberRepository repository;
    private final DiaryMemoryRepository diaryMemoryRepository;

    @PostConstruct
    public void init() {

        Member member = new Member();
        member.setLoginId("qqq");
        member.setName("테스터");
        member.setAge(27);
        member.setPassword("111");

        repository.save(member);


        diaryMemoryRepository.save(new Diary("test1", "test1입니다.", LocalDateTime.of(2026, 3, 26, 14, 00)));
        diaryMemoryRepository.save(new Diary("test2", "test2입니다.", LocalDateTime.of(2026, 3, 26, 14, 01)));
    }

}
