package khs.toyProject1;

import jakarta.annotation.PostConstruct;
import khs.toyProject1.domain.diary.Diary;
import khs.toyProject1.domain.member.Member;
import khs.toyProject1.domain.repository.DiaryMemoryRepository;
import khs.toyProject1.domain.repository.JpaRepository.DiaryRepository;
import khs.toyProject1.domain.repository.JpaRepository.JpaDiaryRepository;
import khs.toyProject1.domain.repository.JpaRepository.JpaMemberRepository;
import khs.toyProject1.domain.repository.MemberRepository;
import khs.toyProject1.domain.service.DiaryService;
import khs.toyProject1.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//@Component
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberRepository repository;
    private final DiaryMemoryRepository diaryMemoryRepository;
    private final JpaMemberRepository jpaMemberRepository;
    private final JpaDiaryRepository jpaDiaryRepository;
    private final MemberService memberService;
    private final DiaryService diaryService;

    @PostConstruct
    public void init() {

        Member member = new Member();
        member.setLoginId("qqq");
        member.setName("테스터");
        member.setAge(27);
        member.setPassword("111");

//        repository.save(member);
//        jpaMemberRepository.save(member);
        memberService.save(member);




        //메모리로 저장
//        diaryMemoryRepository.save(new Diary("test1", "test1입니다.", LocalDateTime.of(2026, 3, 26, 14, 00)));
//        diaryMemoryRepository.save(new Diary("test2", "test2입니다.", LocalDateTime.of(2026, 3, 26, 14, 01)));

        //jpa로 저장 - new생성으로 저장(Diary.memberId == null)
//        jpaDiaryRepository.save(new Diary("test1", "test1입니다.", LocalDateTime.of(2026, 4, 6, 10, 00)));
//        jpaDiaryRepository.save(new Diary("test2", "test2입니다.", LocalDateTime.of(2026, 4, 6, 10, 22)));

//        //jpa로 저장 - 엔티티에 로직 구현(Diary.memberId = member.id)
//        jpaDiaryRepository.save(Diary.createDiary(member, "test1", "test1입니다."));
//        jpaDiaryRepository.save(Diary.createDiary(member, "test2", "test2입니다."));
//
        //
        diaryService.save(Diary.createDiary(member, "test1", "test1입니다."));
        diaryService.save(Diary.createDiary(member, "test2", "test2입니다."));
    }

}
