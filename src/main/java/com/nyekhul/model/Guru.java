package com.nyekhul.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity(name = "tb_master_guru")
@XmlRootElement
public class Guru {
	@Id
	private int idGuru;
	private String namaGuru;
	private int nip;
	private String password;
	private String role;
	public int getId_guru() {
		return idGuru;
	}
	public void setId_guru(int id_guru) {
		this.idGuru = id_guru;
	}
	public String getNama_guru() {
		return namaGuru;
	}
	public void setNama_guru(String nama_guru) {
		this.namaGuru = nama_guru;
	}
	public int getNip() {
		return nip;
	}
	public void setNip(int nip) {
		this.nip = nip;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Guru [id_guru=" + idGuru + ", nama_guru=" + namaGuru + ", nip=" + nip + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
}
