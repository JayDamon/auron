package com.protean.security.auron.repository;

import com.protean.security.auron.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    Company findByCompanyName(String companyName);

}
