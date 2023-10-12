package online.menkar.school.model;

import jakarta.persistence.*;
import online.menkar.school.shared.DatedEntity;

import java.util.UUID;

/**
 * This entity model holds information about user authentication tokens.
 */
@Entity
@Table(name = "auth_tokens")
public class AuthToken extends DatedEntity {
  // authentication token at hand
  @Id
  @GeneratedValue
  private UUID token;

  // user in which this authentication token belongs to
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  /**
   * Declared for the sake of Hibernate.
   */
  public AuthToken() {
    // no-op
  }

  /**
   * Set the token.
   *
   * @param token {@link UUID} new token to be set.
   * @return {@link AuthToken} current instance.
   */
  public synchronized AuthToken setToken(UUID token) {
    this.token = token;
    return this;
  }

  /**
   * Set the user in which this token is bound to.
   *
   * @param user {@link User} the user to bind this token to.
   * @return {@link AuthToken} current instance.
   */
  public synchronized AuthToken setUser(User user) {
    this.user = user;
    return this;
  }

  /**
   * Get the token.
   *
   * @return {@link UUID}
   */
  public UUID token() {
    return this.token;
  }

  /**
   * Get the user that this token belongs to.
   *
   * @return {@link User}
   */
  public User user() {
    return this.user;
  }
}