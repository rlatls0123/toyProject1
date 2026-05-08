package khs.toyProject1.web.diary;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DiarySaveForm {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
