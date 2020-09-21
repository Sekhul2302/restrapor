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
import org.springframework.web.bind.annotation.RestController;

import com.nyekhul.model.Kelas;
import com.nyekhul.model.Mapel;
import com.nyekhul.repository.MapelRepository;

@RestController
public class MapelResource {
	@Autowired
	MapelRepository mapelRepo;
	
	@GetMapping("/listMapel")
	public List<Mapel>listMapel(){
		return (List<Mapel>) mapelRepo.findAll();
	}
	
	@PostMapping("/saveMapel")
	public String saveMapel(@Validated @RequestBody Mapel mapel) {
		Optional<Mapel> mapel2 = mapelRepo.findById(mapel.getIdMapel());
		String message = "";
		if(mapel2.isPresent()) {
			message = "Data tersebut sudah ada";
		}else {
			mapelRepo.save(mapel);
			message = "Data berhasil disimpan";
		}
		return message;
	}
	
	@DeleteMapping("/deleteMapel/{id}")
	public String deleteMapel(@PathVariable(value="id") Integer id) {
		Optional<Mapel>cekMapel = mapelRepo.findById(id);
		String message = "";
		if(cekMapel.isPresent()) {
			mapelRepo.deleteById(id);
			message = "data berhasil dihapus";
		}else {
			message ="data tidak ada";
		}
		return message;
	}
	
	@PutMapping("/updateMapel/{id}")
	public String updateMapel(@PathVariable(value = "id") int id ,@Validated @RequestBody Mapel mapel) {
		Optional<Mapel>cekMapel = mapelRepo.findById(id);
		String message = "";
		if(cekMapel.isPresent()) {
			mapel.setIdMapel(mapel.getIdMapel());
			mapel.setKelas(mapel.getKelas());
			mapel.setKelompok(mapel.getKelompok());
			mapel.setKkm(mapel.getKkm());
			mapel.setNamaMapel(mapel.getNamaMapel());
			mapel.setSemester(mapel.getSemester());
			mapel.setThAjaran(mapel.getThAjaran());
			mapelRepo.save(mapel);
			message = "data berhasil di rubah";
		}else {
			message =" id tersebut tidak ada";
		}
		return message;
	}
}
