package com.kh.mini.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.kh.mini.model.vo.Book;

public class RentFinish extends JDialog {
	// �����ϱ� ������ �ߴ� �˾�â(�Ϸ�ǰų�,3���ʰ�)

	public RentFinish(BookClick bc, boolean rent, Book b) {
		// �����˾�(å ����Ŭ���ϸ� ������ å�̸�,�̹���,�����ư �˾�),������ �����ߴ��� ����, ���� å ��ü �޾ƿ�

		setTitle("�ȳ��޽���");
		setSize(500, 200); // �˾�â ũ��
		setLocationRelativeTo(null); // �˾� ��ġ�� ���α׷� �����
		setLayout(null); // �η��̾ƿ�
		JLabel msg;
		JLabel date;

		if (rent) {// ������ �������
			msg = new JLabel("�� ���� �Ϸ� ��"); // �޽���
			date = new JLabel("�뿩 �Ⱓ : " + b.getRentDate() + " ~ " + b.getBackDate()); // �뿩�Ⱓ ǥ��
			date.setBounds(80, 20, 400, 100); // �뿩�Ⱓ���� ũ��
			date.setFont(new Font("���ʷҹ���", Font.PLAIN, 20));
			add(date); // �뿩�Ⱓ �߰�
		} else {// å�� ���Ѱ��� �ʰ��ΰ��
			msg = new JLabel("���� �Ǽ��� �ʰ��߽��ϴ�."); //�޽���
		}
		msg.setBounds(123, 28, 400, 50);
		msg.setFont(new Font("���ʷҹ���", Font.BOLD, 20));
		add(msg);
		
		//Ȯ�� ��ư
		JButton btn = new JButton("Ȯ��");
		btn.setBounds(205, 90, 90, 45); //ũ��� ��ġ
		btn.setFont(new Font("���ʷҹ���", Font.BOLD, 20)); //��Ʈ ����
		btn.addActionListener(new ActionListener() { //������ ���� �˾�â ����
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				bc.setVisible(false);
			}
		});
		
		add(btn);

		msg.revalidate();

	}

}
