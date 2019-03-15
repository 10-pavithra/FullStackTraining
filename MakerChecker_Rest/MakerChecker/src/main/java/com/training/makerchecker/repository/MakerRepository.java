package com.training.makerchecker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.training.makerchecker.model.Maker;


@Repository
public interface MakerRepository extends JpaRepository<Maker, Long>,JpaSpecificationExecutor<Long> {
	
	public Maker findByCustomerId(Long id);
	public List<Maker> findByStatus(String status);
	public Maker findOneById(Long id);
	

}
