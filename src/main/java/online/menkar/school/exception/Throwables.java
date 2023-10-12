package online.menkar.school.exception;

import java.util.function.Function;

/**
 * This class holds util functionality related to throwables and its hierarchies.
 */
public final class Throwables {
  // No instantiation.
  private Throwables() {
    throw new InstantiationError();
  }

  /**
   * Perform a value-collecting operation on an auto-closeable instance.
   *
   * @param objectCollector {@link ThrowingCollectible collectible} used to retrieve the instance in question from.
   * @param function {@link ThrowingFunction throwing function} to be performed for the resulting value.
   * @param defaultFunc {@link Function function} to invoke in cases where a throwable was raised while collecting a result.
   * @return {@link Result} collected result.
   * @param <Param> type of parameter.
   * @param <Result> type of resulting object.
   */
  public static <Param extends AutoCloseable, Result> Result use(ThrowingCollectible<Param> objectCollector,
                                                                 ThrowingFunction<Param, Result> function,
                                                                 Function<Throwable, Result> defaultFunc) {
    try (final var object = objectCollector.collect()) {
      return function.collect(object);
    } catch (Throwable throwable) {
      return defaultFunc.apply(throwable);
    }
  }
}