package com.nyekhul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyekhul.model.KDSosialSpiritual;
import com.nyekhul.model.Mapel;
import com.nyekhul.repository.KDSosialSpiritualRepository;

@RestController
public class KDSosialSpiritualResource {
	@Autowired
	KDSosialSpiritualRepository KDSSRepo;
	
	@GetMapping("/listKDS")
	public List<KDSosialSpiritual>listKds(){
		return (List<KDSosialSpiritual>) KDSSRepo.findAll();
	}
}
