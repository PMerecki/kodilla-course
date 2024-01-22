package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.lastname = :LASTNAME")
    List<Employee> retrieveEmployeesWithLastname(@Param("LASTNAME") String lastname);

    @Query("SELECT e FROM Employee e WHERE e.lastname LIKE CONCAT('%', :ARG, '%') OR e.firstname LIKE CONCAT('%', :ARG, '%')")
    List<Employee> retrieveEmployeesWithNamesContaining(@Param("ARG") String nameFragment);
}