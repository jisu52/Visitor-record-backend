package com.pcsgpl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "visitor_record")
public class Visitor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "visitor_id")
	private int id;
	
	@Column(name = "name")
	private String visitorName ;
	
	@Column(name = "address")
	private String visitorAddress;
	
	@Column(name = "entry-time")
	private int visitorEntryTime;
	
	
	@Column(name = "outing-time")
	private int visitorOutingTime;
	
	@Column(name = "contractors")
	private String contractors;
	
	@Column(name = "purpose")
	private String vistingPurpose;
	
	@Column(name = "phone")
	private int phone;
	
	public Visitor() {
		super();
	}
	
	public Visitor(int id ,String visitorName, String visitorAddress, int visitorEntryTime, int visitorOutingTime, String contractors, String vistingPurpose, int phone) {
		
		this.id = id;
		this.visitorName = visitorName;
		this.visitorAddress = visitorAddress;
		this.visitorEntryTime = visitorEntryTime;
		this.visitorOutingTime = visitorOutingTime;
		this.contractors = contractors;
		this.vistingPurpose = vistingPurpose;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getVisitorAddress() {
		return visitorAddress;
	}

	public void setVisitorAddress(String visitorAddress) {
		this.visitorAddress = visitorAddress;
	}

	public int getVisitorEntryTime() {
		return visitorEntryTime;
	}

	public void setVisitorEntryTime(int visitorEntryTime) {
		this.visitorEntryTime = visitorEntryTime;
	}

	public int getVisitorOutingTime() {
		return visitorOutingTime;
	}

	public void setVisitorOutingTime(int visitorOutingTime) {
		this.visitorOutingTime = visitorOutingTime;
	}

	public String getContractors() {
		return contractors;
	}

	public void setContractors(String contractors) {
		this.contractors = contractors;
	}

	public String getVistingPurpose() {
		return vistingPurpose;
	}

	public void setVistingPurpose(String vistingPurpose) {
		this.vistingPurpose = vistingPurpose;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
}

