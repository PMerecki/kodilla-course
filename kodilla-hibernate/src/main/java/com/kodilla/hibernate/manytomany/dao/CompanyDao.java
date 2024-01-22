package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(value = "SELECT * FROM COMPANIES WHERE SUBSTRING(COMPANY_NAME, 1, 3) = :PREFIX", nativeQuery = true)
    List<Company> retrieveCompaniesWithNameStarting(@Param("PREFIX") String prefix);

    @Query("SELECT c FROM Company c WHERE c.name LIKE CONCAT('%', :ARG, '%')")
    List<Company> retrieveCompaniesWithNamesContaining(@Param("ARG") String nameFragment);
}