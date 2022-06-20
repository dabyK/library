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
	// 열람실 좌석을 표시하는 그리드 1번(1번부터 10번 자리까지)

	private JPanel now; // 현재 판넬
	private JFrame main; // 메인 프레임
	private Member m; // 접속한 사람
	private JLabel jl; // 좌석 라벨들
	private HashMap<Integer, Study> study; // 좌석의 객체가 모여있는 map
	private JLabel spare; // 잔여 좌석 표시 라벨
	private int count; // 잔여좌석 수

	public StudyGrid1(JPanel now, JFrame main, Member m, HashMap<Integer, Study> study, JLabel spare, int count) {
		super();
		this.now = now;
		this.main = main;
		this.m = m;
		this.study = study;
		this.spare = spare;
		this.count = count;

		setLayout(new GridLayout(2, 5, 5, 5)); // 세로로 두칸, 가로로 5칸, 서로 5씩 떨어진 그리드 만듬
		setBounds(300, 100, 400, 150); // 그리드의 총 크기

		// JLabel배열을 통해 칸별 좌석번호 할당하기
		// JLabel이 좌석 번호가 적힌 한칸 한칸의 자리가 됨
		HashMap<Integer, JLabel> jmap = new HashMap<Integer, JLabel>();

		for (int i = 1; i <= 10; i++) {
			String su = Integer.valueOf(i).toString(); // 좌석 번호가 될 i를 String으로 변환
			jmap.put(i, new JLabel(su, (int) CENTER_ALIGNMENT)); // 좌석 라벨의 map에 현재 좌석 번호를 추가(1번 좌석에 1이라는 숫자 부여)
			// 라벨을 가운데로 설정해주는 기능
			jmap.get(i).setBorder(new MatteBorder(1, 1, 1, 1, Color.black)); // 좌석칸에 테두리 설정
			jmap.get(i).setOpaque(true);// 투명도 없게

			if (study.get(i).getR()) { // 좌석 번호에 해당하는 좌석 객체가 예약되지 않은 상태라면(r은 예약 가능일때 true)
				jmap.get(i).setBackground(new Color(217, 229, 255)); // 예약 가능 색상 부여
			} else {
				jmap.get(i).setBackground(Color.red); // 예약 불가 색상 부여
			}
			this.add(jmap.get(i)); // 현재 판넬에 좌석 label 추가
		}

		for (int i = 1; i <= 10; i++) { // 열칸의 좌석
			int c = i; // 좌석을 누르면 예약 시스템으로 이동 (c는 현재 선택된 좌석의 번호가 됨!)
			jmap.get(i).addMouseListener(new StudyStart(now, main, m, study, jmap.get(i), c, spare, count));
			// 현재 판넬, 메인프레임, 접속한 사람, 좌석객체가 저장된 map, 현재 선택된 좌석, 현재 선택된 좌석의 번호, 잔여좌석 출력 라벨,
			// 잔여좌석 보내줌
		}

	}

}
