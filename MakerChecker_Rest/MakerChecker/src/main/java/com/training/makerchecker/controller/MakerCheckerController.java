package com.training.makerchecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.makerchecker.exception.MakerCheckerException;
import com.training.makerchecker.exception.MakerCheckerResponse;
import com.training.makerchecker.model.Checker;
import com.training.makerchecker.model.Customer;
import com.training.makerchecker.model.Maker;
import com.training.makerchecker.service.CheckerService;
import com.training.makerchecker.service.CustomerService;
import com.training.makerchecker.service.MakerService;
import com.training.makerchecker.vo.CheckerVO;

@CrossOrigin(origins="http://localhost:4200")

@RestController
public class MakerCheckerController {
	
	@Autowired
	MakerService makerService;
	
	@Autowired
	CheckerService checkerservice;
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/test")
	public String Test(){
		return "Pavithra";
	}
	
	
	@PutMapping(path="/save",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public MakerCheckerResponse save(@RequestBody Maker maker) throws MakerCheckerException{
		return makerService.save(maker);
		
	}
	
	@PostMapping(path="/saveCustomer",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public MakerCheckerResponse customerSave(@RequestBody Customer cust) throws MakerCheckerException{
		return customerService.save(cust);
		
	}
	
	
	@GetMapping(path="/findByCustId/{id}")
	public MakerCheckerResponse findByCustomerId(@PathVariable Long id) throws MakerCheckerException
	{
		
			return customerService.findByCustomerId(id);
		
	}
	@GetMapping(path="/getapprovedRequest")
	public MakerCheckerResponse getApprovedRequest() throws MakerCheckerException{
		return makerService.getApprovedRequest();
	}
	
	@GetMapping(path="/getRejectedRequest")
	public MakerCheckerResponse getRejectedRequest() throws MakerCheckerException{
		return makerService.getRejectedRequest();
	}
	
	@GetMapping(path="/getSubmittedRequest")
	public MakerCheckerResponse getSubmittedRequest() throws MakerCheckerException{
		return makerService.getSubmittedRequest();
	}
	
	@GetMapping(path="/findAll")
	public MakerCheckerResponse findAll() throws MakerCheckerException{
		return makerService.findAll();
	}
	
	@DeleteMapping(path="/delete/{id}")
	public MakerCheckerResponse delete(@PathVariable Long id) throws MakerCheckerException{
		return makerService.delete(id);
	}
	
	@PutMapping(path="/saveCheckerRecord",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public MakerCheckerResponse saveCheckerRecord(@RequestBody Checker checker) throws MakerCheckerException{
		return checkerservice.save(checker);
		
	}
	
	@GetMapping(path="/getCheckerapprovedRequest")
	public MakerCheckerResponse getCheckerapprovedRequest() throws MakerCheckerException{
		return checkerservice.getApprovedRequest();
	}
	
	@GetMapping(path="/getCheckerRejectedRequest")
	public MakerCheckerResponse getCheckerRejectedRequest() throws MakerCheckerException{
		return checkerservice.getRejectedRequest();
	}
	
	@DeleteMapping(path="/deleteCheckerRecord/{id}")
	public MakerCheckerResponse deleteCheckerRecord(@PathVariable Long id) throws MakerCheckerException{
		return checkerservice.delete(id);
	}
	
	@PostMapping(path="/checkerSearch")
	public MakerCheckerResponse getCheckerSearch(@RequestBody CheckerVO criteria) throws MakerCheckerException{
		return checkerservice.getCheckerSearch(criteria);
	}
	
	@PostMapping(path="/updateStatus")
	public MakerCheckerResponse updateStatus(@RequestBody CheckerVO checker) throws MakerCheckerException{
		return checkerservice.updateStatus(checker);
	}
	
}
