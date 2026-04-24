package khs.toyProject1.domain.repository.JpaRepository;

import khs.toyProject1.domain.diary.Diary;
import khs.toyProject1.web.diary.DiaryUpdateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DiaryRepository  {

private final SpringDataJpaDiaryRepository repository;

    public void save(Diary diary) {
        repository.save(diary);
    }

    public Diary findById(Long id) {
        Optional<Diary> diary = repository.findById(id);
        if (diary.isPresent()) {
            return diary.get();
        } else {
            throw new IllegalStateException("다이어리 아이디가 없습니다");
        }
    }

    public List<Diary> findAll() {
        return repository.findAll();
    }

    // 전체 조회 시 페이징 적용
    public Page<Diary> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void update(Long id, DiaryUpdateForm form) {
        Diary diary = findById(id);
        diary.setTitle(form.getTitle());
        diary.setContent(form.getContent());
        diary.setLocalDateTime(LocalDateTime.now());
    }
}
