package net.javaguides.springmvc.helloworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springmvc.helloworld.model.HelloWorld;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<HelloWorld, Integer> {

}
