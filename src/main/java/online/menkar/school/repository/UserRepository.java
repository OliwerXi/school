package online.menkar.school.repository;

import online.menkar.school.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds data-repository functionality for {@link User users}.
 */
@Repository
public interface UserRepository
  extends JpaRepository<User, Integer> { }