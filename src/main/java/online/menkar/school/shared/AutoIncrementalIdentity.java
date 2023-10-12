package online.menkar.school.shared;

import jakarta.persistence.*;
import online.menkar.school.model.Department;

import static jakarta.persistence.AccessType.FIELD;

/**
 * This layer holds the base of an auto-incremental identity.
 */
@MappedSuperclass
@Access(FIELD)
public class AutoIncrementalIdentity extends DatedEntity {
  // identifier of this object
  @Id
  @GeneratedValue
  private int id;

  /**
   * Mere accessibility declaration.
   */
  protected AutoIncrementalIdentity() { }

  /**
   * Get the identifier of this identifiable object.
   *
   * @return {@link Integer}
   */
  public int id() {
    return this.id;
  }

  /**
   * An {@link AutoIncrementalIdentity} layer with a bound (<i>joined</i>) {@link Department} parent.
   *
   * @param <I> the implementing type.
   */
  @MappedSuperclass
  @Access(FIELD)
  public static class DepartmentBound<I extends DepartmentBound<I>> extends AutoIncrementalIdentity {
    // the joined department of which this identity object was bound to
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    /**
     * Mere accessibility declaration.
     */
    protected DepartmentBound() { }

    /**
     * Set the parent department of this identity object.
     *
     * @param department {@link Department} new department to bind this object to.
     * @return {@link I} current implementation instance.
     */
    public synchronized I setDepartment(Department department) {
      this.department = department;
      return (I) this;
    }

    /**
     * Get the parent department.
     *
     * @return {@link Department}
     */
    public Department department() {
      return this.department;
    }
  }
}