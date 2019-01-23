package com.lojaKolossal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lojaKolossal.domain.Categoria;
import com.lojaKolossal.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> cat = repo.findById(id);
		return cat.orElse(null);
		
	}

}
