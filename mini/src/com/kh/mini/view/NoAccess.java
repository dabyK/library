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
		// �Խñ��� �����Ϸ��� �� ��, ������ �� ���� �ƴϸ� ���������� ���ٰ� �����ִ� �˾�â
		super();
		this.now = now;
		this.main = main;

		setTitle("�ȳ� �޽���");
		setSize(500, 200);
		setLocationRelativeTo(null); // �˾�â ��ġ�� ���α׷��� ����� ����
		setLayout(null); // �η��̾ƿ�

		JLabel lb = new JLabel("���� ������ �����ϴ�.");
		lb.setBounds(125, 50, 300, 50);
		lb.setFont(new Font("���ʷҹ���", Font.BOLD, 25));

		add(lb);

	}

}