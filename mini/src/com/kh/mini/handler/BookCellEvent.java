package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.kh.mini.controller.BookController;
import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Book;
import com.kh.mini.model.vo.Member;
import com.kh.mini.view.BookClick;

public class BookCellEvent extends MouseAdapter {

	private Member m; //���� ������ ���
	private JTable table; //å��� ���̺� 
	private MemberController mc; 

	public BookCellEvent(JPanel now, JFrame main, Member m, JTable table, MemberController mc) {
		super();
		this.mc = mc;
		this.m = m;
		this.table = table;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);

		if (e.getClickCount() == 2) { // ����Ŭ���ϸ�
			int row = table.getSelectedRow();// ���� ������ �� ��ȣ�� �޾ƿ���
			String bookName = (String) table.getValueAt(row, 1); // (������ ��,1)�� �ִ� ���� bookName������ ����(1���� å�̸����� �ִ� ��)
			Book b = new BookController().clickBook(bookName);// �� �̸��� åDB�� ��Ͽ� �ִٸ� b��ü�� �������ֱ�
			JDialog book = new BookClick(m, b, mc); // ���� ������ �����, memberController��ü, �˻��� å�� ������ ���� �����ϱ��˾��� ȣ��
			book.setVisible(true);
		}

	}

}
