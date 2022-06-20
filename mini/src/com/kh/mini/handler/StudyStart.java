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
	private Member m; //���� ������ ���
	private HashMap<Integer, Study> study; //�¼����� ��ü�� ���ִ� map
	private JLabel jl; //Ŭ���� �ڸ��� ĭ(��)
	private Integer c; // ���õ� �ڸ��� ��ȣ
	private JLabel spare; // �ܿ��¼� ��Ȳ�� �����ִ� label
	private int count; // �����ִ� �¼��� ��

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
		// ������ �ڸ��� ������ ���� �ڸ��� ����/��������ϴ� ����
		super.mouseClicked(e);

		int count1 = 0; //
		if ((study.get(c)).getR()) { // ������ �ȵǾ� �ִٸ�. (���� �ڸ� ��ȣ�� �ش��ϴ� �ڸ� ��ü�� ���°� ���� �����̶��)
			for (int i = 1; i < 47; i++) {// �ڸ� ������ŭ �ݺ�
				if (study.get(i).getM() != null && study.get(i).getM().equals(m)) {// ���� �ٸ� �ڸ� �����ߴٸ�
					// i��ȣ�� �ش��ϴ� �ڸ� ��ü�� ������ ������� ����� ����� �ְ�
					// i��ȣ�� �ش��ϴ� �ڸ� ��ü�� ������ ����� �����
					count1++; // count ���ڸ� Ű��
				}
			}
			
			if (count1 == 0) { // ���� �ٸ� �ڸ��� �������� �ʾҴٸ�
				jl.setOpaque(true);
				jl.setBackground(Color.red); // �ڸ� ĭ�� ���� �������� �ٲ�
				count--; // �ܿ� �¼��� 1�� ����
				study.get(c).setM(m); // ������ �¼� ��ȣ�� �ش��ϴ� �ڸ� ��ü�� ������ ����� ���� ����
				study.get(c).setR(false); // �ڸ� ��ü�� ���� �Ұ����� ���·� ����
				count1--;
				new ReserveOk().setVisible(true); // ����Ϸ� �˾� ȣ��

			} else if (count1 != 0) { // ���� �ٸ� �ڸ� �����ߴٸ�
				// �ѻ���� �� �ڸ��� ������ �� �ֽ��ϴ�. �˾� ȣ��
				new NoReserve().setVisible(true);
			}

		} else { // ������ �ڸ��� ������ �Ǿ��ִٸ�.
			if ((study.get(c).getM()).equals(m)) { // �װ� �ٷ� �����ٸ�=�¼� �ݳ� (������ �¼� ��ü�� ������ ������� ��ϵȰ� ������ ����� ���ٸ�)
				jl.setOpaque(true);
				jl.setBackground(new Color(217, 229, 255));// �ڸ� ĭ�� ���� ���¼� ������ �ٲ�
				count++; // �ܿ� �¼��� 1�� �ø�
				study.get(c).setM(null); // �ش� �¼��� ���� ����� ����
				study.get(c).setR(true); // �ش� �¼��� ���� ���� ���·� ����
				count1++;
				// �ݳ��Ϸ�Ǿ����ϴ� �˾� ȣ��
				new BackSeat().setVisible(true);

			} else { // �ٸ������ �����ߵ���
				new StudyReturnFail(now, me).setVisible(true);
				// �ٸ������ ������ �ڸ��� �ݳ��Ҽ� ����. �˾� ȣ��

			}

		}
		String s = Integer.valueOf(count).toString(); // �ܿ��¼��� ���� String������ �ٲ㼭
		spare.setText(s + "/46"); // �ܿ� �¼� label�� �ݿ�

		new StudyDB().saveMapStudy(study); // �¼��� ���� ���� map�� ���Ͽ� ����

	}

}
