package com.davcharl.f11.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taxpayer")
public class TaxPayer {

	@Id
	@Column(name="ppsn_id")
	private String ppsn;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="date_of_birth")
	private LocalDate dob;
	@Column(name="email")
	private String email;
	@Column(name="xml_location")
	private String locationOfPreviousReturn;
	
	public TaxPayer() {
		
	}
	
	public TaxPayer(String ppsn, String firstName, String lastName, LocalDate dob, String email, String locationOfPreviousReturn) {
		this.ppsn = ppsn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.locationOfPreviousReturn = locationOfPreviousReturn;
	}

	public String getPpsn() {
		return ppsn;
	}

	public void setPpsn(String ppsn) {
		this.ppsn = ppsn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public String getEmail() {
		return email;
	}

	public void setDob(String email) {
		this.email = email;
	}

	public String getLocationOfPreviousReturn() {
		return locationOfPreviousReturn;
	}

	public void setLocationOfPreviousReturn(String locationOfPreviousReturn) {
		this.locationOfPreviousReturn = locationOfPreviousReturn;
	}

	@Override
	public String toString() {
		return "TaxPayer [ppsn=" + ppsn + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", email=" + email + ", locationOfPreviousReturn=" + locationOfPreviousReturn + "]";
	}
	
	
	
}
