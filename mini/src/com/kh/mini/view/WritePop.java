package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.table.DefaultTableModel;

import com.kh.mini.handler.BookTextRemove;
import com.kh.mini.handler.SavePost;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;

public class WritePop extends JDialog {
	// �� �ۼ� â

	private JPanel now; // ���� �ǳ�(�۸��)
	private JFrame main; // ���� ������
	private Member m; // ������ ���
	private HashMap<String, SBoard> boards; // �Խñ۵� ���ִ� map
	private WritePop me; // �ڱ��ڽ�(���̾�α�)
	private JTable table; // �۸�� ���̺�

	public WritePop(Member m, HashMap<String, SBoard> boards, JTable table) { // ������ ���, �Խñ� map, �۸�� table �޾ƿ�

		me = this;
		this.m = m;
		this.boards = boards;
		this.table = table;

		setTitle("�۾���");
		setSize(800, 1000); // ũ��� ��ġ
		setLocationRelativeTo(null); // �˾� ��ġ�� ���α׷� �����
		setLayout(null); // �η��̾ƿ�

		// �۾��� ��� �� ���� �����ִ� ��
		JLabel jm = new JLabel("�۾���");
		jm.setBounds(350, 8, 300, 50);
		jm.setFont(new Font("���ʷҹ���", Font.BOLD, 25));

		// ���� �Է� ĭ�̶�� �˷��ִ� ��
		JLabel cLabel = new JLabel("����");
		cLabel.setBounds(78, 60, 50, 50);
		cLabel.setFont(new Font("���ʷҹ���", Font.BOLD, 20));

		// ���� �Է� â
		JTextField cTitle = new JTextField(" ");
		cTitle.setBounds(138, 60, 550, 50);
		cTitle.setFont(new Font("���ʷҹ���", Font.BOLD, 20));

		// �� ���� �Է� â
		JTextArea content = new JTextArea("�Է��ϼ���."); // �⺻������ �Է��ϼ��䰡 ��������
		content.setBounds(88, 125, 600, 750); // ũ��� ��ġ
		content.setLineWrap(true); // ���� â ũ�⺸�� ��� �Է��ϸ� �ڵ����� �� �ٲ���
		content.setFont(new Font("���ʷҹ���", Font.PLAIN, 20)); // ��Ʈ ����
		content.setBorder(new MatteBorder(1, 1, 1, 1, Color.black)); // �Է� â�� �׵θ� ����
		// �� ���� Ŭ�����ڸ��� �Է��ϼ��� �۾� �����ִ� ���(""�� �������)
		// ��� �� ���� �ۼ��ߴ� �͵鵵 �ٽ� Ŭ���ϸ� ���ư�...
		content.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				content.setText("");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});

		// ���� ��ư
		JButton btn = new JButton("����");
		btn.setBounds(605, 890, 80, 50);
		btn.setFont(new Font("���ʷҹ���", Font.BOLD, 20));
		// ��ư ������ ���� �� ����ǰ� ���̺��� �߰��ǰ� �ٲٱ�
		btn.addMouseListener(new SavePost(now, main, m, boards, cTitle, content, this, table));
		// ���� �ǳ�, ����������, ������ ���, �Խñ�map, �Խñ� ����, ����, ���� �˾�â, �Խñ� table ������

		add(jm); // �۾��� â���� �˷��ִ� ��
		add(cTitle); // ���񾲴� ĭ���� �˷��ִ� ��
		add(cLabel); // �����Է�â
		add(content); // ���� �Է�â
		add(btn); // �����ư

	}

}