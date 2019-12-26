package com.newboot.web.person;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.newboot.web.util.Printer;

import javafx.scene.input.DataFormat;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Printer printer;
	@Autowired
	private Person person;
	@Autowired
	ModelMapper modelMapper;
	@Bean
	public ModelMapper modelMapper() { return new ModelMapper();}
	
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getName()+" "));
		return sb.toString();
	}
	
	
	@PostMapping("/login")
	public HashMap<String,Object> login(@RequestBody Person param) {
		HashMap<String,Object> map = new HashMap<>();
		printer.accept("로그인 진입");
		printer.accept(String.format("USERID: %s", param.getUserid()));
		printer.accept(String.format("PASSWD: %s", param.getPasswd()));
		person = personRepository.findByUseridAndPasswd(
				param.getUserid(), 
				param.getPasswd());
		if(person != null) {
			printer.accept("로그인 성공");
			map.put("result", "SUCCESS");
			map.put("person", person);
		}else {
			printer.accept("로그인 실패");
			map.put("result", "FAIL");
			map.put("result", person);
		}
		return map;
	}
	@PostMapping("/join")
	public String join(@RequestBody Person param) {
		person = new Person();
		person.setUserid(param.getUserid());
		person.setPasswd(param.getPasswd());
		person.setName(param.getName());
		try {
			person.setBirthday(df.parse("2000-10-10"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printer.accept(param.getUserid());
		personRepository.save(param);
		
		return "success";
		
	}
	@DeleteMapping("/withdrawal/{userid}")
	public void withdrawal(@PathVariable String userid) {
		printer.accept("탈퇴");
		
		personRepository
		.delete(personRepository
				.findByUserid(userid));
	}
	@PostMapping("/modify")
	public String modify(@RequestBody Person param) {
		printer.accept("in the modify");
		System.out.println(param.getUserid());
		printer.accept(param.getGender());
		
		personRepository.save(param);
		
		return "success";
		
	}
	@GetMapping("/students")
	public Stream<PersonDTO> list(){
		Iterable<Person> entites = personRepository.findAll();
		List<PersonDTO> list = new ArrayList<PersonDTO>();
		
		for(Person p : entites) {
			PersonDTO dto = modelMapper.map(p, PersonDTO.class);
			list.add(dto);
			
			
		}
		printer.accept("list: " +list.size());
		return list.stream().
				filter(role-> role.getRole().equals("student"));
		
		//Iterable<Person> entites=personRepository.findByRole("student");
	}
}