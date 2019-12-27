package com.newboot.web.person;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Entity
@Component
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue
	@Column(name= "ID" , nullable =false) private Long id;
	@Column(name= "USERID" , length=64, nullable =false) 
	private String userid;
	@Column(name= "PASS" , length=64, nullable =false) 
	private String passwd;
	@Column(name= "NAME" , length=64, nullable =false) 
	private String name;
	@Temporal(TemporalType.DATE)
	@Column(name= "BIRTHDAY" , nullable =true) private Date birthday;
	@Column(name= "MALE" ,nullable = false)
	private boolean male;
	@Column(name= "HAK" ,nullable = false)
	private int hak;
	@Column(name= "BAN" ,nullable = false)
	private int ban;
	@Column(name= "SCORE" ,nullable = false)
	private int score;
	@Column(name= "ROLE" ,nullable = false)
	private String role;
	enum Level{HIGH, MID, LOW}
	
	//
	

}
