package khs.toyProject1.domain.repository;

import khs.toyProject1.domain.diary.Diary;
import khs.toyProject1.web.diary.DiaryUpdateForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class DiaryMemoryRepository {

    private static Map<Long, Diary> diaryMap = new HashMap<>();
    private static Long sequance = 0L;

    public Diary save(Diary diary) {
        diary.setId(++sequance);
        diaryMap.put(diary.getId(), diary);
        log.info("saveDiary={}",diary);
        return diary;
    }

    public Diary findById(Long id) {
        return diaryMap.get(id);
    }

    public List<Diary> findAll() {
        return new ArrayList<>(diaryMap.values());
    }

    public void update(Long id, DiaryUpdateForm form) {
        Diary diary = diaryMap.get(id);
        diary.setTitle(form.getTitle());
        diary.setContent(form.getContent());
        diary.setLocalDateTime(form.getLocalDateTime());
    }


}
