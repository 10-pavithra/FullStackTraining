package com.training.makerchecker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	MakerService makerService;

	@Autowired
	MakerRepository makerRepo;
	
	@Autowired
	CheckerService checkerService;
	
	@Autowired
	CheckerRepository checkerRepo;

	@Transactional
	public MakerCheckerResponse save(Customer cust) throws MakerCheckerException {
		try {
			Customer custSave;
			Maker maker = new Maker();
			Checker checker = new Checker();
			if (cust != null) {

				custSave = customerRepo.save(cust);

				maker.setActive("Y");
				maker.setStatus("N");
				maker.setCreatedBy("khhq391");
				checker.setActive("Y");
				checker.setStatus("N");
				checker.setCreatedBy("khhq391");
				if (cust.getId() > 0){
				Maker	makerTemp = makerRepo.findByCustomerId(cust.getCustomerId());
				
				Checker	checkerTemp = checkerRepo.findByCustomerId(cust.getCustomerId());
				maker.setId(makerTemp.getId());
				checker.setId(checkerTemp.getId());
					maker.setModifiedDate(new Date());
					maker.setModifiedBy("admin");
					checker.setModifiedDate(new Date());
					checker.setModifiedBy("admin");
					maker.setCustomerId(cust.getCustomerId());
					maker.setCreatedDate(makerTemp.getCreatedDate());
					maker.setCreatedBy(makerTemp.getCreatedBy());
					checker.setCustomerId(cust.getCustomerId());
					checker.setCreatedDate(checkerTemp.getCreatedDate());
					checker.setCreatedBy(checkerTemp.getCreatedBy());

				}

				else{
					maker.setCreatedDate(new Date());
				maker.setCustomerId(cust.getCustomerId());
				maker.setCreatedBy("khhq391");
				checker.setCreatedDate(new Date());
				checker.setCustomerId(cust.getCustomerId());
				checker.setCreatedBy("khhq391");
				}
				makerService.save(maker);
				checkerService.save(checker);

				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(), ResponseMessages.makerSave,
						cust);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(), ResponseMessages.makerSaveError,
						cust);

			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}

	}

	@Override
	public MakerCheckerResponse findAll() throws MakerCheckerException {
		// TODO Auto-generated method stub
		try {

			List<Customer> cust = customerRepo.findAll();
			if (cust != null && cust.size() > 0) {
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(),
						ResponseMessages.findAllRecords, cust);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(),
						ResponseMessages.findAllRecordsError, null);

			}

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}

	@Override
	public MakerCheckerResponse delete(Long id) throws MakerCheckerException {
		// TODO Auto-generated method stub
		try {

			Customer cust = customerRepo.findByCustomerId(id);
			if (cust != null) {
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(),
						ResponseMessages.findAllRecords, cust);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(),
						ResponseMessages.findAllRecordsError, null);

			}

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}

	@Override
	public MakerCheckerResponse findByCustomerId(Long id) throws MakerCheckerException {
		try {

			Customer cust = customerRepo.findByCustomerId(id);
			if (cust != null) {
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(),
						ResponseMessages.findAllRecords, cust);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(),
						ResponseMessages.findAllRecordsError, null);

			}

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}

}
