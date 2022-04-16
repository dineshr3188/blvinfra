package com.example.demo.controller;

import java.util.Collection;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.User;
import com.example.demo.repository.IService;
import com.example.demo.repository.UserRepository;

public class UserServiceImpl implements IService<User> {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {

		return userRepository.findById(id);
	}

	@Override
	public User saveorUpdate(User t) {

		return userRepository.saveAndFlush(t);
	}

	@Override
	public String deleteById(Long id) {

		JSONObject jsonObject = new JSONObject();
		try {
			userRepository.deleteById(id);
			jsonObject.put("message", "user deleted successfully");
			
		}catch(JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
		
	}

}
