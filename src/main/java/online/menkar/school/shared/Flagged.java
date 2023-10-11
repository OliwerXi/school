package online.menkar.school.shared;

/**
 * This interface represents an object that can be represented as a flag.
 */
public interface Flagged {
  /**
   * Retrieve the flag representation of the current object.
   *
   * @return {@link Integer}
   */
  int flag();
}