package online.menkar.school.model;

import jakarta.persistence.*;
import online.menkar.school.shared.AutoIncrementalIdentity.DepartmentBound;

import java.time.LocalDate;

/**
 * This entity model holds information about users.
 */
@Entity
@Table(name = "users")
public class User extends DepartmentBound<User> {
  // user's real first name
  @Column(nullable = false, length = 32)
  private String firstName;

  // user's real last name
  @Column(nullable = false, length = 32)
  private String lastName;

  // the birthdate of respective user
  @Column(nullable = false)
  private LocalDate birthdate;

  // user's login and contact email
  @Column(nullable = false, length = 64)
  private String email;

  // user's login password in hashed format
  @Column(name = "password", nullable = false)
  private String hashedPassword;

  // type of user
  @Column(nullable = false)
  private Type type;

  // joined rank of this user
  @ManyToOne
  @JoinColumn(name = "rank_id")
  private Rank rank;

  /**
   * Declared for the sake of Hibernate.
   */
  public User() { }

  /**
   * Set the user's first name.
   *
   * @param firstName {@link String} new name to be set.
   * @return {@link User} current instance.
   */
  public synchronized User setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Set the user's last name.
   *
   * @param lastName {@link String} new name to be set.
   * @return {@link User} current instance.
   */
  public synchronized User setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Set the user's birthdate.
   *
   * @param birthdate {@link LocalDate} the new birthdate to be set.
   * @return {@link User} current instance.
   */
  public synchronized User setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Set the user's email.
   *
   * @param email {@link String} new email to be set.
   * @return {@link User} current instance.
   */
  public synchronized User setEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Set the user's hashed password.
   *
   * @param hashedPassword {@link String} password to be set in hashed form.
   * @return {@link User} current instance.
   */
  public synchronized User setHashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
    return this;
  }

  /**
   * Set the type of user this is.
   *
   * @param type {@link Type} new type of user to be set.
   * @return {@link User} current instance.
   */
  public synchronized User setType(Type type) {
    this.type = type;
    return this;
  }

  /**
   * Set the rank of the current user.
   *
   * @param rank {@link Rank} new rank assign this user to.
   * @return {@link User} current instance.
   */
  public synchronized User setRank(Rank rank) {
    this.rank = rank;
    return this;
  }

  /**
   * Get the user's real first name.
   *
   * @return {@link String}
   */
  public String firstName() {
    return this.firstName;
  }

  /**
   * Get the user's real last name.
   *
   * @return {@link String}
   */
  public String lastName() {
    return this.lastName;
  }

  /**
   * Get the user's date of birth.
   *
   * @return {@link LocalDate}
   */
  public LocalDate birthdate() {
    return this.birthdate;
  }

  /**
   * Get the email bound to this user.
   *
   * @return {@link String}
   */
  public String email() {
    return this.email;
  }

  /**
   * Get the password of this user in hashed form.
   *
   * @return {@link String}
   */
  public String hashedPassword() {
    return this.hashedPassword;
  }

  /**
   * Get the type of user this is.
   *
   * @return {@link Type}
   */
  public Type type() {
    return this.type;
  }

  /**
   * Get the rank of which this user is assigned to.
   *
   * @return {@link Rank}
   */
  public Rank rank() {
    return this.rank;
  }

  /**
   * Get whether this user has been assigned to any rank.
   *
   * @return {@link Boolean} true if they have, false otherwise.
   */
  public boolean hasRank() {
    return rank != null;
  }

  /**
   * Get whether this user is a lecturee.
   *
   * @return {@link Boolean} true if they are, false otherwise.
   */
  public boolean isLecturee() {
    return type == Type.LECTUREE;
  }

  /**
   * Get whether this user is a lecturer.
   *
   * @return {@link Boolean} true if they are, false otherwise.
   */
  public boolean isLecturer() {
    return type == Type.LECTURER;
  }

  /**
   * Get whether this user is neither a lecturer nor a lecturee.
   *
   * @return {@link Boolean} true if they are, false otherwise.
   */
  public boolean isOther() {
    return type == Type.OTHER;
  }

  /**
   * Available types of users.
   */
  public enum Type { LECTUREE, LECTURER, OTHER }
}