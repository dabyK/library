package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.handler.BoardWrite;
import com.kh.mini.handler.PostCellEvent;
import com.kh.mini.model.dao.SBoardDB;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;

public class BoardMainP extends JPanel {

	private JPanel now;
	private JFrame main;
	private Member m; // 현재 접속한 사람
	private BoardMainP me; // 게시글의 메인 판넬(지금 자신)
	private Library l; // 4분할 화면!
	private HashMap<String, SBoard> boards; // 게시글들이 저장된 map
	private JTable table; // 게시글들을 보여주는 테이블

	public BoardMainP(JFrame main, Member m, Library l) { // 현재 프레임, 접속한 사람(나), 이전화면(4분할화면) 받아옴

		setBackground(new Color(215, 204, 200)); // 판넬 배경색
		me = this; // 메인 판넬이 나 자신임을 알려줌
		this.main = main;
		this.m = m;
		this.l = l;

		// 판넬 생성
		setLayout(null); //널레이아웃
		setBounds(200, 200, 300, 300); //판넬크기

		// 건의사항 글자(라벨)
		JLabel jm = new JLabel("< 건의사항 >");
		jm.setBounds(600, 30, 200, 60);
		jm.setFont(new Font("함초롬바탕", Font.BOLD, 30));

		// 파일에 저장된 글을 불러와 맵에 대입
		boards = new SBoardDB().startBDB();

		// 글 테이블 만들기
		String[] cl = { "번호", "제목", "글쓴이", "작성일" };//맨 위의 행

		String[][] content = new String[boards.size()][4]; //저장된 게시글 수만큼 행을 만들고, 보여줄 항목(열)을 4개 만듬

		// 테이블 수정 못하게 막기
		DefaultTableModel dtable = new DefaultTableModel(null, cl) {
			public boolean isCellEditable(int ro, int co) {
				return false;
			}
		};

		// 게시글의 key(게시글 번호)를 받아와 테이블에 게시글들을 추가해주기
		for (String key : boards.keySet()) {
			dtable.addRow(new Object[] { boards.get(key).getNum(), boards.get(key).getTitle(),
					boards.get(key).getWriter(), boards.get(key).getDate() }); //테이블에 게시글 번호, 제목, 작성자, 작성일 을 한 행으로 추가
		}

		JTable table = new JTable(dtable); //테이블 만듬

		// 테이블 누르면 글 조회로 이동
		table.addMouseListener(new PostCellEvent(now, main, m, table, boards)); 

		// 스크롤 만들기
		JScrollPane scr = new JScrollPane(table);
		scr.setBounds(150, 150, 1100, 500);
		table.setRowHeight(25);

		// 테이블 열 폭 조정
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(320);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.setFont(new Font("돋움", Font.PLAIN, 15));

		// 글쓰기 버튼
		JButton btn1 = new JButton("글쓰기");
		btn1.setBounds(1100, 80, 150, 50);
		btn1.setBackground(new Color(188, 170, 164));
		btn1.setFont(new Font("함초롬바탕", Font.BOLD, 20));
		
		// 글쓰기 누르면 글 생성으로 이동
		btn1.addMouseListener(new BoardWrite(now, main, m, boards, table));

		dtable.fireTableDataChanged();//??이거 뭐였지 테이블 글 쓰고,삭제 후 리셋해주려고 썼던 것 같은데
		
		//뒤로가기 버튼
		ImageIcon b = new ImageIcon("back.png"); 
		JLabel back = new JLabel(b);
		back.setBounds(0, 0, 100, 100);
		back.addMouseListener(new MouseAdapter() { //뒤로가기 누르면 이전 화면 호출
			@Override
			public void mouseClicked(MouseEvent e) {
				main.remove(me);
				main.add(l);// 기존의 로그인 불러오는거임
				l.revalidate();
				main.repaint();
			}
		});
		
		add(back);
		add(jm);
		add(scr);
		add(btn1);

		main.add(this);//메인 프레임에 현재 판넬을 입힘 

	}

}