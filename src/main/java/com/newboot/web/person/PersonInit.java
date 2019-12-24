package com.newboot.web.person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonInit implements ApplicationRunner {
	private PersonRepository personRepository;
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	public PersonInit(PersonRepository repository) {
		this.personRepository = repository;
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		long count = personRepository.count();
		if(count ==0) {
			Person person = null;
			String[][] mtx = {{"hong" , "1", "홍길동" , "1980-01-01"},
					{"kim" , "1" ,"김유신", "1980-05-05"},
					{"park" , "1" ,"박지성", "1981-06-05"},
					{"you" , "1" ,"유라", "1989-09-09"},
					{"go" , "1" ,"고종수", "1989-09-09"},
					{"oh" , "1" ,"오징어", "1989-09-09"},
					{"ma" , "1" ,"마사라", "1989-09-09"},
					{"choi" , "1" ,"최씨", "1989-09-09"},
					{"cho" , "1" ,"조조", "1989-09-09"},
					{"lee" , "1" ,"이도", "1989-09-09"},
					{"no" , "1" ,"노올", "1989-09-09"},
					{"so" , "1" ,"소라", "1989-09-09"},
					{"jung" , "1" ,"정유라", "1989-09-09"},
					{"bono" , "1" ,"보노보노", "1989-09-09"},
					{"hi" , "1" ,"히히", "1989-09-09"},
					{"na" , "1" ,"나나", "1989-09-09"},
					{"ho" , "1" ,"호성", "1989-09-09"}
					};
			
			for(String[] arr : mtx) {
			
					person = new Person();
					person.setUserid(arr[0]);
					person.setPasswd(arr[1]);
					person.setName(arr[2]);
					person.setBirthday(df.parse(arr[3]));
					int a = (int)Math.random() * 2;
					String result = "";
					if(a==1) {
						result = "w";
					}else {
						result = "m";
						
					}
					person.setGender(result);
					person.setHak((int)(Math.random()* 4 )+1);
					person.setBan((int)(Math.random()* 6 )+1);
					person.setScore((int)(Math.random()*100) );
					
					
					
					personRepository.save(person);
				
				
			}
		}
	
	
		
	}

}
