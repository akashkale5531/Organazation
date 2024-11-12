package com.organazation.system.Repository;

import com.organazation.system.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findBySalaryBetween(double startSal, double endSal);
}
