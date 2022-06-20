package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import com.kh.mini.handler.PostRemoveH;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;

public class PostClick extends JDialog implements ActionListener {

	public PostClick(JPanel now, JFrame main, Member m, SBoard sb, HashMap<String, SBoard> boards, int row,
			JTable table) {
		//게시글을 조회 팝업창

		setTitle("작성된 글");
		setSize(800, 1000);
		setLocationRelativeTo(null); //팝업창의 위치를 프로그램의 가운데로 설정해줌
		setLayout(null); //널레이아웃

		//제목옆에 제목이라고 표시해주는 글씨 라벨
		JLabel jm = new JLabel("제목");
		jm.setBounds(73, 55, 50, 50);
		jm.setFont(new Font("함초롬바탕", Font.BOLD, 20));

		//글 제목
		JTextField jmm = new JTextField();
		jmm.setBounds(133, 55, 550, 50); //크기와 위치
		jmm.setText(sb.getTitle()); //작성된 글제목을 가져옴
		jmm.setFont(new Font("함초롬바탕", Font.BOLD, 20)); //폰트설정
		jmm.setEditable(false); //클릭해도 수정할 수 없게
		jmm.setForeground(Color.BLACK); //글자 색
		jmm.setBackground(Color.WHITE); //배경 색 

		//글 내용
		JTextArea content = new JTextArea(sb.getContent()); //작성된 내용을 불러와서 반영
		content.setBounds(86, 120, 600, 750); //크기와 위치
		content.setFont(new Font("함초롬바탕", Font.PLAIN, 20)); //폰트설정
		content.setBorder(new MatteBorder(1, 1, 1, 1, Color.black)); //글 박스의 테두리 설정
		content.setEditable(false); //클릭해도 수정할 수 없게
		content.setForeground(Color.BLACK); //글자 색
		content.setBackground(Color.WHITE); //배경 색

		//삭제버튼
		JButton btn = new JButton("삭제"); 
		btn.setBounds(608, 875, 80, 50); //크기와 위치
		btn.setFont(new Font("함초롬바탕", Font.BOLD, 20)); //폰트 설정
		//삭제 버튼 누르면 글이 삭제되고, 현재 팝업창이 꺼짐
		btn.addMouseListener(new PostRemoveH(now, main, m, sb, boards, this, row, table));

		add(jm); //제목글자
		add(jmm); //제목
		add(content); //내용
		add(btn); //삭제버튼

	}

	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
