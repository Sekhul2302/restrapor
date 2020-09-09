package com.nyekhul.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyekhul.model.Guru;
import com.nyekhul.repository.GuruRepository;
import com.nyekhul.services.GuruServices;

@Service("GuruServicesImpl")
public class GuruServicesImpl implements GuruServices {

	@Autowired
	private GuruRepository guruRepo;

	@Override
	public Guru cekDataGuru(int nip) {
		Guru pi = guruRepo.cekData(nip);
		return pi;
	}

}
