package com.training.makerchecker.service;

import com.training.makerchecker.exception.MakerCheckerException;
import com.training.makerchecker.exception.MakerCheckerResponse;
import com.training.makerchecker.model.Checker;
import com.training.makerchecker.model.Maker;
import com.training.makerchecker.vo.CheckerVO;

public interface CheckerService  {
	
	public MakerCheckerResponse save(Checker checker) throws MakerCheckerException;
	public MakerCheckerResponse getApprovedRequest() throws MakerCheckerException;
	public MakerCheckerResponse getRejectedRequest() throws MakerCheckerException;
	public MakerCheckerResponse delete(Long id) throws MakerCheckerException;
	public MakerCheckerResponse getCheckerSearch(CheckerVO criteria) throws MakerCheckerException;
	public MakerCheckerResponse updateStatus(CheckerVO checker) throws MakerCheckerException;

}
