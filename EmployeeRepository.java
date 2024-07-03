package com.Registration.RegistrationAndLogin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Registration.RegistrationAndLogin.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByLoginIdAndPassword(String loginId, String password);

}
