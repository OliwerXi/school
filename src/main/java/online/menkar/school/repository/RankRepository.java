package online.menkar.school.repository;

import online.menkar.school.model.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds data-repository functionality for {@link Rank ranks}.
 */
@Repository
public interface RankRepository
  extends JpaRepository<Rank, Integer> { }