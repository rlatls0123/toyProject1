package khs.toyProject1.domain.diary;

import jakarta.persistence.*;
import khs.toyProject1.domain.member.Member;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    private String title;
    private String content;
    private LocalDateTime localDateTime;

    public Diary() {
    }

    public Diary(Member member, String title, String content) {
        setMember(member);
        this.title = title;
        this.content = content;
    }

    public Diary(String title, String content, LocalDateTime localDateTime) {
        this.title = title;
        this.content = content;
        this.localDateTime = localDateTime;
    }

    public void setMember(Member member) {
        this.member = member;
        member.getDiaries().add(this);
    }

    public static Diary createDiary(Member member,String title, String content) {
        Diary diary = new Diary(member, title, content);
        diary.setLocalDateTime(LocalDateTime.now());

        return diary;

    }
}
