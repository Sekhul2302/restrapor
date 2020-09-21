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

import com.nyekhul.model.Guru;
import com.nyekhul.model.Kelas;
import com.nyekhul.repository.KelasRepository;

@RestController
public class KelasResource {
	@Autowired
	KelasRepository repoKelas;

	@GetMapping("/dataKelas")
	public List<Kelas> getAllKelas() {
		return (List<Kelas>) repoKelas.findAll();
	}

	@DeleteMapping("/deleteKelas/{id}")
	public String hapusKelas(@PathVariable(value = "id") Integer id) {
		Optional<Kelas> kelas = repoKelas.findById(id);
		String result = "";
		if (kelas.isPresent()) {

			result = "id " + id + " dihapus";
			repoKelas.deleteById(id);
			return result;
		} else {
			result = "nip " + id + " tidak ditemukan";
			return result;
		}
	}

	@PostMapping("/saveKelas")
	public String saveKelas(@Validated @RequestBody Kelas kelas) {
		Optional<Kelas> cekkelas = repoKelas.findById(kelas.getIdKelas());
		String message = "";
		if (cekkelas.isPresent()) {
			message = "Data sudah ada";
		} else {
			message = "Data Berhasil disimpan";
			repoKelas.save(kelas);
		}
		return message;
	}

	@PutMapping("/updateKelas/{id}")
	public String updateKelas(@PathVariable(value = "id") int id, @Validated @RequestBody Kelas kelas) {
		Optional<Kelas> cekkelas = repoKelas.findById(kelas.getIdKelas());
		String message = "";
		if (cekkelas.isPresent()) {
			// message = "Data sudah ada";
			Kelas kelasnya = new Kelas();
			kelasnya.setIdKelas(kelas.getIdKelas());
			kelasnya.setNamaKelas(kelas.getNamaKelas());
			kelasnya.setSemester(kelas.getSemester());
			kelasnya.setTahunAjaran(kelas.getTahunAjaran());
			repoKelas.save(kelasnya);
		} else {
			message = "Id tersebut tidak ada";
		}
		return message;
	}

}
