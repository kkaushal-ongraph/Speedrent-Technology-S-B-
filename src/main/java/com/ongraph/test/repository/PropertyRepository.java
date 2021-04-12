package com.ongraph.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.ongraph.test.models.Property;

@Repository
public interface PropertyRepository extends JpaSpecificationExecutor<Property>, JpaRepository<Property, Long>{

}
