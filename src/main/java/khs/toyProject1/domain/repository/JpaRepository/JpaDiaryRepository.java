package khs.toyProject1.domain.repository.JpaRepository;

import khs.toyProject1.domain.diary.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDiaryRepository extends JpaRepository<Diary, Long> {
}
