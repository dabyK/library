package com.kh.mini.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.kh.mini.handler.StudyStart;
import com.kh.mini.model.dao.StudyDB;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.Study;

public class StudyGrid1 extends JPanel {
	// ������ �¼��� ǥ���ϴ� �׸��� 1��(1������ 10�� �ڸ�����)

	private JPanel now; // ���� �ǳ�
	private JFrame main; // ���� ������
	private Member m; // ������ ���
	private JLabel jl; // �¼� �󺧵�
	private HashMap<Integer, Study> study; // �¼��� ��ü�� ���ִ� map
	private JLabel spare; // �ܿ� �¼� ǥ�� ��
	private int count; // �ܿ��¼� ��

	public StudyGrid1(JPanel now, JFrame main, Member m, HashMap<Integer, Study> study, JLabel spare, int count) {
		super();
		this.now = now;
		this.main = main;
		this.m = m;
		this.study = study;
		this.spare = spare;
		this.count = count;

		setLayout(new GridLayout(2, 5, 5, 5)); // ���η� ��ĭ, ���η� 5ĭ, ���� 5�� ������ �׸��� ����
		setBounds(300, 100, 400, 150); // �׸����� �� ũ��

		// JLabel�迭�� ���� ĭ�� �¼���ȣ �Ҵ��ϱ�
		// JLabel�� �¼� ��ȣ�� ���� ��ĭ ��ĭ�� �ڸ��� ��
		HashMap<Integer, JLabel> jmap = new HashMap<Integer, JLabel>();

		for (int i = 1; i <= 10; i++) {
			String su = Integer.valueOf(i).toString(); // �¼� ��ȣ�� �� i�� String���� ��ȯ
			jmap.put(i, new JLabel(su, (int) CENTER_ALIGNMENT)); // �¼� ���� map�� ���� �¼� ��ȣ�� �߰�(1�� �¼��� 1�̶�� ���� �ο�)
			// ���� ����� �������ִ� ���
			jmap.get(i).setBorder(new MatteBorder(1, 1, 1, 1, Color.black)); // �¼�ĭ�� �׵θ� ����
			jmap.get(i).setOpaque(true);// ���� ����

			if (study.get(i).getR()) { // �¼� ��ȣ�� �ش��ϴ� �¼� ��ü�� ������� ���� ���¶��(r�� ���� �����϶� true)
				jmap.get(i).setBackground(new Color(217, 229, 255)); // ���� ���� ���� �ο�
			} else {
				jmap.get(i).setBackground(Color.red); // ���� �Ұ� ���� �ο�
			}
			this.add(jmap.get(i)); // ���� �ǳڿ� �¼� label �߰�
		}

		for (int i = 1; i <= 10; i++) { // ��ĭ�� �¼�
			int c = i; // �¼��� ������ ���� �ý������� �̵� (c�� ���� ���õ� �¼��� ��ȣ�� ��!)
			jmap.get(i).addMouseListener(new StudyStart(now, main, m, study, jmap.get(i), c, spare, count));
			// ���� �ǳ�, ����������, ������ ���, �¼���ü�� ����� map, ���� ���õ� �¼�, ���� ���õ� �¼��� ��ȣ, �ܿ��¼� ��� ��,
			// �ܿ��¼� ������
		}

	}

}
