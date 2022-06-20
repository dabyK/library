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
	// 열람실 좌석 현황을 보여주는 메인 판넬

	private JPanel now; // 현재 판넬
	private JFrame main; // 메인 프레임
	private Member m; // 접속한 사람
	private HashMap<Integer, Study> study; // 좌석객체들이 저장된 맵
	private int count; // 잔여 좌석 수
	private StudyRoomMain me; // 자신의 판넬

	public StudyRoomMain(JPanel now, JFrame main, Member m) {
		this.now = now;
		this.main = main;
		this.m = m;
		me = this;

		setLayout(null); // 널레이아웃
		setBounds(200, 200, 300, 300); // 판넬 크기와 위치
		setBackground(new Color(215, 204, 200)); // 배경색

		// 시작할 때, 저장된 좌석 상태 파일에서 불러옴
		study = new StudyDB().startSTD();

		// 열람실 현황 맨 위에 떠 있는 글자
		JLabel title = new JLabel("환★열람실 현황★영");
		title.setFont(new Font("함초롬바탕", Font.BOLD, 23));
		title.setBounds(600, 10, 500, 50);

		// 예약가능/불가 좌석 색 표시 이미지
		ImageIcon aaa1 = new ImageIcon("좌석.jpg");
		JLabel aaa = new JLabel(aaa1);
		aaa.setBounds(1050, 30, 200, 200);

		// 잔여 좌석 세서 반영하는 라벨
		for (int i = 1; i < 47; i++) {
			if (study.get(i).getR()) { // map에 저장된 좌석 객체들을 불러와, 예약 가능 상태인지 확인
				count++; // 예약 가능하다면 count 숫자 1개씩 늘림(=잔여 좌석 수)
			}
		}
		String s = Integer.valueOf(count).toString();

		JLabel spare = new JLabel(s + "/46"); // 잔여 좌석 라벨
		spare.setFont(new Font("함초롬바탕", Font.BOLD, 23));
		spare.setBounds(50, 10, 200, 200);

		// 뒤로 가기 버튼
		ImageIcon b = new ImageIcon("back.png");
		JLabel back = new JLabel(b);
		back.setBounds(0, 0, 100, 100);
		// 버튼 누르면 이전화면 호출
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				main.remove(me);
				main.add(now);// 기존의 로그인 불러오는거임
				now.revalidate();
				main.repaint();
			}
		});

		add(title); // 제목
		// 좌석 그리드 4개 추가해줌
		add(new StudyGrid1(now, main, m, study, spare, count)); // 현재 판넬, 메인프레임, 접속한 사람, 좌석객체map, 잔여좌석 라벨, 잔여좌석 수 보내줌
		add(new StudyGrid2(now, main, m, study, spare, count));
		add(new StudyGrid3(now, main, m, study, spare, count));
		add(new StudyGrid4(now, main, m, study, spare, count));
		add(aaa);// 예약 가능/불가 좌석 색상 안내 이미지
		add(spare); // 잔여좌석 표시 라벨
		add(back); // 뒤로가기

	}

}
