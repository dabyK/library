package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.handler.BookTextRemove;
import com.kh.mini.handler.SavePost;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;

public class WritePop extends JDialog {
	// 글 작성 창

	private JPanel now; // 현재 판넬(글목록)
	private JFrame main; // 메인 프레임
	private Member m; // 접속한 사람
	private HashMap<String, SBoard> boards; // 게시글들 모여있는 map
	private WritePop me; // 자기자신(다이얼로그)
	private JTable table; // 글목록 테이블

	public WritePop(Member m, HashMap<String, SBoard> boards, JTable table) { // 접속한 사람, 게시글 map, 글목록 table 받아옴

		me = this;
		this.m = m;
		this.boards = boards;
		this.table = table;

		setTitle("글쓰기");
		setSize(800, 1000); // 크기와 위치
		setLocationRelativeTo(null); // 팝업 위치를 프로그램 가운데로
		setLayout(null); // 널레이아웃

		// 글쓰기 라고 맨 위에 보여주는 라벨
		JLabel jm = new JLabel("글쓰기");
		jm.setBounds(350, 8, 300, 50);
		jm.setFont(new Font("함초롬바탕", Font.BOLD, 25));

		// 제목 입력 칸이라고 알려주는 라벨
		JLabel cLabel = new JLabel("제목");
		cLabel.setBounds(78, 60, 50, 50);
		cLabel.setFont(new Font("함초롬바탕", Font.BOLD, 20));

		// 제목 입력 창
		JTextField cTitle = new JTextField(" ");
		cTitle.setBounds(138, 60, 550, 50);
		cTitle.setFont(new Font("함초롬바탕", Font.BOLD, 20));

		// 글 내용 입력 창
		JTextArea content = new JTextArea("입력하세요."); // 기본적으로 입력하세요가 적혀있음
		content.setBounds(88, 125, 600, 750); // 크기와 위치
		content.setLineWrap(true); // 글을 창 크기보다 길게 입력하면 자동으로 줄 바꿔줌
		content.setFont(new Font("함초롬바탕", Font.PLAIN, 20)); // 폰트 설정
		content.setBorder(new MatteBorder(1, 1, 1, 1, Color.black)); // 입력 창에 테두리 설정
		// 글 내용 클릭하자마자 입력하세요 글씨 없애주는 기능(""로 만들어줌)
		// 대신 글 내용 작성했던 것들도 다시 클릭하면 날아감...
		content.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				content.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});

		// 저장 버튼
		JButton btn = new JButton("저장");
		btn.setBounds(605, 890, 80, 50);
		btn.setFont(new Font("함초롬바탕", Font.BOLD, 20));
		// 버튼 누르는 순간 글 저장되고 테이블에도 추가되게 바꾸기
		btn.addMouseListener(new SavePost(now, main, m, boards, cTitle, content, this, table));
		// 현재 판넬, 메인프레임, 접속한 사람, 게시글map, 게시글 제목, 내용, 현재 팝업창, 게시글 table 보내줌

		add(jm); // 글쓰기 창임을 알려주는 라벨
		add(cTitle); // 제목쓰는 칸임을 알려주는 라벨
		add(cLabel); // 제목입력창
		add(content); // 내용 입력창
		add(btn); // 저장버튼

	}

}