package online.menkar.school.repository;

import online.menkar.school.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds data-repository functionality for {@link Department departments}.
 */
@Repository
public interface DepartmentRepository
  extends JpaRepository<Department, Integer> { }