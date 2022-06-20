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
	private Member m; //현재 접속한 사람
	private SBoard sb; //현재 클릭한 게시글
	private HashMap<String, SBoard> boards; //게시글들의 map
	private JDialog dialog; //현재팝업(게시글을 더블클릭하면 나오는 게시글 조회 팝업)
	private int row; //테이블에 현재 게시글이 해당하는 행번호 
	private JTable table; //게시글들이 있는 현재 테이블

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
		// 게시글을 삭제한 후, 성공적으로 삭제됐다면 true 아니라면 false를 반환해주는 메소드

		if (yn == false) { // 삭제에 실패했다면
			JDialog na = new NoAccess(now, main); // 삭제실패 메시지를 띄우는 팝업을 호출
			na.setVisible(true);
		}
		dialog.dispose();// 아니라면 현재 팝업창을 닫음

	}

}
