package com.example.JPAParametersAreNonnullByDefault.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleModelRepository extends JpaRepository<SimpleModel, Long> {

	SimpleModel findTopByBusinessKey(@Param("businessKey") String businessKey);
	
}
