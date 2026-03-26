package khs.toyProject1.domain.diary;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Diary {
    private Long id;
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
