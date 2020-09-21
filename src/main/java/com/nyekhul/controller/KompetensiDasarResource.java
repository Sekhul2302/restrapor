package com.nyekhul.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nyekhul.model.KompetensiDasar;
import com.nyekhul.repository.KompetensiDasarRepository;

@RestController
public class KompetensiDasarResource {
	@Autowired
	KompetensiDasarRepository KdRepo;
	
	@GetMapping("/listKD")
	public List<KompetensiDasar>listKd(){
		return (List<KompetensiDasar>) KdRepo.findAll();
	}
	
	@PostMapping("/saveKd")
	public String saveKd(@RequestBody KompetensiDasar kd) {
		Optional<KompetensiDasar>cekKd = KdRepo.findById(kd.getIdKd());
		String message ="";
		if(cekKd.isPresent()) {
			message = "data sudah ada";
		}else {
			KdRepo.save(kd);
			message = "data berhasil disimpan";
		}
		return message;
	}
	
	@DeleteMapping("/deleteKd/{id}")
	public String deleteKd(@PathVariable(value="id")Integer id) {
		Optional<KompetensiDasar>cekKd = KdRepo.findById(id);
		String messaString = "";
		if(cekKd.isPresent()) {
			KdRepo.deleteById(id);
			messaString ="data berhasil dihapus";
		}else {
			messaString="data tidak ada";
		}
		return messaString;
	}
	
	@PutMapping("updateKd/{id}")
	public String updateKd(@PathVariable(value="id") int id ,@Validated @RequestBody KompetensiDasar kd) {
		Optional<KompetensiDasar>cekKd = KdRepo.findById(id);
		String messaString = "";
		if(cekKd.isPresent()) {
			kd.setFlagKd(kd.getFlagKd());
			kd.setIdKd(kd.getIdKd());
			kd.setIdMapel(kd.getIdMapel());
			kd.setKelas(kd.getKelas());
			kd.setKodeKd(kd.getKodeKd());
			kd.setNamaKd(kd.getNamaKd());
			kd.setSemester(kd.getSemester());
			KdRepo.save(kd);
			messaString ="data berhasil dirubah";
		}else {
			messaString="data tidak ada";
		}
		return messaString;
	}
}
