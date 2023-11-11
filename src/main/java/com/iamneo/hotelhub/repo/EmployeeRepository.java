package com.iamneo.hotelhub.repo;

import com.iamneo.hotelhub.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findById(long id);
    Employee save(Employee employee);
}
