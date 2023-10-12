package online.menkar.school.repository;

import online.menkar.school.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * This interface holds data-repository functionality for {@link online.menkar.school.model.User user} {@link AuthToken authentication tokens}.
 */
@Repository
public interface AuthTokenRepository
  extends JpaRepository<AuthToken, UUID> { }