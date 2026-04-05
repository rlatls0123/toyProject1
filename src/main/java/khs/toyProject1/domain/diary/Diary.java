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

    public Diary(String title, String content, LocalDateTime localDateTime) {
        this.title = title;
        this.content = content;
        this.localDateTime = localDateTime;
    }
}
