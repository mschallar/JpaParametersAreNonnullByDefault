package com.example.JPAParametersAreNonnullByDefault.domain;

import javax.annotation.ParametersAreNonnullByDefault;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@ParametersAreNonnullByDefault
public interface SimpleModelRepository2 extends JpaRepository<SimpleModel, Long> {

	SimpleModel findTopByBusinessKey(@Param("businessKey") String businessKey);
	
}
