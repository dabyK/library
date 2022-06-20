package com.kh.mini.handler;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.BookController;
import com.kh.mini.model.vo.Book;

public class BookSearchMouse extends MouseAdapter {

	private JPanel now; //���� �ǳ�
	private DefaultTableModel dtm; //���̺� ��(���̺� �ٲ��ֱ� ���� ���)
	private JFrame main; //���� ������
	private JComboBox<String> genre; //�˻��ϰ��� �ϴ� å�� �帣�� �����ϴ� �޺��ڽ�
	private JTextField name; //å �̸��� �˻��ϴ� textField â
	private JTable table; //å ����� �ִ� ���̺�

	public BookSearchMouse(JFrame main, JPanel now, DefaultTableModel dtm, JComboBox<String> genre, JTextField name,
			JTable table) {
		super();
		this.now = now;
		this.dtm = dtm;
		this.main = main;
		this.genre = genre;
		this.name = name;
		this.table = table;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		BookController b = new BookController();
		ArrayList<Book> booklist = null;

		try {
			booklist = b.searchBook((String) genre.getSelectedItem(), name.getText());
			// list�� ���� ���õ� �帣��, TextField�˻�â�� �����ִ� å �̸��� �ش��ϴ� å ������ ����
		} catch (Exception x) {
			x.printStackTrace();
		}
		String[] cl = { "�帣", "������", "����", "���ǻ�" }; // ���̺��� �� �� ���� �������

		String[][] content = new String[booklist.size()][4];// ���̺��� �Ʒ� ���(å ��ϵ�)�� ������� //å�� ������ŭ �� ������ �Ҵ�
		for (int i = 0; i < booklist.size(); i++) {
			content[i][0] = booklist.get(i).getGenre(); // 0���� �� �ึ�� �帣�� �־��ش�.
			content[i][1] = booklist.get(i).getbName(); // 1���� �� �ึ�� å�̸� �־��ش�.
			content[i][2] = booklist.get(i).getbWriter(); // 2���� �� �ึ�� ���� �־��ش�.
			content[i][3] = booklist.get(i).getPu(); // 3���� �� �ึ�� ���ǻ� �־��ش�.
		}

		dtm.setDataVector(content, cl);
		table.setModel(dtm);// ������ ��� ���̺��� �������

		table.getColumnModel().getColumn(0).setPreferredWidth(10); // 0���� ���̸� 10���� ����
		table.getColumnModel().getColumn(1).setPreferredWidth(300); // 1���� ���̸� 10���� ����
		table.getColumnModel().getColumn(2).setPreferredWidth(10); // 2���� ���̸� 10���� ����
		table.getColumnModel().getColumn(3).setPreferredWidth(10); // 3���� ���̸� 10���� ����
		table.setFont(new Font("����", Font.PLAIN, 15)); // ���̺��� ��Ʈ ���¸� ����

	}

}
