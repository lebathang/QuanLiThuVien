package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLTVModel;
import model.SachBao;
import model.TheLoai;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLTVController;

import java.awt.event.ActionListener;
import java.beans.Expression;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class QLTVView extends JFrame {

	private JPanel contenPane;
	public QLTVModel model;
	public JPanel contentPane;
	public JTextField textField_TenSachTimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_TenSach;
	public JTextField textField_NgayXuatBan;
	public JTextField textField_tenTacGia;
	public model.TheLoai TheLoai;
	public ButtonGroup buttonGroup;
	public JComboBox comboBox_TheLoaiTimKiem;
	public JComboBox comboBox_TheLoai;
	public JRadioButton rdbtnNewRadioButton_het;
	public JRadioButton rdbtnNewRadioButton_con;
	private JTable model_table;
	private int soLuongDong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLTVView frame = new QLTVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLTVView() {
		this.model = new QLTVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 545);

		Action action = new QLTVController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnFile.add(menuSave);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnFile.add(menuExit);

		JMenu mnAbout = new JMenu("About");
		mnAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnAbout);

		JMenuItem menuAbout_me = new JMenuItem("About me");
		menuAbout_me.addActionListener(action);
		menuAbout_me.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnAbout.add(menuAbout_me);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(445, 10, 0, 0);
		contentPane.add(verticalBox);

		JLabel lblTheLoaiTiemKiem = new JLabel("Thể Loại");
		lblTheLoaiTiemKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTheLoaiTiemKiem.setBounds(20, 10, 78, 31);
		contentPane.add(lblTheLoaiTiemKiem);

		comboBox_TheLoaiTimKiem = new JComboBox();
		ArrayList<model.TheLoai> lisTheLoais = TheLoai.getDSTheLoai();
		comboBox_TheLoaiTimKiem.addItem("");
		for (model.TheLoai theLoai : lisTheLoais) {
			comboBox_TheLoaiTimKiem.addItem(theLoai.getTenTheLoai());
		}

		comboBox_TheLoaiTimKiem.setBounds(108, 10, 170, 31);
		contentPane.add(comboBox_TheLoaiTimKiem);

		JLabel lblTenSachTimKiem = new JLabel("Tên sách");
		lblTenSachTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenSachTimKiem.setBounds(288, 10, 78, 31);
		contentPane.add(lblTenSachTimKiem);

		textField_TenSachTimKiem = new JTextField();
		textField_TenSachTimKiem.setBounds(376, 10, 170, 31);
		contentPane.add(textField_TenSachTimKiem);
		textField_TenSachTimKiem.setColumns(10);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(action);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTimKiem.setBounds(556, 10, 115, 31);
		contentPane.add(btnTimKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 51, 774, 2);
		contentPane.add(separator_1);

		JLabel lblDanhSach = new JLabel("Danh sách các loại sách");
		lblDanhSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDanhSach.setBounds(20, 51, 194, 31);
		contentPane.add(lblDanhSach);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 S\u00E1ch", "T\u00EAn S\u00E1ch", "Th\u1EC3 Lo\u1EA1i", "T\u00ECnh tr\u1EA1ng",
						"Ng\u00E0y xu\u1EA5t b\u1EA3n", "T\u00EAn t\u00E1c gi\u1EA3" }));

		table.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 90, 774, 175);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(20, 275, 774, 2);
		contentPane.add(separator_1_1);

		JLabel lblThongTinSach = new JLabel("Thông tin sách");
		lblThongTinSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblThongTinSach.setBounds(20, 275, 125, 31);
		contentPane.add(lblThongTinSach);

		JLabel lblMaSach = new JLabel("Mã sách");
		lblMaSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaSach.setBounds(20, 314, 78, 31);
		contentPane.add(lblMaSach);

		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(166, 314, 197, 31);
		contentPane.add(textField_ID);

		JLabel lblTenSach = new JLabel("Tên sách");
		lblTenSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenSach.setBounds(20, 355, 78, 31);
		contentPane.add(lblTenSach);

		textField_TenSach = new JTextField();
		textField_TenSach.setColumns(10);
		textField_TenSach.setBounds(166, 355, 197, 31);
		contentPane.add(textField_TenSach);

		JLabel lblTheLoai = new JLabel("Thể Loại");
		lblTheLoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTheLoai.setBounds(20, 396, 78, 31);
		contentPane.add(lblTheLoai);

		comboBox_TheLoai = new JComboBox();
		ArrayList<model.TheLoai> listTheLoais = TheLoai.getDSTheLoai();
		comboBox_TheLoai.addItem("");
		for (model.TheLoai theLoai : listTheLoais) {
			comboBox_TheLoai.addItem(theLoai.getTenTheLoai());
		}
		comboBox_TheLoai.setBounds(166, 396, 197, 31);
		contentPane.add(comboBox_TheLoai);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(20, 437, 774, 2);
		contentPane.add(separator_1_1_1);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(20, 440, 125, 31);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.setBounds(190, 440, 125, 31);
		contentPane.add(btnXoa);

		JButton btnHuyBo = new JButton("Hủy Bỏ");
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyBo.setBounds(669, 440, 125, 31);
		contentPane.add(btnHuyBo);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLuu.setBounds(512, 440, 125, 31);
		contentPane.add(btnLuu);

		JLabel lblNgayXuatBan = new JLabel("Ngày Xuất Bản");
		lblNgayXuatBan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgayXuatBan.setBounds(445, 355, 140, 31);
		contentPane.add(lblNgayXuatBan);

		textField_NgayXuatBan = new JTextField();
		textField_NgayXuatBan.setColumns(10);
		textField_NgayXuatBan.setBounds(595, 355, 199, 31);
		contentPane.add(textField_NgayXuatBan);

		textField_tenTacGia = new JTextField();
		textField_tenTacGia.setColumns(10);
		textField_tenTacGia.setBounds(595, 396, 199, 31);
		contentPane.add(textField_tenTacGia);

		JLabel lblTenTacGia = new JLabel("Tên tác giả");
		lblTenTacGia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenTacGia.setBounds(445, 396, 118, 31);
		contentPane.add(lblTenTacGia);

		rdbtnNewRadioButton_con = new JRadioButton("Còn");
		rdbtnNewRadioButton_con.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_con.setBounds(595, 314, 60, 21);
		contentPane.add(rdbtnNewRadioButton_con);

		JLabel lblTinhTrang = new JLabel("Tình trạng");
		lblTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTinhTrang.setBounds(445, 314, 118, 31);
		contentPane.add(lblTinhTrang);

		rdbtnNewRadioButton_het = new JRadioButton("Hết");
		rdbtnNewRadioButton_het.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton_het.setBounds(669, 314, 60, 21);
		contentPane.add(rdbtnNewRadioButton_het);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton_con);
		buttonGroup.add(rdbtnNewRadioButton_het);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhat.setBounds(356, 440, 125, 31);
		contentPane.add(btnCapNhat);

		JButton btnHuyTimKiem = new JButton("Hủy tìm");
		btnHuyTimKiem.addActionListener(action);
		btnHuyTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuyTimKiem.setBounds(681, 10, 113, 31);
		contentPane.add(btnHuyTimKiem);

		this.setTitle("Chương trình quản lí thư viện");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_TenSach.setText("");
		textField_NgayXuatBan.setText("");
		textField_TenSach.setText("");
		textField_tenTacGia.setText("");
		comboBox_TheLoai.setSelectedIndex(-1);
		buttonGroup.clearSelection();
	}

	public void themSachVaoTable(SachBao sach) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { sach.getMaSach() + "", sach.getTenSach() + "",
				sach.getTheLoai().getTenTheLoai(), (sach.isTinhTrang() ? "Còn" : "Hết"), sach.getTenTacGia() + "",
				sach.getThoiGianXuatBan().getDate() + "/" + (sach.getThoiGianXuatBan().getMonth() + 1) + "/"
						+ (sach.getThoiGianXuatBan().getYear() + 1900), });
	}

	public void themHoacCapNhatSach(SachBao sach) {
		if (!this.model.kiemTraTontai(sach)) {
			this.model.insert(sach);
			this.themSachVaoTable(sach);
		} else {
			this.model.update(sach);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(sach.getMaSach() + "")) {
					model_table.setValueAt(sach.getMaSach() + "", i, 0);
					model_table.setValueAt(sach.getTenSach() + "", i, 1);
					model_table.setValueAt(sach.getTheLoai().getTenTheLoai() + "", i, 2);
					model_table.setValueAt((sach.isTinhTrang() ? "Còn" : "Hết"), i, 3);
					model_table.setValueAt(sach.getTenTacGia() + "", i, 4);
					model_table.setValueAt(
							sach.getThoiGianXuatBan().getDate() + "/" + (sach.getThoiGianXuatBan().getMonth() + 1) + "/"
									+ (sach.getThoiGianXuatBan().getYear() + 1900) + "",
							i, 5);
				}
			}
		}
	}

	public SachBao getSachBaoDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maSach = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenSach = model_table.getValueAt(i_row, 1) + "";
//		TheLoai theloai = TheLoai.getTheLoaiById(model_table.getValueAt(i_row,2));
		TheLoai theLoai = TheLoai.getTheLoaiByTen(model_table.getValueAt(i_row, 2) + "");
		String textTinhTrang = model_table.getValueAt(i_row, 3) + "";
		boolean tinhTrang = textTinhTrang.equals("Hết");
		String TenTacGia = String.valueOf(model_table.getValueAt(i_row, 4) + "");
		String s_ngayXuatBan = model_table.getValueAt(i_row, 5) + "";
		Date NgayXuatBan = new Date(s_ngayXuatBan);

		SachBao sach = new SachBao();
		return sach;
	}

	public void hienThiThongTinSachDaChon() {
		// TODO Auto-generated method stub

		SachBao sach = getSachBaoDangChon();

		this.textField_ID.setText(sach.getMaSach() + "");
		this.textField_TenSach.setText(sach.getTenSach());
		this.comboBox_TheLoai.setSelectedItem(sach.getTheLoai().getTenTheLoai());
		String s_ngayXuatBan = sach.getThoiGianXuatBan().getDate() + "/" + (sach.getThoiGianXuatBan().getMonth() + 1)
				+ "/" + (sach.getThoiGianXuatBan().getYear() + 1900);
		this.textField_NgayXuatBan.setText(s_ngayXuatBan + "");
		if (sach.isTinhTrang()) {
			rdbtnNewRadioButton_het.setSelected(true);
		} else {
			rdbtnNewRadioButton_con.setSelected(true);
		}
		this.textField_tenTacGia.setText(sach.getTenTacGia() + "");

	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa dòng đã chọn");
		if (luaChon == JOptionPane.YES_OPTION) {
			SachBao sach = getSachBaoDangChon();
			this.model.delete(null);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThemSachBao() {
		// get du lieu
		int maSach = Integer.valueOf(this.textField_ID.getText());
		String tenSach = this.textField_TenSach.getText();
		int theLoai = this.comboBox_TheLoai.getSelectedIndex() - 1;
		TheLoai theloai = TheLoai.getTheLoaiById(theLoai);
		boolean tinhTrang = true;
		if (this.rdbtnNewRadioButton_het.isSelected()) {
			tinhTrang = true;
		} else if (this.rdbtnNewRadioButton_con.isSelected()) {
			tinhTrang = false;
		}
		String TenTacGia = String.valueOf(this.textField_tenTacGia.getText());
		Date NgayXuatBan = new Date(this.textField_NgayXuatBan.getText());

//		Date NamXuatBan = Date.valueOf(this.view.textField_NgayXuatBan.getText()+);

		SachBao sach = new SachBao(maSach, tenSach, theloai, tinhTrang, NgayXuatBan, TenTacGia);
		this.themHoacCapNhatSach(sach);
	}

	public void thucHienTim() {
		// Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();

		// Goi ham tim kiem
		int theLoai = this.comboBox_TheLoaiTimKiem.getSelectedIndex() - 1;
		String tenSB = this.textField_TenSachTimKiem.getText();
		Set<Integer> idCuaSachCanXoa = new TreeSet<Integer>();
		TheLoai theloaiDaChon = TheLoai.getTheLoaiById(theLoai);
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		if (theLoai >= 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String tenTheLoai = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!(tenTheLoai.equals(theloaiDaChon.getTenTheLoai()))) {
					idCuaSachCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (tenSB.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String tenSachTrongTable = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (tenSachTrongTable.indexOf(tenSB) < 0) {
					idCuaSachCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaSachCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}

	}

	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (SachBao sb : this.model.getDsSachBao()) {
			this.themSachVaoTable(sb);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thư viện version 1.0");
	}

	public void thoatKhoiChuongTrinh() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát khỏi chương trình ?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (SachBao sb : this.model.getDsSachBao()) {
				oos.writeObject(sb);
			}
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void thucHienSaveFile() {
		if (this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	public void openFile(File file) {
		ArrayList<SachBao> ds = new ArrayList<>();

		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			SachBao sb = null;
			while ((sb = (SachBao) ois.readObject()) != null) {
				ds.add(sb);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsSachBao(ds);
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		}
	}
}