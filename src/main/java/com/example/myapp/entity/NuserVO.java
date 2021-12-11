package com.example.myapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity(name = "nuser")
public class NuserVO {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nor_id")
	private String norId;
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "nor_email")
	private String norEmail;
	
	@Column(name = "nor_password")
	private String norPassword;
	
}
