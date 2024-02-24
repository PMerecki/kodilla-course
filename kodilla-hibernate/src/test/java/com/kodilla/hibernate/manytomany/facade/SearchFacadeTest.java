package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchFacadeTest {

    @Autowired
    private SearchFacade searchFacade;

    @Test
    @Transactional
    void shouldFindCompaniesByPartialName() {
        // Given
        Company company1 = new Company("Company ABC");
        Company company2 = new Company("XYZ Company");
        searchFacade.saveCompany(company1);
        searchFacade.saveCompany(company2);

        // When
        List<Company> companies = searchFacade.findCompaniesByPartialName("ABC");

        // Then
        assertEquals(1, companies.size());
        assertEquals("Company ABC", companies.get(0).getName());
    }

    @Test
    @Transactional
    void shouldFindEmployeesByPartialName() {
        // Given
        Employee employee1 = new Employee("John", "Doe");
        Employee employee2 = new Employee("Jane", "Smith");
        searchFacade.saveEmployee(employee1);
        searchFacade.saveEmployee(employee2);

        // When
        List<Employee> employees = searchFacade.findEmployeesByPartialName("John");

        // Then
        assertEquals(1, employees.size());
        assertEquals("John", employees.get(0).getFirstname());
        assertEquals("Doe", employees.get(0).getLastname());
    }
}