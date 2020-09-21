package com.nyekhul.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="tb_master_kd_sosial")
public class KDSosialSpiritual {
	@Id
	private int idKd;
	private String kodeKd;
	private String namaKd;
	private String flagKd;
	private int kelas;
	private int semester;
	@Column(name = "tahunAjaran")
	private String tahunAjaran;
	public KDSosialSpiritual() {
		// TODO Auto-generated constructor stub
	}
	public int getIdKd() {
		return idKd;
	}
	public void setIdKd(int idKd) {
		this.idKd = idKd;
	}
	public String getKodeKd() {
		return kodeKd;
	}
	public void setKodeKd(String kodeKd) {
		this.kodeKd = kodeKd;
	}
	public String getNamaKd() {
		return namaKd;
	}
	public void setNamaKd(String namaKd) {
		this.namaKd = namaKd;
	}
	public String getFlagKd() {
		return flagKd;
	}
	public void setFlagKd(String flagKd) {
		this.flagKd = flagKd;
	}
	public int getKelas() {
		return kelas;
	}
	public void setKelas(int kelas) {
		this.kelas = kelas;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getTahunAjaran() {
		return tahunAjaran;
	}
	public void setTahunAjaran(String tahunAjaran) {
		this.tahunAjaran = tahunAjaran;
	}
	
	
}
