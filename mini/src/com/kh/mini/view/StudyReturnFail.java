package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudyReturnFail extends JDialog {
	// 이미 예약한 좌석을 클릭했을 때 뜨는 팝업창

	private JPanel now; // 현재 판넬
	private JFrame main; // 메인 프레임

	public StudyReturnFail(JPanel now, JFrame main) {
		super();
		this.now = now;
		this.main = main;

		setTitle("안내메시지");
		setBounds(700, 400, 500, 250); // 크기와 위치
		setLayout(null);// 널레이아웃

		// 메시지
		JLabel label = new JLabel("이 자리는 이미 다른 사람이 예약하였습니다.");
		label.setBounds(37, 40, 1000, 40);
		label.setFont(new Font("함초롬바탕", Font.BOLD, 23));
		// 확인버튼
		JButton btn = new JButton("확인");
		btn.setFont(new Font("함초롬바탕", Font.BOLD, 20));
		btn.setBounds(190, 110, 100, 50);
		// 확인 버튼을 누르면 현재 팝업 꺼짐
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		add(label);
		add(btn);
	}

}