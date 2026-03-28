package khs.toyProject1.web.diary;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class DiaryUpdateForm {
    private String title;
    private String content;
    private LocalDateTime localDateTime;
}
