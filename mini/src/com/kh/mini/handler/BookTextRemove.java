package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BookTextRemove extends MouseAdapter {

	private JTextField name; //å�� �˻��ϴ� textField
	private JPanel now; //���� �ǳ�
	private JFrame main; //���� ������

	public BookTextRemove(JTextField name, JPanel now, JFrame main) {
		super();
		this.name = name;
		this.now = now;
		this.main = main;
	}

	@Override
	public void mousePressed(MouseEvent e) {

		super.mousePressed(e);

		name.setText(""); // Ŭ���ϴ� ���� �˻�â(TextField)�� �����ִ� ������ ���ֹ���(""�� ����)
	}

}
