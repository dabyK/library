package com.kh.mini.view;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NoAccess extends JDialog {

	private JPanel now;
	private JFrame main;

	public NoAccess(JPanel now, JFrame main) {
		// 게시글을 삭제하려고 할 때, 본인이 쓴 글이 아니면 삭제권한이 없다고 보여주는 팝업창
		super();
		this.now = now;
		this.main = main;

		setTitle("안내 메시지");
		setSize(500, 200);
		setLocationRelativeTo(null); // 팝업창 위치를 프로그램의 가운데로 맞춤
		setLayout(null); // 널레이아웃

		JLabel lb = new JLabel("삭제 권한이 없습니다.");
		lb.setBounds(125, 50, 300, 50);
		lb.setFont(new Font("함초롬바탕", Font.BOLD, 25));

		add(lb);

	}

}