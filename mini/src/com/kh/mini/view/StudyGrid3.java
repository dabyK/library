package com.kh.mini.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.kh.mini.handler.StudyStart;
import com.kh.mini.model.dao.StudyDB;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.Study;

public class StudyGrid3 extends JPanel {
	// 열람실 좌석을 표시하는 그리드 3번(21번부터 30번 자리까지)
	// 로직은 grid1과 동일

	private JPanel now;
	private JFrame main;
	private Member m;
	private HashMap<Integer, Study> study;
	private JLabel spare;
	private int count;

	public StudyGrid3(JPanel now, JFrame main, Member m, HashMap<Integer, Study> study, JLabel spare, int count) {
		super();
		this.now = now;
		this.main = main;
		this.m = m;
		this.study = study;
		this.spare = spare;
		this.count = count;

		setLayout(new GridLayout(2, 5, 5, 5));
		setBounds(300, 500, 400, 150);

		HashMap<Integer, JLabel> jmap = new HashMap<Integer, JLabel>();

		for (int i = 21; i < 31; i++) {
			String su = Integer.valueOf(i).toString();
			jmap.put(i, new JLabel(su, (int) CENTER_ALIGNMENT));
			jmap.get(i).setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
			jmap.get(i).setOpaque(true);

			if (study.get(i).getR()) {
				jmap.get(i).setBackground(new Color(217, 229, 255));
			} else {
				jmap.get(i).setBackground(Color.red);

			}

			this.add(jmap.get(i));
		}

		for (int i = 21; i < 31; i++) {
			int c = i;

			jmap.get(i).addMouseListener(new StudyStart(now, main, m, study, jmap.get(i), c, spare, count));
		}
	}

}
