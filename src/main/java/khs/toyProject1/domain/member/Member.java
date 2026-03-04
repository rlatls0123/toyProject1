package khs.toyProject1.domain.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Member {
    private Long id;


    @NotEmpty
    private String loginId; //로그인 id

    @NotBlank
    private String name;

    @NotNull
    private Integer age;

    @NotBlank
    private String password;

}
