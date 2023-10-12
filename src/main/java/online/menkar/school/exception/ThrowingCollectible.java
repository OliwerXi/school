package online.menkar.school.exception;

/**
 * This functional interface represents a throwing collectible.
 *
 * @param <Result> type to be collected.
 */
@FunctionalInterface
public interface ThrowingCollectible<Result> {
  /**
   * Attempt to collect the value.
   *
   * @return {@link Result}
   */
  Result collect() throws Throwable;
}