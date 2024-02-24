package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public void saveCompany(Company company) {
        companyDao.save(company);
    }

    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public List<Company> findCompaniesByPartialName(String partialName) {
        return companyDao.retrieveCompaniesWithNamesContaining(partialName);
    }

    public List<Employee> findEmployeesByPartialName(String partialName) {
        return employeeDao.retrieveEmployeesWithNamesContaining(partialName);
    }
}