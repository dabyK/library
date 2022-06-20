package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;
import com.kh.mini.view.BoardMainP;
import com.kh.mini.view.WritePop;

public class BoardWrite extends MouseAdapter {

	private JPanel now; //���� �ǳ�
	private JFrame main; //���� ������
	private Member m; //���� ������ ���
	private HashMap<String, SBoard> boards; //�Խñ۵��� map
	private JTable table; //�Խñ� table

	public BoardWrite(JPanel now, JFrame main, Member m, HashMap<String, SBoard> boards, JTable table) {
		super();
		this.now = now;
		this.main = main;
		this.m = m;
		this.boards = boards;
		this.table = table;

	}

	@Override
	public void mouseClicked(MouseEvent e) {// Ŭ���� ����

		super.mouseClicked(e);
		new WritePop(m, boards, table).setVisible(true);
		// Ŭ���ϸ� writePop �˾�(�۾��� â)�� �����ֱ�

	}

}
