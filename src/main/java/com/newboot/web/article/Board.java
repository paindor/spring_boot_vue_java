package com.newboot.web.article;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name = "BOARD")
@Data
@Component
public class Board {
	
	@Id
	@GeneratedValue
	@Column(name="brdnum" , length = 6,  nullable=false) 	private String brdnum;
	@Column(name="brddate" , length = 10,  nullable=false) private String brddate;
	@Column(name="title" , length = 8,  nullable=false) private String title;
	@Column(name="cnum" , length = 100,  nullable=false) 	private String cnum;
	@Column(name="content" , length = 3000,  nullable=false) private String content;
	@Column(name="url1" , length = 200,  nullable=true) private String url1;
	@Column(name="url2" , length = 200,  nullable=true) private String url2;
	@Column(name="url3" , length = 200,  nullable=true) private String url3;
	@Column(name="url4" , length = 200,  nullable=true) private String url4;
	@Column(name="url5" , length = 200,  nullable=true) private String url5;
	@Column(name="pnum" , length = 6,  nullable=false) private String bpoint;
    
}