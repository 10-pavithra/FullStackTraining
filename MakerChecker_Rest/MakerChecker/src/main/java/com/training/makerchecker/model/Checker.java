package com.training.makerchecker.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;


/**
 * The persistent class for the checker database table.
 * 
 */
@Entity
@Table(name="checker")
@NamedQuery(name="Checker.findAll", query="SELECT c FROM Checker c")
public class Checker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=1)
	private String active;

	@Column(name="authorized_by")
	private String authorizedBy;

	
	@Temporal(TemporalType.DATE)
	@Column(name="authorized_date")
	private Date authorizedDate;

	@Column(name="created_by")
	private String createdBy;

	@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	@Column(name="customer_id")
	private Long customerId;

	@Id
    @SequenceGenerator(allocationSize = 1, name = "checker_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checker_sequence")
	private Long id;

	@Column(name="modified_by")
	private String modifiedBy;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="modified_date")
	private Date modifiedDate;

	@Column(length=1)
	private String status;

	public Checker() {
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getAuthorizedBy() {
		return this.authorizedBy;
	}

	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}

	public Date getAuthorizedDate() {
		return this.authorizedDate;
	}

	public void setAuthorizedDate(Date authorizedDate) {
		this.authorizedDate = authorizedDate;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}