package com.training.makerchecker.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the statuscodes database table.
 * 
 */
@Entity
@Table(name="statuscodes")
@NamedQuery(name="Statuscode.findAll", query="SELECT s FROM Statuscode s")
public class Statuscode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String codes;

	@Column(name="status_names")
	private String statusNames;

	public Statuscode() {
	}

	public String getCodes() {
		return this.codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

	public String getStatusNames() {
		return this.statusNames;
	}

	public void setStatusNames(String statusNames) {
		this.statusNames = statusNames;
	}

}