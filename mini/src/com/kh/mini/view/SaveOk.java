package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class SaveOk extends JDialog {

	public SaveOk(NewMember nm) {// ȸ������������ �Ϸ�Ǹ� �ߴ� �˾�â

		setTitle("�ȳ��޽���");
		setBounds(750, 350, 500, 250);

		JLabel label = new JLabel("���������� ����Ǿ����ϴ�!");
		label.setBounds(150, 50, 500, 50);
		label.setFont(new Font("���ʷҹ���", Font.BOLD, 15));

		JButton btn = new JButton("Ȯ��");
		btn.setBounds(180, 120, 100, 50);
		btn.setFont(new Font("���ʷҹ���", Font.BOLD, 15));

		JLabel a = new JLabel("");// <- �̰� �����ϸ��

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

	public SaveOk(MemberInfoChange mic) {// ȸ�������� �Ϸ�Ǹ� �ߴ� �˾�â

		setTitle("�ȳ��޽���");
		setBounds(750, 350, 500, 250);

		JLabel label = new JLabel("���������� �����Ǿ����ϴ�!");
		label.setBounds(150, 50, 500, 50);
		label.setFont(new Font("���ʷҹ���", Font.BOLD, 15));

		JButton btn = new JButton("Ȯ��");
		btn.setBounds(180, 120, 100, 50);
		btn.setFont(new Font("���ʷչ���", Font.BOLD, 15));

		JLabel a = new JLabel("");// <- �̰� �����ϸ��

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