package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class TheLoai implements Serializable {
	private int STTTheLoai;
	private String TenTheLoai;

	public TheLoai(int sTTTheLoai, String tenTheLoai) {
		super();
		STTTheLoai = sTTTheLoai;
		TenTheLoai = tenTheLoai;
	}

	public int getSTTTheLoai() {
		return STTTheLoai;
	}

	public void setSTTTheLoai(int sTTTheLoai) {
		STTTheLoai = sTTTheLoai;
	}

	public String getTenTheLoai() {
		return TenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		TenTheLoai = tenTheLoai;
	}

	@Override
	public String toString() {
		return "TheLoai [STTTheLoai=" + STTTheLoai + ", TenTheLoai=" + TenTheLoai + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(STTTheLoai, TenTheLoai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheLoai other = (TheLoai) obj;
		return STTTheLoai == other.STTTheLoai && Objects.equals(TenTheLoai, other.TenTheLoai);
	}

	public static ArrayList<TheLoai> getDSTheLoai() {
		String[] arr_TheLoai = { "Sách chính trị", "Sách pháp luật", "Sách kinh tế", "Sách khoa học - công nghệ",
				"Sách văn học - nghệ thuật", "Sách văn hóa - xã hội", "Sách lịch sử", "Sách giáo trình", "Sách truyện",
				"Sách tiểu thuyết", "Sách tâm lý", "Sách tâm linh - tôn giáo", "Sách thiếu nhi",

		};
		ArrayList<TheLoai> listTheLoai = new ArrayList<TheLoai>();
		int i = 0;
		for (String theloai : arr_TheLoai) {
			TheLoai TL = new TheLoai(i, theloai);
			listTheLoai.add(TL);
		}
		return listTheLoai;
	}

	public static TheLoai getTheLoaiById(int theLoai) {
		return TheLoai.getDSTheLoai().get(theLoai);
	}

	public TheLoai getTheLoaiByTen(String tenTheLoai) {
		ArrayList<TheLoai> listTheLoai = TheLoai.getDSTheLoai();
		for (TheLoai theLoai : listTheLoai) {
			if (theLoai.TenTheLoai.equals(TenTheLoai))
				return theLoai;
		}
		return null;
	}

}