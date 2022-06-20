package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookTextRemove extends MouseAdapter {

	private JTextField name; //책을 검색하는 textField
	private JPanel now; //현재 판넬
	private JFrame main; //현재 프레임

	public BookTextRemove(JTextField name, JPanel now, JFrame main) {
		super();
		this.name = name;
		this.now = now;
		this.main = main;
	}

	@Override
	public void mousePressed(MouseEvent e) {

		super.mousePressed(e);

		name.setText(""); // 클릭하는 순간 검색창(TextField)에 적혀있던 내용을 없애버림(""로 만듬)
	}

}
