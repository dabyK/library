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
	private Member m; //현재 접속한 사람
	private JTable table; //게시글 목록이 적힌 테이블
	private HashMap<String, SBoard> boards; //게시글들이 저장되어 있는 boards맵

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
		if (e.getClickCount() == 2) {// 더블클릭한 순간
			int row = table.getSelectedRow(); // 현재 테이블에서 선택된 행 번호를 받아옴

			String writenum = (String) table.getValueAt(row, 0); // (해당 행,0)의 값(게시글 번호)을 변수로 받아옴
			SBoard sb = new BoardController().ClickBoard(boards, writenum); // 게시글이 저장된 맵과, 게시글 번호를 보내서 해당하는 글의 정보를
																			// sb객체에 불러옴

			JDialog post = new PostClick(now, main, m, sb, boards, row, table);// 글을 조회하는 팝업 호출
			post.setVisible(true);

		}

	}

}
