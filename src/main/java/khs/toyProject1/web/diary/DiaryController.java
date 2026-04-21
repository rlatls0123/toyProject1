package khs.toyProject1.web.diary;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import khs.toyProject1.domain.diary.Diary;
import khs.toyProject1.domain.member.Member;
import khs.toyProject1.domain.repository.DiaryMemoryRepository;
import khs.toyProject1.domain.repository.JpaRepository.JpaDiaryRepository;
import khs.toyProject1.domain.repository.JpaRepository.JpaMemberRepository;
import khs.toyProject1.domain.repository.JpaRepository.MemberRepository;
import khs.toyProject1.domain.service.DiaryService;
import khs.toyProject1.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/diaries")
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DiaryController {

    private final DiaryMemoryRepository dmRepository;
    private final JpaMemberRepository jpaMemberRepository;
    private final JpaDiaryRepository jpaDiaryRepository;

    private final DiaryService diaryService;
    private final MemberService memberService;


//    @GetMapping
    public String diaries(Model model) {
        List<Diary> diaryList = dmRepository.findAll();
        model.addAttribute("diaryList", diaryList);
        return "/diary/diaries";
    }

//    @GetMapping
    public String jpaDiaries(Model model) {
        List<Diary> diaryList = jpaDiaryRepository.findAll();
        model.addAttribute("diaryList", diaryList);
        return "/diary/diaries";
    }

//    @GetMapping
//    public String serviceJpaDiaries(Model model) {
//        List<Diary> diaryList = diaryService.findAll();
//        model.addAttribute("diaryList", diaryList);
//        return "/diary/diaries";
//    }

    @GetMapping
    public String getDiaries(Model model, @PageableDefault(page = 0,size = 5,sort = "id",direction = Sort.Direction.DESC)Pageable pageable) {
//        ResponseEntity<Page<Member>>
//        Page<Diary> result = DiaryService.getDiaryList(page, size);
//        return ResponseEntity.ok(result);

        Page<Diary> all = diaryService.findAll(pageable);
        model.addAttribute("diaryList",all); //글 전체

        int currentPage = all.getNumber(); //0부터 시작
        int totalPages = all.getTotalPages();
        log.info("currentPage={},totalPages={}",currentPage,totalPages);

        int startPage = (currentPage / 10) * 10;
        int endPage = Math.min(startPage + 10 - 1, totalPages - 1);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        log.info("startPage={},endPage={}",startPage,endPage);


        return "/diary/diaries";
    }

    @GetMapping("/write")
    public String writeForm(Model model, HttpServletRequest request) {
        model.addAttribute("diary", new Diary());

        // 세션에 포함되어있는 이름 사용
        Member loginMember = getSessoinLoginMember(request);
        String name = loginMember.getName();
        model.addAttribute("name", name);

        log.info("name={}", name);

        return "diary/write";
    }

    private static Member getSessoinLoginMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member loginMember = (Member) session.getAttribute("loginMember");
        return loginMember;
    }

    //    @PostMapping("/write")
    public String save(@ModelAttribute("diary") DiarySaveForm form) {
        log.info("form={}", form);
        Diary diary = new Diary();
        diary.setTitle(form.getTitle());
        diary.setContent(form.getContent());
        diary.setLocalDateTime(LocalDateTime.now());
        dmRepository.save(diary);
        log.info("diary={}", diary);

        return "redirect:/diaries";
    }
//    @PostMapping("/write")
    public String jpaSave(@ModelAttribute("diary") DiarySaveForm form,HttpServletRequest request) {
//        log.info("form={}", form);
//        Diary diary = new Diary();
//        diary.setTitle(form.getTitle());
//        diary.setContent(form.getContent());
//        diary.setLocalDateTime(LocalDateTime.now());
//        dmRepository.save(diary);
//        log.info("diary={}", diary);

        Member sessoinLoginMember = getSessoinLoginMember(request);

        Optional<Member> byId = jpaMemberRepository.findById(sessoinLoginMember.getId());
        jpaDiaryRepository.save(Diary.createDiary(byId.get(), form.getTitle(), form.getContent()));

        return "redirect:/diaries";
    }

    @PostMapping("/write")
    public String serviceSave(@ModelAttribute("diary") DiarySaveForm form,HttpServletRequest request) {

        Member member = memberService.findById(getSessoinLoginMember(request).getId());
        diaryService.save(Diary.createDiary(member, form.getTitle(), form.getContent()));

        return "redirect:/diaries";
    }

//    @GetMapping("/{diaryId}")
    public String diary(@PathVariable("diaryId") Long id, Model model) {
        Diary diary = dmRepository.findById(id);
        model.addAttribute("diary", diary);
        return "diary/diary";
    }

//    @GetMapping("/{diaryId}")
    public String jpaDiary(@PathVariable("diaryId") Long id, Model model) {

        Optional<Diary> diary = jpaDiaryRepository.findById(id);
        //Diary diary = dmRepository.findById(id);
        if (diary.isPresent()) {
            log.info("diary.id={}", diary.get().getId());
            model.addAttribute("diary", diary.get());

        } else {
            log.info("diary.id = null");
        }
        return "diary/diary";
    }

    @GetMapping("/{diaryId}")
    public String serviceJpaDiary(@PathVariable("diaryId") Long id, Model model) {

        Diary diary = diaryService.findById(id);
        model.addAttribute("diary", diary);

        return "diary/diary";
    }

//    @GetMapping("/{diaryId}/edit")
    public String edit(@PathVariable("diaryId") Long id, Model model) {
        Diary diary = dmRepository.findById(id);
        model.addAttribute("diary", diary);
        return "diary/edit";
    }

    @GetMapping("/{diaryId}/edit")
    public String serviceEdit(@PathVariable("diaryId") Long id, Model model) {
        Diary diary = diaryService.findById(id);
        model.addAttribute("diary", diary);
        log.info("diary.id={}",diary.getId());
        return "diary/edit";
    }

//    @PostMapping("/{diaryId}/edit")
    public String edit(@PathVariable Long diaryId, @ModelAttribute("diary") DiaryUpdateForm form) {
//        Diary diary = dmRepository.findById(id);
        log.info("form={}", form);
        dmRepository.update(diaryId, form);


        return "redirect:/diaries/{diaryId}";
    }

    @PostMapping("/{diaryId}/edit")
    public String serviceEdit(@PathVariable Long diaryId, @ModelAttribute("diary") DiaryUpdateForm form) {
        log.info("form={}", form);

        diaryService.update(diaryId,form);
        return "redirect:/diaries/{diaryId}";
    }
}
