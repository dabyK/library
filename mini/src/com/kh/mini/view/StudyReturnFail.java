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
	// �̹� ������ �¼��� Ŭ������ �� �ߴ� �˾�â

	private JPanel now; // ���� �ǳ�
	private JFrame main; // ���� ������

	public StudyReturnFail(JPanel now, JFrame main) {
		super();
		this.now = now;
		this.main = main;

		setTitle("�ȳ��޽���");
		setBounds(700, 400, 500, 250); // ũ��� ��ġ
		setLayout(null);// �η��̾ƿ�

		// �޽���
		JLabel label = new JLabel("�� �ڸ��� �̹� �ٸ� ����� �����Ͽ����ϴ�.");
		label.setBounds(37, 40, 1000, 40);
		label.setFont(new Font("���ʷҹ���", Font.BOLD, 23));
		// Ȯ�ι�ư
		JButton btn = new JButton("Ȯ��");
		btn.setFont(new Font("���ʷҹ���", Font.BOLD, 20));
		btn.setBounds(190, 110, 100, 50);
		// Ȯ�� ��ư�� ������ ���� �˾� ����
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