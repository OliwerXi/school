package online.menkar.school.repository;

import online.menkar.school.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds data-repository functionality for {@link Lecture lectures}.
 */
@Repository
public interface LectureRepository
  extends JpaRepository<Lecture, Integer> { }