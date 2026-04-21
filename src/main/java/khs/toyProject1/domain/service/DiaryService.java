package khs.toyProject1.domain.service;

import khs.toyProject1.domain.diary.Diary;
import khs.toyProject1.domain.repository.JpaRepository.DiaryRepository;
import khs.toyProject1.web.diary.DiaryUpdateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DiaryService {

//    private final JpaDiaryRepository jpaDiaryRepository;
    private final DiaryRepository repository;

//    public void save(Diary diary) {
//        jpaDiaryRepository.save(diary);
//    }

    public void save(Diary diary) {
        repository.save(diary);
    }

//    public Diary findById(Long id) {
//        Optional<Diary> diary = jpaDiaryRepository.findById(id);
//        if (diary.isPresent()) {
//            return diary.get();
//        } else {
//            throw new IllegalStateException("다이어리 아이디가 없습니다");
//        }
//    }
    public Diary findById(Long id) {
        return repository.findById(id);
    }

//    public List<Diary> findAll() {
//        return jpaDiaryRepository.findAll();
//    }

//    public List<Diary> findAll() {
//        return repository.findAll();
//    }

    public Page<Diary> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }



    public void update(Long id, DiaryUpdateForm  form) {
        repository.update(id,form);
    }

}
