package online.menkar.school.exception;

/**
 * This functional interface represents a function of which
 * can throw exceptions upon collecting attempt.
 *
 * @param <Parameter> type of the parameter.
 * @param <Result> type of resulting object.
 */
@FunctionalInterface
public interface ThrowingFunction<Parameter, Result> {
  /**
   * Collect the resulting value from the function.
   *
   * @param param {@link Parameter} the parameter passed along for this operation.
   * @return {@link Result}
   */
  Result collect(Parameter param);
}