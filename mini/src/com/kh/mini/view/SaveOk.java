package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class SaveOk extends JDialog {

	public SaveOk(NewMember nm) {// 회원가입저장이 완료되면 뜨는 팝업창

		setTitle("안내메시지");
		setBounds(750, 350, 500, 250);

		JLabel label = new JLabel("성공적으로 저장되었습니다!");
		label.setBounds(150, 50, 500, 50);
		label.setFont(new Font("함초롬바탕", Font.BOLD, 15));

		JButton btn = new JButton("확인");
		btn.setBounds(180, 120, 100, 50);
		btn.setFont(new Font("함초롬바탕", Font.BOLD, 15));

		JLabel a = new JLabel("");// <- 이거 무시하면됨

		add(label);
		add(btn);
		add(a);

		btn.addMouseListener(

				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

						setVisible(false);
						nm.setVisible(false);
					}
				});

	}

	public SaveOk(MemberInfoChange mic) {// 회원수정이 완료되면 뜨는 팝업창

		setTitle("안내메시지");
		setBounds(750, 350, 500, 250);

		JLabel label = new JLabel("성공적으로 수정되었습니다!");
		label.setBounds(150, 50, 500, 50);
		label.setFont(new Font("함초롬바탕", Font.BOLD, 15));

		JButton btn = new JButton("확인");
		btn.setBounds(180, 120, 100, 50);
		btn.setFont(new Font("함초롱바탕", Font.BOLD, 15));

		JLabel a = new JLabel("");// <- 이거 무시하면됨

		add(label);
		add(btn);
		add(a);

		btn.addMouseListener(

				new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

						setVisible(false);
						mic.setVisible(false);
					}
				});
	}
}