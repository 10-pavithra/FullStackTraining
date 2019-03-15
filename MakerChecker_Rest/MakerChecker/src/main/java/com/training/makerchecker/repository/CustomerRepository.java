package com.training.makerchecker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.training.makerchecker.model.Checker;
import com.training.makerchecker.model.Customer;
import com.training.makerchecker.model.Maker;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>,JpaSpecificationExecutor<Long> {
	
	public Customer findByCustomerId(Long id);
	public Customer findOneById(Long id);


}
