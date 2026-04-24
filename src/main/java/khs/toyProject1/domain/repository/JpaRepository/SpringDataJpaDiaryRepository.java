package khs.toyProject1.domain.repository.JpaRepository;

import khs.toyProject1.domain.diary.Diary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaDiaryRepository extends JpaRepository<Diary, Long> {


}
