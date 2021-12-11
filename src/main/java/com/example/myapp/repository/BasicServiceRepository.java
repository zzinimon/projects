package com.example.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myapp.entity.BasicServiceVO;

@Repository
public interface BasicServiceRepository extends JpaRepository<BasicServiceVO, Long> {

	BasicServiceVO findByStationId(int stationID);

}
