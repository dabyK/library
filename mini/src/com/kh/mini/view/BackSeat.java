package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class BackSeat extends JDialog {

	public BackSeat() {// �¼� �ݳ��� �˸��� �˾�â
		setTitle("�ȳ��޽���");
		setBounds(700, 400, 500, 250);

		// �޽���
		JLabel label = new JLabel("�¼��ݳ��� �Ǿ����ϴ�.");
		label.setBounds(130, 42, 300, 40);
		label.setFont(new Font("���ʷҹ���", Font.BOLD, 23));

		// Ȯ�ι�ư
		JButton btn = new JButton("Ȯ��");
		btn.setFont(new Font("���ʷҹ���", Font.BOLD, 20));
		btn.setBounds(190, 110, 100, 50);
		// Ȯ�� ��ư ������ ���� �˾�â ����
		btn.addMouseListener(
			new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
				}
			});

		JLabel a = new JLabel("");// <- �̰� �����ϸ��

		add(label);
		add(btn);
		add(a);

	}

}