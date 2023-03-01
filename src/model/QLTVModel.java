package model;

import java.util.ArrayList;

public class QLTVModel {
	private ArrayList<SachBao> dsSachBao;
	private String luaChon;
	private String tenFile;

	public QLTVModel() {
		this.dsSachBao = new ArrayList<SachBao>();
		this.luaChon = "";
		this.tenFile = "";
	}

	public QLTVModel(ArrayList<SachBao> dsSachBao) {
		this.dsSachBao = dsSachBao;
	}

	public ArrayList<SachBao> getDsSachBao() {
		return dsSachBao;
	}

	public void setDsSachBao(ArrayList<SachBao> dsSachBao) {
		this.dsSachBao = dsSachBao;
	}

	public void insert(SachBao sachBao) {
		this.dsSachBao.add(sachBao);
	}

	public void delete(SachBao sachBao) {
		this.dsSachBao.remove(sachBao);
	}

	public void update(SachBao sachBao) {
		this.dsSachBao.remove(sachBao);
		this.dsSachBao.add(sachBao);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public boolean kiemTraTontai(SachBao sach) {
		for (SachBao sachBao : dsSachBao) {
			if (sachBao.getMaSach() == sach.getMaSach())
				return true;
		}
		return false;
	}

}