package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.mini.model.dao.StudyDB;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.Study;

public class StudyRoomMain extends JPanel {
	// ������ �¼� ��Ȳ�� �����ִ� ���� �ǳ�

	private JPanel now; // ���� �ǳ�
	private JFrame main; // ���� ������
	private Member m; // ������ ���
	private HashMap<Integer, Study> study; // �¼���ü���� ����� ��
	private int count; // �ܿ� �¼� ��
	private StudyRoomMain me; // �ڽ��� �ǳ�

	public StudyRoomMain(JPanel now, JFrame main, Member m) {
		this.now = now;
		this.main = main;
		this.m = m;
		me = this;

		setLayout(null); // �η��̾ƿ�
		setBounds(200, 200, 300, 300); // �ǳ� ũ��� ��ġ
		setBackground(new Color(215, 204, 200)); // ����

		// ������ ��, ����� �¼� ���� ���Ͽ��� �ҷ���
		study = new StudyDB().startSTD();

		// ������ ��Ȳ �� ���� �� �ִ� ����
		JLabel title = new JLabel("ȯ�ڿ����� ��Ȳ�ڿ�");
		title.setFont(new Font("���ʷҹ���", Font.BOLD, 23));
		title.setBounds(600, 10, 500, 50);

		// ���డ��/�Ұ� �¼� �� ǥ�� �̹���
		ImageIcon aaa1 = new ImageIcon("�¼�.jpg");
		JLabel aaa = new JLabel(aaa1);
		aaa.setBounds(1050, 30, 200, 200);

		// �ܿ� �¼� ���� �ݿ��ϴ� ��
		for (int i = 1; i < 47; i++) {
			if (study.get(i).getR()) { // map�� ����� �¼� ��ü���� �ҷ���, ���� ���� �������� Ȯ��
				count++; // ���� �����ϴٸ� count ���� 1���� �ø�(=�ܿ� �¼� ��)
			}
		}
		String s = Integer.valueOf(count).toString();

		JLabel spare = new JLabel(s + "/46"); // �ܿ� �¼� ��
		spare.setFont(new Font("���ʷҹ���", Font.BOLD, 23));
		spare.setBounds(50, 10, 200, 200);

		// �ڷ� ���� ��ư
		ImageIcon b = new ImageIcon("back.png");
		JLabel back = new JLabel(b);
		back.setBounds(0, 0, 100, 100);
		// ��ư ������ ����ȭ�� ȣ��
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.remove(me);
				main.add(now);// ������ �α��� �ҷ����°���
				now.revalidate();
				main.repaint();
			}
		});

		add(title); // ����
		// �¼� �׸��� 4�� �߰�����
		add(new StudyGrid1(now, main, m, study, spare, count)); // ���� �ǳ�, ����������, ������ ���, �¼���ümap, �ܿ��¼� ��, �ܿ��¼� �� ������
		add(new StudyGrid2(now, main, m, study, spare, count));
		add(new StudyGrid3(now, main, m, study, spare, count));
		add(new StudyGrid4(now, main, m, study, spare, count));
		add(aaa);// ���� ����/�Ұ� �¼� ���� �ȳ� �̹���
		add(spare); // �ܿ��¼� ǥ�� ��
		add(back); // �ڷΰ���

	}

}
