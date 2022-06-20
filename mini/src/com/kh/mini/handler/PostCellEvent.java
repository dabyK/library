package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.kh.mini.controller.BoardController;
import com.kh.mini.controller.BookController;
import com.kh.mini.model.vo.Book;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;
import com.kh.mini.view.BookClick;
import com.kh.mini.view.PostClick;

public class PostCellEvent extends MouseAdapter {

	private JPanel now;
	private JFrame main;
	private Member m; //���� ������ ���
	private JTable table; //�Խñ� ����� ���� ���̺�
	private HashMap<String, SBoard> boards; //�Խñ۵��� ����Ǿ� �ִ� boards��

	public PostCellEvent(JPanel now, JFrame main, Member m, JTable table, HashMap<String, SBoard> boards) {
		super();
		this.now = now;
		this.main = main;
		this.m = m;
		this.table = table;
		this.boards = boards;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		super.mouseClicked(e);
		if (e.getClickCount() == 2) {// ����Ŭ���� ����
			int row = table.getSelectedRow(); // ���� ���̺��� ���õ� �� ��ȣ�� �޾ƿ�

			String writenum = (String) table.getValueAt(row, 0); // (�ش� ��,0)�� ��(�Խñ� ��ȣ)�� ������ �޾ƿ�
			SBoard sb = new BoardController().ClickBoard(boards, writenum); // �Խñ��� ����� �ʰ�, �Խñ� ��ȣ�� ������ �ش��ϴ� ���� ������
																			// sb��ü�� �ҷ���

			JDialog post = new PostClick(now, main, m, sb, boards, row, table);// ���� ��ȸ�ϴ� �˾� ȣ��
			post.setVisible(true);

		}

	}

}
