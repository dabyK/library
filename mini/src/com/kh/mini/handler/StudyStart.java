package com.kh.mini.handler;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.mini.model.dao.StudyDB;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.Study;
import com.kh.mini.view.BackSeat;
import com.kh.mini.view.NoReserve;
import com.kh.mini.view.ReserveOk;
import com.kh.mini.view.StudyReturnFail;

public class StudyStart extends MouseAdapter {

	private JPanel now;
	private JFrame me;
	private Member m; //현재 접속한 사람
	private HashMap<Integer, Study> study; //좌석들의 객체가 모여있는 map
	private JLabel jl; //클릭한 자리의 칸(라벨)
	private Integer c; // 선택된 자리의 번호
	private JLabel spare; // 잔여좌석 현황을 보여주는 label
	private int count; // 남아있는 좌석의 수

	public StudyStart(JPanel now, JFrame me, Member m, HashMap<Integer, Study> study, JLabel jl, int c, JLabel spare,
			int count) {
		super();
		this.now = now;
		this.me = me;
		this.m = m;
		this.study = study;
		this.jl = jl;
		this.c = c;
		this.spare = spare;
		this.count = count;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 열람실 자리를 누르는 순간 자리를 예약/예약실패하는 로직
		super.mouseClicked(e);

		int count1 = 0; //
		if ((study.get(c)).getR()) { // 예약이 안되어 있다면. (현재 자리 번호에 해당하는 자리 객체의 상태가 예약 가능이라면)
			for (int i = 1; i < 47; i++) {// 자리 개수만큼 반복
				if (study.get(i).getM() != null && study.get(i).getM().equals(m)) {// 내가 다른 자리 예약했다면
					// i번호에 해당하는 자리 객체에 예약한 사람으로 저장된 사람이 있고
					// i번호에 해당하는 자리 객체에 예약한 사람이 나라면
					count1++; // count 숫자를 키움
				}
			}
			
			if (count1 == 0) { // 내가 다른 자리를 예약하지 않았다면
				jl.setOpaque(true);
				jl.setBackground(Color.red); // 자리 칸의 색을 빨강으로 바꿈
				count--; // 잔여 좌석을 1개 줄임
				study.get(c).setM(m); // 선택한 좌석 번호에 해당하는 자리 객체에 예약한 사람을 나로 저장
				study.get(c).setR(false); // 자리 객체를 예약 불가능한 상태로 저장
				count1--;
				new ReserveOk().setVisible(true); // 예약완료 팝업 호출

			} else if (count1 != 0) { // 내가 다른 자리 예약했다면
				// 한사람이 한 자리만 예약할 수 있습니다. 팝업 호출
				new NoReserve().setVisible(true);
			}

		} else { // 선택한 자리가 예약이 되어있다면.
			if ((study.get(c).getM()).equals(m)) { // 그게 바로 나였다면=좌석 반납 (선택한 좌석 객체에 예약한 사람으로 등록된게 접속중 사람과 같다면)
				jl.setOpaque(true);
				jl.setBackground(new Color(217, 229, 255));// 자리 칸의 색을 빈좌석 색으로 바꿈
				count++; // 잔여 좌석을 1개 늘림
				study.get(c).setM(null); // 해당 좌석을 빌린 사람을 없앰
				study.get(c).setR(true); // 해당 좌석을 예약 가능 상태로 저장
				count1++;
				// 반납완료되었습니다 팝업 호출
				new BackSeat().setVisible(true);

			} else { // 다른사람이 예약했따면
				new StudyReturnFail(now, me).setVisible(true);
				// 다른사람이 예약한 자리를 반납할수 없다. 팝업 호출

			}

		}
		String s = Integer.valueOf(count).toString(); // 잔여좌석의 수를 String형으로 바꿔서
		spare.setText(s + "/46"); // 잔여 좌석 label에 반영

		new StudyDB().saveMapStudy(study); // 좌석의 예약 상태 map을 파일에 저장

	}

}
