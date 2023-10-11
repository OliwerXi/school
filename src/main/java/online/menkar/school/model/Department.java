package online.menkar.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import online.menkar.school.shared.AutoIncrementalIdentity;

/**
 * This entity model holds information relative to a department.
 * For example <code>private</code> and <code>public</code> school departments.
 */
@Entity
@Table(name = "departments")
public class Department extends AutoIncrementalIdentity {
  // name of the department
  @Column(nullable = false, length = 32)
  private String name;

  /**
   * Declared for the sake of Hibernate.
   */
  public Department() {
    // no-op
  }

  /**
   * Set the department name.
   *
   * @param name {@link String} new name to be set.
   * @return {@link Department} current instance.
   */
  public synchronized Department setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get the department name.
   *
   * @return {@link String}
   */
  public String name() {
    return this.name;
  }
}