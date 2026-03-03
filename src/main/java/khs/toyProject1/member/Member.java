package khs.toyProject1.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Member {
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Integer age;

    @NotBlank
    private String password;

}
