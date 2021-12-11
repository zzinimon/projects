package com.example.myapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity(name = "buser")
public class BuserVO {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "com_id")
	private String comId;
	
	@Column(name = "com_name")
	private String comName;
	
	@Column(name = "com_num", unique = true)
	private String comNum;
	
	@Column(name = "com_password")
	private String comPassword;
	
	@Column(name = "com_logo")
	private String comLogo;
	
	//지하철역코드 외래키
	@ManyToOne(cascade = CascadeType.ALL)
	private StationVO station;
	
	//@Column(name = "gate_number")
	//private int gateNumber;
	
}
