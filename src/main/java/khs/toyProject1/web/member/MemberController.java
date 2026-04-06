package khs.toyProject1.web.member;

import jakarta.validation.Valid;
import khs.toyProject1.domain.member.Member;
import khs.toyProject1.domain.repository.JpaRepository.JpaMemberRepository;
import khs.toyProject1.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    private final JpaMemberRepository jpaMemberRepository;

//    public MemberController(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @GetMapping("/add")
    public String add(@ModelAttribute("member")Member member) {
        return "/member/addMember";
    }

//    @PostMapping("/add")
    public String addMember(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/member/addMember";

        }
        
        Member byId = memberRepository.findById(memberRepository.save(member).getId());
        log.info("member={}", byId);

        return "redirect:/";
    }
    @PostMapping("/add")
    public String jpaAddMember(@Valid @ModelAttribute("member") MemberAddForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/member/addMember";

        }

//        Member byId = memberRepository.findById(memberRepository.save(member).getId());
        Member member = new Member();
        member.setLoginId(form.getLoginId());
        member.setName(form.getName());
        member.setAge(form.getAge());
        member.setPassword(form.getPassword());
        jpaMemberRepository.save(member);


        return "redirect:/";
    }
}
