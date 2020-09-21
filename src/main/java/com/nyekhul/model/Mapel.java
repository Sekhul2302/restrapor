package com.nyekhul.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tb_master_mapel")
public class Mapel {
	@Id
	private int idMapel;
	private String namaMapel;
	private int kkm;
	private int kelas;
	private String semester;
	private String thAjaran;
	private String kelompok;
	
	public Mapel() {
		// TODO Auto-generated constructor stub
	}
	public int getIdMapel() {
		return idMapel;
	}
	public void setIdMapel(int idMapel) {
		this.idMapel = idMapel;
	}
	public String getNamaMapel() {
		return namaMapel;
	}
	public void setNamaMapel(String namaMapel) {
		this.namaMapel = namaMapel;
	}
	public int getKkm() {
		return kkm;
	}
	public void setKkm(int kkm) {
		this.kkm = kkm;
	}
	public int getKelas() {
		return kelas;
	}
	public void setKelas(int kelas) {
		this.kelas = kelas;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getThAjaran() {
		return thAjaran;
	}
	public void setThAjaran(String thAjaran) {
		this.thAjaran = thAjaran;
	}
	public String getKelompok() {
		return kelompok;
	}
	public void setKelompok(String kelompok) {
		this.kelompok = kelompok;
	}
	
	
}
