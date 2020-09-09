package com.nyekhul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nyekhul.model.Guru;

public interface GuruRepository extends CrudRepository<Guru, Integer> {
	//Guru findAlienById(int id);
	@Query("FROM tb_master_guru where nama_guru like %:namaGuru%")
	List<Guru> findGuruBynamaGuru(String namaGuru);
	
//	List<Guru> findByName(String nama);
//
//	@Query("FROM alien ORDER BY NAME ASC")
//	List<Guru> urutByNamane(String query);
}
