package com.nyekhul.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tb_master_kelas")
public class Kelas {
	@Id
	public int idKelas;
	public String namaKelas;
	public String tahunAjaran;
	public int semester;
	
	public Kelas() {
		// TODO Auto-generated constructor stub
	}

	public int getIdKelas() {
		return idKelas;
	}

	public void setIdKelas(int idKelas) {
		this.idKelas = idKelas;
	}

	public String getNamaKelas() {
		return namaKelas;
	}

	public void setNamaKelas(String namaKelas) {
		this.namaKelas = namaKelas;
	}

	public String getTahunAjaran() {
		return tahunAjaran;
	}

	public void setTahunAjaran(String tahunAjaran) {
		this.tahunAjaran = tahunAjaran;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
	
}
