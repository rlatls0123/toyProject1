package khs.toyProject1.web.diary;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * DiarySaveForm을 써도 동작하기 때문에 없어도 되는 DTO
 * ->localDateTime은 받아오지 않고 직접 설정 가능
 */

@Getter @Setter
public class DiaryUpdateForm {
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    private LocalDateTime localDateTime;
}
