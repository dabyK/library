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
		//�Խñ��� ��ȸ �˾�â

		setTitle("�ۼ��� ��");
		setSize(800, 1000);
		setLocationRelativeTo(null); //�˾�â�� ��ġ�� ���α׷��� ����� ��������
		setLayout(null); //�η��̾ƿ�

		//���񿷿� �����̶�� ǥ�����ִ� �۾� ��
		JLabel jm = new JLabel("����");
		jm.setBounds(73, 55, 50, 50);
		jm.setFont(new Font("���ʷҹ���", Font.BOLD, 20));

		//�� ����
		JTextField jmm = new JTextField();
		jmm.setBounds(133, 55, 550, 50); //ũ��� ��ġ
		jmm.setText(sb.getTitle()); //�ۼ��� �������� ������
		jmm.setFont(new Font("���ʷҹ���", Font.BOLD, 20)); //��Ʈ����
		jmm.setEditable(false); //Ŭ���ص� ������ �� ����
		jmm.setForeground(Color.BLACK); //���� ��
		jmm.setBackground(Color.WHITE); //��� �� 

		//�� ����
		JTextArea content = new JTextArea(sb.getContent()); //�ۼ��� ������ �ҷ��ͼ� �ݿ�
		content.setBounds(86, 120, 600, 750); //ũ��� ��ġ
		content.setFont(new Font("���ʷҹ���", Font.PLAIN, 20)); //��Ʈ����
		content.setBorder(new MatteBorder(1, 1, 1, 1, Color.black)); //�� �ڽ��� �׵θ� ����
		content.setEditable(false); //Ŭ���ص� ������ �� ����
		content.setForeground(Color.BLACK); //���� ��
		content.setBackground(Color.WHITE); //��� ��

		//������ư
		JButton btn = new JButton("����"); 
		btn.setBounds(608, 875, 80, 50); //ũ��� ��ġ
		btn.setFont(new Font("���ʷҹ���", Font.BOLD, 20)); //��Ʈ ����
		//���� ��ư ������ ���� �����ǰ�, ���� �˾�â�� ����
		btn.addMouseListener(new PostRemoveH(now, main, m, sb, boards, this, row, table));

		add(jm); //�������
		add(jmm); //����
		add(content); //����
		add(btn); //������ư

	}

	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
