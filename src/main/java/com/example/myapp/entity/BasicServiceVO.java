package com.example.myapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "basic_service")
public class BasicServiceVO {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//지하철역코드 외래키
	//@Column(name = "station_id", unique = true)
	//private int stationId;
	
	@ManyToOne(targetEntity = StationVO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "station_id")
	private StationVO station;
	
	//API에서 받아올 데이터
	@Column(name = "restroom")
	private int restroom;
	
	@Column(name = "offDoor")
	private int offDoor;
	
	@Column(name = "crossOver")
	private int crossOver;

	@Column(name = "publicPlace")
	private int publicPlace;
	
	@Column(name = "parkingCount")
	private int parkingCount;
	
	@Column(name = "civilCount")
	private int civilCount;

	@Override
	public String toString() {
		return "BasicServiceVO [id=" + id + ", restroom=" + restroom + ", offDoor=" + offDoor + ", crossOver="
				+ crossOver + ", publicPlace=" + publicPlace + ", parkingCount=" + parkingCount + ", civilCount="
				+ civilCount + "]";
	}
	
}

