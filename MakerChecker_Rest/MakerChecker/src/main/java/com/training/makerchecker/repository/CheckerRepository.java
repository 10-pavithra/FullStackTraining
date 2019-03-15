package com.training.makerchecker.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Check;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.training.makerchecker.model.Checker;
import com.training.makerchecker.model.Maker;



@Repository
public interface CheckerRepository extends JpaRepository<Checker, Long> {
	
	public List<Checker> findByStatus(String status);

	public Checker findOneById(Long id);
	
	public List<Checker> findAll(Specification<Checker> spec);

	public Checker findByCustomerId(Long customerId);
	
	

}
