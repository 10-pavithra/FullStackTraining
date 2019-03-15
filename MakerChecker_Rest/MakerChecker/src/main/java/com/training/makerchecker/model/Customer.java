package com.training.makerchecker.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name="customer")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="customer_email", length=50)
	private String customerEmail;

	@Column(name="customer_id")
	private Long customerId;

	@Column(name="customer_name", length=50)
	private String customerName;

	@Column(name="customer_phone")
	private Long customerPhone;

	@Column(name="customer_score")
	private Long customerScore;

	@Column(name="cutomer_addres")
	private String cutomerAddres;

	@Id
    @SequenceGenerator(allocationSize = 1, name = "customer_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
	private Long id=0L;

	@Column(name="loan_amount")
	private Long loanAmount;

	@Column(name="loan_tenure")
	private Long loanTenure;

	@Column(name="loan_type", length=15)
	private String loanType;

	public Customer() {
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(Long customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Long getCustomerScore() {
		return this.customerScore;
	}

	public void setCustomerScore(Long customerScore) {
		this.customerScore = customerScore;
	}

	public String getCutomerAddres() {
		return this.cutomerAddres;
	}

	public void setCutomerAddres(String cutomerAddres) {
		this.cutomerAddres = cutomerAddres;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLoanAmount() {
		return this.loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Long getLoanTenure() {
		return this.loanTenure;
	}

	public void setLoanTenure(Long loanTenure) {
		this.loanTenure = loanTenure;
	}

	public String getLoanType() {
		return this.loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

}