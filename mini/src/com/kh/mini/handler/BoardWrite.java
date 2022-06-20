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

	private JPanel now; //현재 판넬
	private JFrame main; //현재 프레임
	private Member m; //지금 접속한 사람
	private HashMap<String, SBoard> boards; //게시글들의 map
	private JTable table; //게시글 table

	public BoardWrite(JPanel now, JFrame main, Member m, HashMap<String, SBoard> boards, JTable table) {
		super();
		this.now = now;
		this.main = main;
		this.m = m;
		this.boards = boards;
		this.table = table;

	}

	@Override
	public void mouseClicked(MouseEvent e) {// 클릭한 순간

		super.mouseClicked(e);
		new WritePop(m, boards, table).setVisible(true);
		// 클릭하면 writePop 팝업(글쓰기 창)을 보여주기

	}

}
