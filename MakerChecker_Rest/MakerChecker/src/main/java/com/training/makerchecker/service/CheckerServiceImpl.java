package com.training.makerchecker.service;

import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.makerchecker.exception.MakerCheckerException;
import com.training.makerchecker.exception.MakerCheckerResponse;
import com.training.makerchecker.model.Checker;
import com.training.makerchecker.model.Maker;
import com.training.makerchecker.repository.CheckerRepository;
import com.training.makerchecker.repository.MakerRepository;
import com.training.makerchecker.specification.CheckerSpecification;
import com.training.makerchecker.utility.ResponseCodes;
import com.training.makerchecker.utility.ResponseMessages;
import com.training.makerchecker.vo.CheckerVO;

@Service
@Transactional(readOnly = true)
public class CheckerServiceImpl implements CheckerService {
	@Autowired
	CheckerRepository checkerRepo;
	
	@Autowired
	MakerRepository makerRepo;

	


	@Override
	public MakerCheckerResponse getApprovedRequest() throws MakerCheckerException {
		try {

			List<Checker> checker = checkerRepo.findByStatus("A");
			if (checker != null && checker.size() > 0) {
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(),
						ResponseMessages.getApprovedRecords, checker);
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

			List<Checker> checker = checkerRepo.findByStatus("R");
			if (checker != null && checker.size() > 0) {
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(),
						ResponseMessages.getRejectedRecord, checker);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(),
						ResponseMessages.getRejectedRecordError, null);

			}

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}




	@Override
	public MakerCheckerResponse delete(Long id) throws MakerCheckerException {
		// TODO Auto-generated method stub
		try {
			Checker checker = checkerRepo.findOneById(id);
			checkerRepo.delete(checker);

			return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(), ResponseMessages.delete,
					checker);

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	}

	@Transactional
	@Override
	public MakerCheckerResponse updateStatus(CheckerVO checker) throws MakerCheckerException {
		
		try {
			Maker	maker = makerRepo.findByCustomerId(checker.getCustomerId());
			Checker check = checkerRepo.findByCustomerId(checker.getCustomerId());
					System.out.println(checker.getCustomerId());
					System.out.println(checker.getStatus());

			if (checker != null) {
				check.setStatus(checker.getStatus());
				check.setAuthorizedBy("checker");
				check.setAuthorizedDate(new Date());
				check = checkerRepo.save(check);
				maker.setStatus(checker.getStatus());
				maker.setAuthorizedBy("checker");
				maker.setAuthorizedDate(new Date());
                makerRepo.save(maker);
				return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(), ResponseMessages.makerSave,
						checker);
			} else {
				return new MakerCheckerResponse(ResponseCodes.Error.getResponseCode(), ResponseMessages.makerSaveError,
						checker);

			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public MakerCheckerResponse getCheckerSearch(CheckerVO criteria) throws MakerCheckerException{
		try {
			Specification<Checker> specification= (Specification<Checker>) CheckerSpecification.getAuditDetailSpecification(criteria);
			List<Checker> checker=checkerRepo.findAll(specification);

			return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(), ResponseMessages.findAllRecords,
					checker);

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
	
	
	}

	@Override
	public MakerCheckerResponse save(Checker checker) throws MakerCheckerException {
		try {
		Checker checkerSave=	checkerRepo.save(checker);

			return new MakerCheckerResponse(ResponseCodes.Success.getResponseCode(), ResponseMessages.findAllRecords,
					checkerSave);

		} catch (Exception ex) {
			throw new MakerCheckerException("Exception Occured, Please contact admin", 500);
		}
		
	}

}
