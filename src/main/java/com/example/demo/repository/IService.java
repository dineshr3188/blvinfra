package com.example.demo.repository;

import java.util.Collection;
import java.util.Optional;

public interface IService<T> {

	Collection<T> findAll();
	
	Optional<T> findById(Long id);
	
	T saveorUpdate(T t);
	
	String deleteById(Long id);
}
