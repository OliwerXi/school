package online.menkar.school.model;

import jakarta.persistence.*;
import online.menkar.school.shared.AutoIncrementalIdentity.DepartmentBound;

/**
 * This entity model holds information about department lectures.
 */
@Entity
@Table(name = "lectures")
public class Lecture extends DepartmentBound<Lecture> {
  // name of the department
  @Column(nullable = false, length = 64)
  private String name;

  /**
   * Declared for the sake of Hibernate.
   */
  public Lecture() {
    // no-op
  }

  /**
   * Set the lecture name.
   *
   * @param name {@link String} new name to be set.
   * @return {@link Lecture} current instance.
   */
  public synchronized Lecture setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get the lecture name.
   *
   * @return {@link String}
   */
  public String name() {
    return this.name;
  }
}