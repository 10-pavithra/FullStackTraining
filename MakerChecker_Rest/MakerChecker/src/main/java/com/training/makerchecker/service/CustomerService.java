package com.training.makerchecker.service;

import com.training.makerchecker.exception.MakerCheckerException;
import com.training.makerchecker.exception.MakerCheckerResponse;
import com.training.makerchecker.model.Customer;
import com.training.makerchecker.model.Maker;

public interface CustomerService  {
	
	public MakerCheckerResponse save(Customer maker) throws MakerCheckerException;
	public MakerCheckerResponse findAll() throws MakerCheckerException;
	public MakerCheckerResponse delete(Long id) throws MakerCheckerException;
public MakerCheckerResponse findByCustomerId(Long id) throws MakerCheckerException;
}
