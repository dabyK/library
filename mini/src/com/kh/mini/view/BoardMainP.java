package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.handler.BoardWrite;
import com.kh.mini.handler.PostCellEvent;
import com.kh.mini.model.dao.SBoardDB;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;

public class BoardMainP extends JPanel {

	private JPanel now;
	private JFrame main;
	private Member m; // ���� ������ ���
	private BoardMainP me; // �Խñ��� ���� �ǳ�(���� �ڽ�)
	private Library l; // 4���� ȭ��!
	private HashMap<String, SBoard> boards; // �Խñ۵��� ����� map
	private JTable table; // �Խñ۵��� �����ִ� ���̺�

	public BoardMainP(JFrame main, Member m, Library l) { // ���� ������, ������ ���(��), ����ȭ��(4����ȭ��) �޾ƿ�

		setBackground(new Color(215, 204, 200)); // �ǳ� ����
		me = this; // ���� �ǳ��� �� �ڽ����� �˷���
		this.main = main;
		this.m = m;
		this.l = l;

		// �ǳ� ����
		setLayout(null); //�η��̾ƿ�
		setBounds(200, 200, 300, 300); //�ǳ�ũ��

		// ���ǻ��� ����(��)
		JLabel jm = new JLabel("< ���ǻ��� >");
		jm.setBounds(600, 30, 200, 60);
		jm.setFont(new Font("���ʷҹ���", Font.BOLD, 30));

		// ���Ͽ� ����� ���� �ҷ��� �ʿ� ����
		boards = new SBoardDB().startBDB();

		// �� ���̺� �����
		String[] cl = { "��ȣ", "����", "�۾���", "�ۼ���" };//�� ���� ��

		String[][] content = new String[boards.size()][4]; //����� �Խñ� ����ŭ ���� �����, ������ �׸�(��)�� 4�� ����

		// ���̺� ���� ���ϰ� ����
		DefaultTableModel dtable = new DefaultTableModel(null, cl) {
			public boolean isCellEditable(int ro, int co) {
				return false;
			}
		};

		// �Խñ��� key(�Խñ� ��ȣ)�� �޾ƿ� ���̺� �Խñ۵��� �߰����ֱ�
		for (String key : boards.keySet()) {
			dtable.addRow(new Object[] { boards.get(key).getNum(), boards.get(key).getTitle(),
					boards.get(key).getWriter(), boards.get(key).getDate() }); //���̺� �Խñ� ��ȣ, ����, �ۼ���, �ۼ��� �� �� ������ �߰�
		}

		JTable table = new JTable(dtable); //���̺� ����

		// ���̺� ������ �� ��ȸ�� �̵�
		table.addMouseListener(new PostCellEvent(now, main, m, table, boards)); 

		// ��ũ�� �����
		JScrollPane scr = new JScrollPane(table);
		scr.setBounds(150, 150, 1100, 500);
		table.setRowHeight(25);

		// ���̺� �� �� ����
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(320);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.setFont(new Font("����", Font.PLAIN, 15));

		// �۾��� ��ư
		JButton btn1 = new JButton("�۾���");
		btn1.setBounds(1100, 80, 150, 50);
		btn1.setBackground(new Color(188, 170, 164));
		btn1.setFont(new Font("���ʷҹ���", Font.BOLD, 20));
		
		// �۾��� ������ �� �������� �̵�
		btn1.addMouseListener(new BoardWrite(now, main, m, boards, table));

		dtable.fireTableDataChanged();//??�̰� ������ ���̺� �� ����,���� �� �������ַ��� ��� �� ������
		
		//�ڷΰ��� ��ư
		ImageIcon b = new ImageIcon("back.png"); 
		JLabel back = new JLabel(b);
		back.setBounds(0, 0, 100, 100);
		back.addMouseListener(new MouseAdapter() { //�ڷΰ��� ������ ���� ȭ�� ȣ��
			@Override
			public void mouseClicked(MouseEvent e) {
				main.remove(me);
				main.add(l);// ������ �α��� �ҷ����°���
				l.revalidate();
				main.repaint();
			}
		});
		
		add(back);
		add(jm);
		add(scr);
		add(btn1);

		main.add(this);//���� �����ӿ� ���� �ǳ��� ���� 

	}

}