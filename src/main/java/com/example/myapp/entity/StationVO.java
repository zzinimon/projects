package com.example.myapp.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity(name = "station")
public class StationVO {

	@Id
	@Column(name = "id")
	private long id;		//stationID

	//@Column(name = "line_id")
	//private int line;

	@Column(name = "lane_name")
	private String laneName;

	@Column(name = "tel")
	private String tel;

	@Column(name = "address")
	private String address;

	@Column(name = "station_name")
	private String stationName;

	@Column(name = "new_address")
	private String newAddress;

	@OneToMany(fetch = FetchType.LAZY, 
				cascade = CascadeType.ALL, 
				mappedBy = "station")
	Collection<ReviewVO> reviews = new ArrayList<ReviewVO>();
	
	@OneToMany(fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL, 
			mappedBy = "station")
	Collection<BuserVO> busers = new ArrayList<BuserVO>();

	@ManyToOne(cascade = CascadeType.ALL)
	private LineVO line;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "id", insertable = false, updatable = false)
	private AlphaServiceVO aService;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "id", insertable = false, updatable = false)
	private BasicServiceVO bService;

	@Override
	public String toString() {
		return "StationVO [id=" + id + ", laneName=" + laneName + ", tel=" + tel + ", address=" + address
				+ ", stationName=" + stationName + ", newAddress=" + newAddress + ", line=" + line + "]";
	}

}
