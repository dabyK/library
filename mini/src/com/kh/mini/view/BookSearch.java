package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.controller.BookController;
import com.kh.mini.controller.MemberController;
import com.kh.mini.handler.BookCellEvent;
import com.kh.mini.handler.BookSearchMouse;
import com.kh.mini.handler.BookTextRemove;
import com.kh.mini.model.dao.BookDB;
import com.kh.mini.model.vo.Book;
import com.kh.mini.model.vo.Member;

public class BookSearch extends JPanel {

	// �����˻� �ǳ�(å ��ϰ� �˻��� �� �ִ� â)
	private BookSearch me;

	public BookSearch(JFrame main, Member m, Library l, MemberController mc) {// ����������, ������ ���, ����ȭ��(4���� ȭ��), �����Ʈ�ѷ� �޾ƿ�
		me = this;

		// �ǳ� ����.
		setLayout(null); // �η��̾ƿ�
		setBounds(200, 200, 300, 300); // �ǳ� ũ��
		setBackground(new Color(215, 204, 200)); // ��� �� ����

		// �帣 �޺��ڽ� JComboBox ����.
		String[] sgenre = { "����帣", "�н���", "�Ҽ�", "��ȭ", "�丮", "����", "����", "�ǰ�", "���", "������" }; // �帣���ÿ� �迭����.
		JComboBox<String> cbb = new JComboBox<String>(sgenre); // �޺��ڽ��� �帣�� �־���
		cbb.setBounds(150, 70, 200, 40); // ũ��� ��ġ ����
		cbb.setSelectedIndex(0); // �޺��ڽ��� �⺻������ ��Ÿ������ �⺻ ��(0�̹Ƿ� '����帣'�� �⺻��)
		cbb.setFont(new Font("����", Font.PLAIN, 20));

		// �ؽ�Ʈ�˻�â JTextField
		JTextField stext = new JTextField(10);
		stext.setBounds(400, 70, 600, 40);
		stext.setFont(new Font("����", Font.PLAIN, 20));
		stext.setText("������ �Է��ϼ���."); // �⺻������ ������ �Է��ϼ��䰡 �ԷµǾ� ����
		// �ؽ�Ʈ �ʵ� Ŭ���ϸ� ������ �Է��ϼ��� ���� ������
		stext.addMouseListener(new BookTextRemove(stext, this, main));

		// �÷���� 1���� �迭
		String[] cl = { "�帣", "������", "����", "���ǻ�" };
		ArrayList<Book> booklist = new ArrayList();

		Book[] books = new BookDB().saveBook();// å ����� ������
		for (int i = 0; i < books.length; i++) {
			booklist.add(books[i]);
		}
		// ���� 2���� �迭.
		String[][] content = new String[booklist.size()][4];
		for (int i = 0; i < booklist.size(); i++) {
			content[i][0] = booklist.get(i).getGenre(); // �� �ึ�� �帣�� �־��ش�.
			content[i][1] = booklist.get(i).getbName(); // �� �ึ�� å�̸� �־��ش�.
			content[i][2] = booklist.get(i).getbWriter(); // �� �ึ�� ���� �־��ش�.
			content[i][3] = booklist.get(i).getPu(); // �� �ึ�� ���ǻ� �־��ش�.
		}

		// �����Ӱ� �ǳ� ������ �� ����.
		// ���̺� ������ ���� �͸�Ŭ����
		DefaultTableModel dtable = new DefaultTableModel() {
			public boolean isCellEditable(int ro, int co) {
				return false;
			}
		};

//	    JTable table=new JTable(content,cl); //��ȣ �ȿ� (���� ����, �ڴ� ���(�÷�))	   
		JTable table = new JTable(dtable);
		dtable.setDataVector(content, cl);

		// ��ũ�� ����.
		JScrollPane scr = new JScrollPane(table); // �˻� ���â ��ũ�� ����.
		scr.setBounds(150, 150, 1100, 500);
		table.setRowHeight(25);

		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.setFont(new Font("����", Font.PLAIN, 15));

		// ���̺� Ŭ��(å Ŭ��)�ϸ� å �����ϴ� �˾����� ����
		table.addMouseListener(new BookCellEvent(this, main, m, table, mc));

		// å �˻� ��ư
		JButton sbtn = new JButton("�˻�");
		sbtn.setBackground(new Color(109, 76, 65));
		sbtn.setForeground(Color.WHITE);
		sbtn.setFont(new Font("���ʷҹ���", Font.BOLD, 23));
		sbtn.setBounds(1050, 70, 100, 40);

		// �˻� ��ư�� ������ �˻��Ǵ� ����
		sbtn.addMouseListener(new BookSearchMouse(main, this, dtable, cbb, stext, table));

		// ����Ű ������ �˻��ǵ���(�˻���ư �����Ͱ� ������) ����
		stext.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) { // ����Ű�� ���� ����(�Ʒ��� �˻���ư ���� ���� ������ ����)
				// TODO Auto-generated method stub
				int keyCord = e.getKeyCode();
				if (keyCord == 10) {
					BookController b = new BookController();
					ArrayList<Book> booklist = null;

					try {
						booklist = b.searchBook((String) cbb.getSelectedItem(), stext.getText());
					} catch (Exception x) {
						x.printStackTrace();
					}
					String[] cl = { "�帣", "������", "����", "���ǻ�" };
					String[][] content = new String[booklist.size()][4];
					for (int i = 0; i < booklist.size(); i++) {
						content[i][0] = booklist.get(i).getGenre(); // �� �ึ�� �帣�� �־��ش�.
						content[i][1] = booklist.get(i).getbName(); // �� �ึ�� å�̸� �־��ش�.
						content[i][2] = booklist.get(i).getbWriter(); // �� �ึ�� ���� �־��ش�.
						content[i][3] = booklist.get(i).getPu(); // �� �ึ�� ���ǻ� �־��ش�.
					}

					dtable.setDataVector(content, cl);
					table.setModel(dtable);
					table.getColumnModel().getColumn(0).setPreferredWidth(10);
					table.getColumnModel().getColumn(1).setPreferredWidth(300);
					table.getColumnModel().getColumn(2).setPreferredWidth(10);
					table.getColumnModel().getColumn(3).setPreferredWidth(10);
					table.setFont(new Font("����", Font.PLAIN, 15));
				}

			}
		});

		// �޺��ڽ� ���� �帣�� ���� ���������� ���̺� �ش� �帣�� å�� ��Ÿ������
		cbb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox a = (JComboBox) e.getSource();
				int index = a.getSelectedIndex();
				BookController bookcon = new BookController();

				ArrayList<Book> booklist = null;

				try {
					booklist = bookcon.selectBook(index);
				} catch (Exception x) {
					x.printStackTrace();
				}
				String[] cl = { "�帣", "������", "����", "���ǻ�" };
				String[][] content = new String[booklist.size()][4];
				for (int i = 0; i < booklist.size(); i++) {
					content[i][0] = booklist.get(i).getGenre(); // �� �ึ�� �帣�� �־��ش�.
					content[i][1] = booklist.get(i).getbName(); // �� �ึ�� å�̸� �־��ش�.
					content[i][2] = booklist.get(i).getbWriter(); // �� �ึ�� ���� �־��ش�.
					content[i][3] = booklist.get(i).getPu(); // �� �ึ�� ���ǻ� �־��ش�.
				}

				dtable.setDataVector(content, cl);
				table.setModel(dtable);
				table.getColumnModel().getColumn(0).setPreferredWidth(10);
				table.getColumnModel().getColumn(1).setPreferredWidth(300);
				table.getColumnModel().getColumn(2).setPreferredWidth(10);
				table.getColumnModel().getColumn(3).setPreferredWidth(10);
				table.setFont(new Font("����", Font.PLAIN, 15));

			}
		});

		// �ڷΰ��� ������
		ImageIcon b = new ImageIcon("back.png");
		JLabel back = new JLabel(b);
		back.setBounds(0, 0, 100, 100);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.remove(me);
				main.add(l);// ������ �α��� �ҷ����°���
				l.revalidate();
				main.repaint();
			}
		});

		add(cbb); // �帣�޺��ڽ�
		add(stext); // �˻�â
		add(sbtn); // �˻���ư
		add(scr); // ��ũ���� �߰������μ� ���̺� �߰���
		add(back); // �ڷΰ���
		main.add(this); // ���������ӿ� ���� �ǳ��� ������

	}

}