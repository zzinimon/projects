package com.example.myapp.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(of = "line")

@Entity(name = "line")
public class LineVO {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "line")
	private String line;
	
	@OneToMany(fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL, 
			mappedBy = "line")
	Collection<StationVO> station = new ArrayList<StationVO>();
	
}
