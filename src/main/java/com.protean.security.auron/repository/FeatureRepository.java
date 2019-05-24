package com.protean.security.auron.repository;

import com.protean.security.auron.model.Company;
import com.protean.security.auron.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {

}
