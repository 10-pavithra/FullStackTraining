package com.training.makerchecker.service;

import com.training.makerchecker.exception.MakerCheckerException;
import com.training.makerchecker.exception.MakerCheckerResponse;
import com.training.makerchecker.model.Maker;

public interface MakerService  {
	
	public MakerCheckerResponse save(Maker maker) throws MakerCheckerException;
	public MakerCheckerResponse findByCustomerId(Long id) throws MakerCheckerException;
	public MakerCheckerResponse getApprovedRequest() throws MakerCheckerException;
	public MakerCheckerResponse getRejectedRequest() throws MakerCheckerException;
	public MakerCheckerResponse getSubmittedRequest() throws MakerCheckerException;
	public MakerCheckerResponse findAll() throws MakerCheckerException;
	public MakerCheckerResponse delete(Long id) throws MakerCheckerException;

}
