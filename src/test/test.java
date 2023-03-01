package test;

import javax.swing.UIManager;

import view.QLTVView;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLTVView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}