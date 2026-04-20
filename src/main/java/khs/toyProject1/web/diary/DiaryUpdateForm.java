package khs.toyProject1.web.diary;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DiarySaveForm을 써도 동작하기 때문에 없어도 되는 DTO
 * ->localDateTime은 받아오지 않고 직접 설정 가능
 */

@Getter @Setter
public class DiaryUpdateForm {
    private String title;
    private String content;
    private LocalDateTime localDateTime;
}
