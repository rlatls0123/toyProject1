package khs.toyProject1.domain.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import khs.toyProject1.domain.diary.Diary;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Diary> diaries = new ArrayList<>();


    private String loginId; //로그인 id
    private String name;
    private Integer age;
    private String password;

}
