package online.menkar.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import online.menkar.school.model.permission.Permissible;

/**
 * This entity model holds information about user ranks.
 */
@Entity
@Table(name = "ranks")
public class Rank extends Permissible<Rank> {
  // name of the rank
  @Column(nullable = false, length = 32)
  private String name;

  /**
   * Declared for the sake of Hibernate.
   */
  public Rank() {
    // no-op
  }

  /**
   * Set the rank name.
   *
   * @param name {@link String} new name to be set.
   * @return {@link Rank} current instance.
   */
  public synchronized Rank setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get the rank name.
   *
   * @return {@link String}
   */
  public String name() {
    return this.name;
  }
}