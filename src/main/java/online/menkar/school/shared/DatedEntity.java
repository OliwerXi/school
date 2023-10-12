package online.menkar.school.shared;

import jakarta.persistence.Access;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import static jakarta.persistence.AccessType.FIELD;

/**
 * This layer holds the base of an entity with a creation date.
 */
@MappedSuperclass
@Access(FIELD)
public class DatedEntity {
  // date and time of when the entity was created
  @Column(nullable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  /**
   * Mere accessibility declaration.
   */
  protected DatedEntity() { }

  /**
   * Get the time of when the respective entity was created at.
   *
   * @return {@link LocalDateTime}
   */
  public LocalDateTime createdAt() {
    return this.createdAt;
  }
}