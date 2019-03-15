package com.training.makerchecker.service;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.runner.ReactiveWebApplicationContextRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.makerchecker.exception.MakerCheckerException;
import com.training.makerchecker.exception.MakerCheckerResponse;
import com.training.makerchecker.model.Checker;
import com.training.makerchecker.model.Customer;
import com.training.makerchecker.model.Maker;
import com.training.makerchecker.repository.CheckerRepository;
import com.training.makerchecker.repository.CustomerRepository;
import com.training.makerchecker.repository.MakerRepository;
import com.training.makerchecker.utility.ResponseCodes;
import com.training.makerchecker.utility.ResponseMessages;

@Service
@Transactional(readOnly = true)
public class MakerServiceImpl implements MakerService {
	@Autowired
	MakerRepository makerRepo;
	
	@Autowired
	CheckerRepository checkerRepo;
	
	@Autowired
	CustomerRepository custRepo;

	
@Transactional
	public MakerCheckerResponse save(Maker maker) throws MakerCheckerException {
		try {
			if (maker != null) {
				maker = makerRepo.save(maker);
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(), ResponseMessages.makerSave,
						maker);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(), ResponseMessages.makerSaveError,
						maker);

			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}

	}

	@Override
	public MakerCheckerResponse findByCustomerId(Long id) throws MakerCheckerException {
		try {
			if (id != null) {
				Maker maker = makerRepo.findByCustomerId(id);
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(),
						ResponseMessages.findByCustomer, maker);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(),
						ResponseMessages.findByCustomerError, null);

			}

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}

	@Override
	public MakerCheckerResponse getApprovedRequest() throws MakerCheckerException {
		try {

			List<Maker> maker = makerRepo.findByStatus("A");
			if (maker != null && maker.size() > 0) {
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(),
						ResponseMessages.getApprovedRecords, maker);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(),
						ResponseMessages.getApprovedRecordsError, null);

			}

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}

	@Override
	public MakerCheckerResponse getRejectedRequest() throws MakerCheckerException {
		// TODO Auto-generated method stub
		try {

			List<Maker> maker = makerRepo.findByStatus("R");
			if (maker != null && maker.size() > 0) {
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(),
						ResponseMessages.getRejectedRecord, maker);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(),
						ResponseMessages.getRejectedRecordError, null);

			}

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}

	@Override
	public MakerCheckerResponse getSubmittedRequest() throws MakerCheckerException {
		// TODO Auto-generated method stub
		try {

			List<Maker> maker = makerRepo.findByStatus("S");
			if (maker != null && maker.size() > 0) {
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(),
						ResponseMessages.getSubmittedRecords, maker);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(),
						ResponseMessages.getSubmittedRecordsError, null);

			}

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}

	@Override
	public MakerCheckerResponse findAll() throws MakerCheckerException {
		// TODO Auto-generated method stub
		try {

			List<Maker> maker = makerRepo.findAll();
			if (maker != null && maker.size() > 0) {
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(),
						ResponseMessages.findAllRecords, maker);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(),
						ResponseMessages.findAllRecordsError, null);

			}

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}

	@Transactional
	@Override
	public MakerCheckerResponse delete(Long id) throws MakerCheckerException {
		// TODO Auto-generated method stub
		try {
			Maker maker = makerRepo.findByCustomerId(id);
			Checker checker= checkerRepo.findByCustomerId(id);
			Customer customer= custRepo.findByCustomerId(id);
			
			makerRepo.delete(maker);
			checkerRepo.delete(checker);
			custRepo.delete(customer);
			return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(), ResponseMessages.delete,
					maker);

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}

}
