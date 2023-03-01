package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SachBao implements Serializable {
	private int maSach;
	private String tenSach;
	private TheLoai theLoai;
	private boolean tinhTrang;
	private Date thoiGianXuatBan;
	private String tenTacGia;

	public SachBao() {
	}

	public SachBao(int maSach, String tenSach, TheLoai theLoai, boolean tinhTrang, Date thoiGianXuatBan,
			String tenTacGia) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.theLoai = theLoai;
		this.tinhTrang = tinhTrang;
		this.thoiGianXuatBan = thoiGianXuatBan;
		this.tenTacGia = tenTacGia;
	}

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public TheLoai getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(TheLoai theLoai) {
		this.theLoai = theLoai;
	}

	public boolean isTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Date getThoiGianXuatBan() {
		return thoiGianXuatBan;
	}

	public void setThoiGianXuatBan(Date thoiGianXuatBan) {
		this.thoiGianXuatBan = thoiGianXuatBan;
	}

	public String getTenTacGia() {
		return tenTacGia;
	}

	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}

	@Override
	public String toString() {
		return "SachBao [maSach=" + maSach + ", tenSach=" + tenSach + ", theLoai=" + theLoai + ", tinhTrang="
				+ tinhTrang + ", thoiGianXuatBan=" + thoiGianXuatBan + ", tenTacGia=" + tenTacGia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSach, tenSach, tenTacGia, theLoai, thoiGianXuatBan, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SachBao other = (SachBao) obj;
		return maSach == other.maSach && Objects.equals(tenSach, other.tenSach)
				&& Objects.equals(tenTacGia, other.tenTacGia) && Objects.equals(theLoai, other.theLoai)
				&& Objects.equals(thoiGianXuatBan, other.thoiGianXuatBan) && tinhTrang == other.tinhTrang;
	}

}