package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.BoardController;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;
import com.kh.mini.view.NoAccess;

public class PostRemoveH extends MouseAdapter {
	private JPanel now;
	private JFrame main;
	private Member m; //���� ������ ���
	private SBoard sb; //���� Ŭ���� �Խñ�
	private HashMap<String, SBoard> boards; //�Խñ۵��� map
	private JDialog dialog; //�����˾�(�Խñ��� ����Ŭ���ϸ� ������ �Խñ� ��ȸ �˾�)
	private int row; //���̺� ���� �Խñ��� �ش��ϴ� ���ȣ 
	private JTable table; //�Խñ۵��� �ִ� ���� ���̺�

	public PostRemoveH(JPanel now, JFrame main, Member m, SBoard sb, HashMap<String, SBoard> boards, JDialog dialog,
			int row, JTable table) {
		super();
		this.now = now;
		this.main = main;
		this.m = m;
		this.sb = sb;
		this.boards = boards;
		this.dialog = dialog;
		this.row = row;
		this.table = table;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		super.mouseClicked(e);
		boolean yn = new BoardController().removePost(m, sb, boards, table, row);
		// �Խñ��� ������ ��, ���������� �����ƴٸ� true �ƴ϶�� false�� ��ȯ���ִ� �޼ҵ�

		if (yn == false) { // ������ �����ߴٸ�
			JDialog na = new NoAccess(now, main); // �������� �޽����� ���� �˾��� ȣ��
			na.setVisible(true);
		}
		dialog.dispose();// �ƴ϶�� ���� �˾�â�� ����

	}

}
