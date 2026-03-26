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


}
