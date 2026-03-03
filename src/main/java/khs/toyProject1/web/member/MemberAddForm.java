package khs.toyProject1.web.member;

import jakarta.validation.constraints.NotBlank;

public class MemberAddForm {

    @NotBlank
    private String name;

    @NotBlank
    private Integer age;

    @NotBlank
    private String password;
}
