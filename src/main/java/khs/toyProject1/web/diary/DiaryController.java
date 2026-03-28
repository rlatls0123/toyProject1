package khs.toyProject1.web.diary;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import khs.toyProject1.domain.diary.Diary;
import khs.toyProject1.domain.member.Member;
import khs.toyProject1.domain.repository.DiaryMemoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/diaries")
@RequiredArgsConstructor
@Slf4j
public class DiaryController {

    private final DiaryMemoryRepository dmRepository;

    @GetMapping
    public String diaries(Model model) {
        List<Diary> diaryList = dmRepository.findAll();
        model.addAttribute("diaryList", diaryList);
        return "/diary/diaries";
    }

    @GetMapping("/write")
    public String writeForm(Model model, HttpServletRequest request) {
        model.addAttribute("diary", new Diary());


        // 세션에 포함되어있는 이름 사용
        HttpSession session = request.getSession();
        Member loginMember = (Member) session.getAttribute("loginMember");
        String name = loginMember.getName();


        model.addAttribute("name", name);

        return "diary/write";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute("diary") DiarySaveForm form) {
        log.info("form={}", form);
        Diary diary = new Diary();
        diary.setTitle(form.getTitle());
        diary.setContent(form.getContent());
        diary.setLocalDateTime(LocalDateTime.now());
        dmRepository.save(diary);
        log.info("diary={}", diary);

        return "redirect:/diaries";
    }

    @GetMapping("/{diaryId}")
    public String diary(@PathVariable("diaryId") Long id, Model model) {
        Diary diary = dmRepository.findById(id);
        model.addAttribute("diary", diary);
        return "diary/diary";
    }

    @GetMapping("/{diaryId}/edit")
    public String edit(@PathVariable("diaryId") Long id, Model model) {
        Diary diary = dmRepository.findById(id);
        model.addAttribute("diary", diary);
        return "diary/edit";
    }

    @PostMapping("/{diaryId}/edit")
    public String edit(@PathVariable Long diaryId, @ModelAttribute("diary") DiaryUpdateForm form) {
//        Diary diary = dmRepository.findById(id);
        log.info("form={}", form);
        dmRepository.update(diaryId, form);


        return "redirect:/diaries/{diaryId}";
    }
}
