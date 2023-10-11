package online.menkar.school.model.permission;

import jakarta.persistence.*;
import online.menkar.school.shared.AutoIncrementalIdentity;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import static jakarta.persistence.AccessType.FIELD;
import static java.util.Set.of;

/**
 * This layer holds the base of an auto-incremental identity that is also
 * structured to maintain a permissible object, i.e a column of permission flags.
 */
@MappedSuperclass
@Access(FIELD)
public class Permissible<I extends Permissible<I>> extends AutoIncrementalIdentity {
  // set of permissions that this identity holds
  @Column(nullable = false)
  @Convert(converter = Permission.Converter.class)
  private Set<Permission> permissions;

  /**
   * Mere accessibility declaration.
   */
  protected Permissible() { }

  /**
   * Add a collection of permissions to this permissible identity.
   *
   * @param permissions collection of {@link Permission permissions} to be added.
   * @return {@link I} current implementation instance.
   */
  public synchronized I permit(Collection<Permission> permissions) {
    if (permissions != null)
      this.permissions.addAll(permissions);
    return (I) this;
  }

  /**
   * @see Permissible#permit(Collection)
   * @see Set#of(Object[])
   */
  public synchronized I permit(Permission... permissions) {
    return permit(permissions != null ? of(permissions) : null);
  }

  /**
   * Remove a collection of permissions from this permissible identity.
   *
   * @param permissions collection of {@link Permission permissions} to be removed.
   * @return {@link I} current implementation instance.
   */
  public synchronized I prohibit(Collection<Permission> permissions) {
    if (permissions != null)
      this.permissions.removeAll(permissions);
    return (I) this;
  }

  /**
   * @see Permissible#prohibit(Collection)
   * @see Set#of(Object[])
   */
  public synchronized I prohibit(Permission... permissions) {
    return prohibit(permissions != null ? of(permissions) : null);
  }

  /**
   * Get whether this permissible identity can perform a certain operation
   * depending on the provided permission.
   *
   * @param permission {@link Permission} the permission to check for.
   * @return {@link Boolean} true if they can, false otherwise.
   */
  public boolean hasPermission(Permission permission) {
    return permissions.contains(permission);
  }

  /**
   * Get a copy of the internal permission collection.
   *
   * @return {@link Set}
   */
  public Set<Permission> permissions() {
    return EnumSet.copyOf(permissions);
  }
}