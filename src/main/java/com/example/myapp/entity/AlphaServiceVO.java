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
@Entity(name = "alpha_service")
public class AlphaServiceVO {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//지하철역코드 외래키
	//@Column(name="station_id", unique = true)
	//private int stationId;
	
	@ManyToOne(targetEntity = StationVO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "station_id")
	private StationVO station;
	
	//API에서 받아올 데이터
	@Column(name="bicycleCount")
	private int bicycleCount;
	
	@Column(name="meetingPlace")
	private int meetingPlace;
	
	@Column(name="handicapCount")
	private int handicapCount;

	//후에 추가할 데이터
	@Column(name="nursingRoom")
	private int nursingRoom;

	@Column(name="minwon")
	private int minwon;

	@Override
	public String toString() {
		return "AlphaServiceVO [id=" + id + ", bicycleCount=" + bicycleCount + ", meetingPlace=" + meetingPlace
				+ ", handicapCount=" + handicapCount + ", nursingRoom=" + nursingRoom + ", minwon=" + minwon + "]";
	}
	
}

