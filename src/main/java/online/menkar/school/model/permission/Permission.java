package online.menkar.school.model.permission;

import jakarta.persistence.AttributeConverter;
import online.menkar.school.shared.Flagged;

import java.util.EnumSet;
import java.util.Set;

/**
 * This enumeration holds values that represent different flags
 * and accessibility points.
 */
public enum Permission implements Flagged {
  // administrative strategy (all permissions)
  WILDCARD;

  /**
   * Array of cached {@link Permission} values.
   */
  private static final Permission[] VALUES = values();

  /**
   * @see Flagged#flag()
   */
  @Override
  public int flag() {
    return 1 << ordinal();
  }

  /**
   * This class handles the attribute conversion of a set of permissions from and to respective flags.
   */
  public static final class Converter implements AttributeConverter<Set<Permission>, Long> {
    @Override
    public Long convertToDatabaseColumn(Set<Permission> attribute) {
      long flags = 0;
      if (attribute == null)
        return flags;

      for (final var permission : attribute) {
        if (permission == null)
          continue;
        flags |= permission.flag();
      }
      return flags;
    }

    @Override
    public Set<Permission> convertToEntityAttribute(Long dbData) {
      final var permissions = EnumSet.noneOf(Permission.class);
      if (dbData == null)
        return permissions;

      for (final var permission : VALUES) {
        if ((dbData & permission.flag()) != 0)
          permissions.add(permission);
      }
      return permissions;
    }
  }
}