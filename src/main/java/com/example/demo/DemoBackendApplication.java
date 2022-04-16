package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.repository.UserRepository;
import com.example.demo.security.Authority;


@SpringBootApplication


public class DemoBackendApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoBackendApplication.class, args);
	}
	
	@PostConstruct
	protected void init() {
		//List<Authority> authorityList =new ArrayList<>();
//		authorityList.add(createAuthority("USER","User role"));
//		authorityList.add(createAuthority("ADMIN","Admin role"));
//		
//		User user = new User();
//		user.setUserName("Dinesh");
//		user.setEnabled(true);
//		user.setMobile("8951915344");
//		user.setPassword(passwordEncoder.encode("player@10"));
//		user.setAuthorities(authorityList);
//		userRepository.save(user);
	}
	
	
	private Authority createAuthority(String roleCode, String roleDescription) {
		Authority authority= new Authority();
		authority.setRoleCode(roleCode);
		authority.setRoleDescription(roleDescription);
		return authority;
	}

}
