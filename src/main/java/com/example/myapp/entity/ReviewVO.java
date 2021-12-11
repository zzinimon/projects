package com.example.myapp.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity(name = "review")
public class ReviewVO {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "rv_content")
	private String rvContent;
	
	@Column(name = "rv_status")
	private boolean rvStatus;
	
	@Column(name = "rv_writer")
	private String rvWriter;
	
	@Column(name = "rv_date")
	private Date rvDate;
	
	//지하철역코드 외래키
	//@Column(name = "station_id", unique = true)
	//private int stationId;
	
	@ManyToOne(targetEntity = StationVO.class, cascade = CascadeType.ALL)
	private StationVO station;
	
}
