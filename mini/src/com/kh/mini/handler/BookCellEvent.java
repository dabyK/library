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

	private Member m; //현재 접속한 사람
	private JTable table; //책목록 테이블 
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

		if (e.getClickCount() == 2) { // 더블클릭하면
			int row = table.getSelectedRow();// 현재 선택한 행 번호를 받아오기
			String bookName = (String) table.getValueAt(row, 1); // (선택한 행,1)에 있는 값을 bookName변수에 저장(1열은 책이름들이 있는 열)
			Book b = new BookController().clickBook(bookName);// 그 이름이 책DB의 목록에 있다면 b객체에 저장해주기
			JDialog book = new BookClick(m, b, mc); // 현재 접속한 사람과, memberController객체, 검색한 책의 정보를 보내 대출하기팝업을 호출
			book.setVisible(true);
		}

	}

}
