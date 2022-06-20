package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.BookController;
import com.kh.mini.controller.MemberController;
import com.kh.mini.handler.BookCellEvent;
import com.kh.mini.handler.BookSearchMouse;
import com.kh.mini.handler.BookTextRemove;
import com.kh.mini.model.dao.BookDB;
import com.kh.mini.model.vo.Book;
import com.kh.mini.model.vo.Member;

public class BookSearch extends JPanel {

	// 도서검색 판넬(책 목록과 검색할 수 있는 창)
	private BookSearch me;

	public BookSearch(JFrame main, Member m, Library l, MemberController mc) {// 메인프레임, 접속한 사람, 이전화면(4분할 화면), 멤버컨트롤러 받아옴
		me = this;

		// 판넬 생성.
		setLayout(null); // 널레이아웃
		setBounds(200, 200, 300, 300); // 판넬 크기
		setBackground(new Color(215, 204, 200)); // 배경 색 지정

		// 장르 콤보박스 JComboBox 생성.
		String[] sgenre = { "모든장르", "학습서", "소설", "만화", "요리", "여행", "시집", "건강", "어린이", "에세이" }; // 장르선택용 배열생성.
		JComboBox<String> cbb = new JComboBox<String>(sgenre); // 콤보박스에 장르들 넣어줌
		cbb.setBounds(150, 70, 200, 40); // 크기와 위치 지정
		cbb.setSelectedIndex(0); // 콤보박스에 기본적으로 나타나있을 기본 값(0이므로 '모든장르'가 기본값)
		cbb.setFont(new Font("돋움", Font.PLAIN, 20));

		// 텍스트검색창 JTextField
		JTextField stext = new JTextField(10);
		stext.setBounds(400, 70, 600, 40);
		stext.setFont(new Font("돋움", Font.PLAIN, 20));
		stext.setText("제목을 입력하세요."); // 기본적으로 제목을 입력하세요가 입력되어 있음
		// 텍스트 필드 클릭하면 제목을 입력하세요 글자 없어짐
		stext.addMouseListener(new BookTextRemove(stext, this, main));

		// 컬럼명용 1차원 배열
		String[] cl = { "장르", "도서명", "저자", "출판사" };
		ArrayList<Book> booklist = new ArrayList();

		Book[] books = new BookDB().saveBook();// 책 목록을 가져옴
		for (int i = 0; i < books.length; i++) {
			booklist.add(books[i]);
		}
		// 내용 2차원 배열.
		String[][] content = new String[booklist.size()][4];
		for (int i = 0; i < booklist.size(); i++) {
			content[i][0] = booklist.get(i).getGenre(); // 각 행마다 장르를 넣어준다.
			content[i][1] = booklist.get(i).getbName(); // 각 행마다 책이름 넣어준다.
			content[i][2] = booklist.get(i).getbWriter(); // 각 행마다 저자 넣어준다.
			content[i][3] = booklist.get(i).getPu(); // 각 행마다 출판사 넣어준다.
		}

		// 프레임과 판넬 사이의 모델 생성.
		// 테이블 수정을 막는 익명클래스
		DefaultTableModel dtable = new DefaultTableModel() {
			public boolean isCellEditable(int ro, int co) {
				return false;
			}
		};

//	    JTable table=new JTable(content,cl); //괄호 안에 (앞은 내용, 뒤는 헤더(컬럼))	   
		JTable table = new JTable(dtable);
		dtable.setDataVector(content, cl);

		// 스크롤 생성.
		JScrollPane scr = new JScrollPane(table); // 검색 결과창 스크롤 생성.
		scr.setBounds(150, 150, 1100, 500);
		table.setRowHeight(25);

		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.setFont(new Font("돋움", Font.PLAIN, 15));

		// 테이블 클릭(책 클릭)하면 책 대출하는 팝업으로 연결
		table.addMouseListener(new BookCellEvent(this, main, m, table, mc));

		// 책 검색 버튼
		JButton sbtn = new JButton("검색");
		sbtn.setBackground(new Color(109, 76, 65));
		sbtn.setForeground(Color.WHITE);
		sbtn.setFont(new Font("함초롬바탕", Font.BOLD, 23));
		sbtn.setBounds(1050, 70, 100, 40);

		// 검색 버튼을 누르면 검색되는 로직
		sbtn.addMouseListener(new BookSearchMouse(main, this, dtable, cbb, stext, table));

		// 엔터키 눌러도 검색되도록(검색버튼 누른것과 같도록) 설정
		stext.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) { // 엔터키가 눌린 순간(아래는 검색버튼 눌린 순간 로직과 동일)
				// TODO Auto-generated method stub
				int keyCord = e.getKeyCode();
				if (keyCord == 10) {
					BookController b = new BookController();
					ArrayList<Book> booklist = null;

					try {
						booklist = b.searchBook((String) cbb.getSelectedItem(), stext.getText());
					} catch (Exception x) {
						x.printStackTrace();
					}
					String[] cl = { "장르", "도서명", "저자", "출판사" };
					String[][] content = new String[booklist.size()][4];
					for (int i = 0; i < booklist.size(); i++) {
						content[i][0] = booklist.get(i).getGenre(); // 각 행마다 장르를 넣어준다.
						content[i][1] = booklist.get(i).getbName(); // 각 행마다 책이름 넣어준다.
						content[i][2] = booklist.get(i).getbWriter(); // 각 행마다 저자 넣어준다.
						content[i][3] = booklist.get(i).getPu(); // 각 행마다 출판사 넣어준다.
					}

					dtable.setDataVector(content, cl);
					table.setModel(dtable);
					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					table.getColumnModel().getColumn(1).setPreferredWidth(300);
					table.getColumnModel().getColumn(2).setPreferredWidth(10);
					table.getColumnModel().getColumn(3).setPreferredWidth(10);
					table.setFont(new Font("돋움", Font.PLAIN, 15));
				}

			}
		});

		// 콤보박스 에서 장르만 선택 했을때에도 테이블에 해당 장르의 책이 나타나도록
		cbb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox a = (JComboBox) e.getSource();
				int index = a.getSelectedIndex();
				BookController bookcon = new BookController();

				ArrayList<Book> booklist = null;

				try {
					booklist = bookcon.selectBook(index);
				} catch (Exception x) {
					x.printStackTrace();
				}
				String[] cl = { "장르", "도서명", "저자", "출판사" };
				String[][] content = new String[booklist.size()][4];
				for (int i = 0; i < booklist.size(); i++) {
					content[i][0] = booklist.get(i).getGenre(); // 각 행마다 장르를 넣어준다.
					content[i][1] = booklist.get(i).getbName(); // 각 행마다 책이름 넣어준다.
					content[i][2] = booklist.get(i).getbWriter(); // 각 행마다 저자 넣어준다.
					content[i][3] = booklist.get(i).getPu(); // 각 행마다 출판사 넣어준다.
				}

				dtable.setDataVector(content, cl);
				table.setModel(dtable);
				table.getColumnModel().getColumn(0).setPreferredWidth(10);
				table.getColumnModel().getColumn(1).setPreferredWidth(300);
				table.getColumnModel().getColumn(2).setPreferredWidth(10);
				table.getColumnModel().getColumn(3).setPreferredWidth(10);
				table.setFont(new Font("돋움", Font.PLAIN, 15));

			}
		});

		// 뒤로가기 아이콘
		ImageIcon b = new ImageIcon("back.png");
		JLabel back = new JLabel(b);
		back.setBounds(0, 0, 100, 100);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.remove(me);
				main.add(l);// 기존의 로그인 불러오는거임
				l.revalidate();
				main.repaint();
			}
		});

		add(cbb); // 장르콤보박스
		add(stext); // 검색창
		add(sbtn); // 검색버튼
		add(scr); // 스크롤을 추가함으로서 테이블도 추가됨
		add(back); // 뒤로가기
		main.add(this); // 메인프레임에 현재 판넬을 입혀줌

	}

}