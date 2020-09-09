package com.nyekhul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nyekhul.model.Guru;
import com.nyekhul.repository.GuruRepository;
import com.nyekhul.services.GuruServices;

@RestController
public class GuruResource {
	@Autowired
	GuruRepository repo;
	
	@Autowired
	GuruServices guruService;

	@GetMapping("/")
	public List<Guru> getAllAliens() {

		return (List<Guru>) repo.findAll();
	}
	
	@GetMapping("/findByName")
	public List<Guru> findGuruByName(@RequestParam(value = "nama_guru") String nama_guru){
		return (List<Guru>) repo.findGuruBynamaGuru(nama_guru);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Guru> getGuruById(@PathVariable("id") int id) {
		Guru guru = repo.findBynip(id);
		if (guru == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(guru);
	}

	@PostMapping("/")
	public Guru tambahAlien(@Validated @RequestBody Guru guru) {
		Guru gurune = null;
		try {
			gurune = guruService.cekDataGuru(guru.getNip());
			if(gurune == null) {
				return repo.save(guru);
			}else {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
    
//	@PutMapping("/{id}")
//	public ResponseEntity<Guru> updateBuku(@PathVariable(value = "id") Integer id,
//			@Validated @RequestBody Guru detailAlien) {
//		Guru alien = repo.findAlienById(id);
//		if (alien == null)
//			return ResponseEntity.notFound().build();
//		alien.setId(detailAlien.getId());
//		alien.setName(detailAlien.getName());
//		alien.setPoint(detailAlien.getPoint());
//		Guru updatedAlien = repo.save(alien);
//		return ResponseEntity.ok(updatedAlien);
//	}

//	@DeleteMapping("/{id}")
//	public String deleteBuku(@PathVariable(value = "id") Integer id) {
//		Guru alien = repo.findAlienById(id);
//		String result = "";
//		if (alien == null) {
//			result = "id " + id + " tidak ditemukan";
//			return result;
//		}
//		result = "id " + id + " berhasil di hapus";
//		repo.delete(alien);
//		return result;
//	}

//	@GetMapping("/sortname")
//	public List<Guru> sortbuku(@RequestParam(value = "name") String name) {
//		System.out.println(name);
//		return repo.findByName(name);
//	}
//
//	@GetMapping("/urutin")
//	public List<Guru> urutByName(String query) {
//		return (List<Guru>) repo.urutByNamane(query);
//	}
}
