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

	private JPanel now; //현재 판넬
	private DefaultTableModel dtm; //테이블 모델(테이블 바꿔주기 위한 기능)
	private JFrame main; //현재 프레임
	private JComboBox<String> genre; //검색하고자 하는 책의 장르를 선택하는 콤보박스
	private JTextField name; //책 이름을 검색하는 textField 창
	private JTable table; //책 목록이 있는 테이블

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
			// list에 현재 선택된 장르와, TextField검색창에 적혀있는 책 이름에 해당하는 책 정보를 저장
		} catch (Exception x) {
			x.printStackTrace();
		}
		String[] cl = { "장르", "도서명", "저자", "출판사" }; // 테이블의 맨 위 행을 만들어줌

		String[][] content = new String[booklist.size()][4];// 테이블의 아래 행들(책 목록들)을 만들어줌 //책의 갯수만큼 행 갯수를 할당
		for (int i = 0; i < booklist.size(); i++) {
			content[i][0] = booklist.get(i).getGenre(); // 0열의 각 행마다 장르를 넣어준다.
			content[i][1] = booklist.get(i).getbName(); // 1열의 각 행마다 책이름 넣어준다.
			content[i][2] = booklist.get(i).getbWriter(); // 2열의 각 행마다 저자 넣어준다.
			content[i][3] = booklist.get(i).getPu(); // 3열의 각 행마다 출판사 넣어준다.
		}

		dtm.setDataVector(content, cl);
		table.setModel(dtm);// 지정한 대로 테이블을 만들어줌

		table.getColumnModel().getColumn(0).setPreferredWidth(10); // 0열의 길이를 10으로 지정
		table.getColumnModel().getColumn(1).setPreferredWidth(300); // 1열의 길이를 10으로 지정
		table.getColumnModel().getColumn(2).setPreferredWidth(10); // 2열의 길이를 10으로 지정
		table.getColumnModel().getColumn(3).setPreferredWidth(10); // 3열의 길이를 10으로 지정
		table.setFont(new Font("돋움", Font.PLAIN, 15)); // 테이블의 폰트 상태를 지정

	}

}
