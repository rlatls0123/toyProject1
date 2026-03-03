package khs.toyProject1.web.member;

import jakarta.validation.Valid;
import khs.toyProject1.member.Member;
import khs.toyProject1.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

//    public MemberController(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @GetMapping("/add")
    public String add(@ModelAttribute("member")Member member) {
        return "/member/addMember";
    }

    @PostMapping("/add")
    public String addMember(@Valid @ModelAttribute("member") Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/member/addMember";

        }

        Member saved = memberRepository.save(member);
        Member byId = memberRepository.findById(saved.getId());
        log.info("member={}", byId);

        return "redirect:/";
    }
}
