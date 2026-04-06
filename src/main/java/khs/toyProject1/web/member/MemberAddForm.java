package khs.toyProject1.web.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberAddForm {

    @NotBlank
    private String loginId;

    @NotBlank
    private String name;

    @NotNull //int는 @NotBlank 사용x
    private Integer age;

    @NotBlank
    private String password;
}
