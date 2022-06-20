package com.kh.mini.controller;

import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.model.dao.SBoardDB;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;

public class BoardController {

	public SBoard ClickBoard(HashMap<String, SBoard> boards, String num) {// �Խñ��� ����� �ʰ� �Խñ� ��ȣ�� �޾ƿ�
		// �Խñ��� ��ȸ�� �� �ֵ��� �����ִ� �޼ҵ�
		// ������ �ʰ� ����(�Խñ� ��ȣ)�� ����, �Խñ��� Ŭ���� ����
		// �Խñ�map���� �� �Խñ� ��ȣ(key)�� �ش��ϴ� board��ü(��)�� �������ֱ�
		return boards.get(num);

	}

	public boolean removePost(Member m, SBoard sb, HashMap<String, SBoard> boards, JTable table, int row) {
		// �������ִ� �������, Ŭ���� �Խñ�, �Խñ��� ����� ��, ���� �Խñ��� ������ִ� ���̺�, Ŭ���� ���� ��ȣ�� �޾ƿ�

		// �Խñ��� ������ ��, �۾� ����� �����Ϸ��� ����� ������ Ȯ�����ְ� /
		// �����ߴٸ� ������ ���¸� ���Ͽ� �����ϰ�
		// ���̺� �ݿ��ϴ� �޼ҵ�

		if (sb.getWriter().equals(m.getId())) {// �۾� �����, ������ �õ��� ����� ���ٸ�
			boards.remove(sb.getNum(), sb);// �� �� ��ȣ�� �ش��ϴ� ���� �ʿ��� �����ض�

			new SBoardDB().saveMapBoard(boards);// �ش� ���� ������ ���� ���Ͽ� ������(����)
			DefaultTableModel model = (DefaultTableModel) table.getModel();// ���� ���̺� ���¸� �ҷ��ͼ�
			model.removeRow(row);// ������ �õ��� ���� ���� ���̺��� �����ض�(���̺��� ���� �����ض�)
		} else {
			return false;
		}
		return true;

	}
}
