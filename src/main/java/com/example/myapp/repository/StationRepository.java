package com.example.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapp.entity.StationVO;

@Repository
public interface StationRepository extends JpaRepository<StationVO, Long> {

	//StationVO findByStationId(long stationID);
	
}
