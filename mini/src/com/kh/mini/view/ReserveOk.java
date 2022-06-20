package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ReserveOk extends JDialog {
	//열람실 자리 예약 성공일 때 나타나는 팝업창

	public ReserveOk() {
		setTitle("안내메시지");
		setBounds(700, 400, 500, 250); //크기와 위치
		//메시지
		JLabel label = new JLabel("자리 예약이 되었습니다."); 
		label.setBounds(130, 42, 300, 40);
		label.setFont(new Font("함초롬바탕", Font.BOLD, 23));
		
		//확인버튼
		JButton btn = new JButton("확인");
		btn.setFont(new Font("함초롬바탕", Font.BOLD, 20));
		btn.setBounds(190, 110, 100, 50);
		//확인버튼 누르면 현재 팝업창 꺼짐
		btn.addMouseListener(
				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						setVisible(false);
					}
				});

		JLabel a = new JLabel("");// <- 이거 무시하면됨

		add(label);
		add(btn);
		add(a);

	}

}