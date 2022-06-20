package com.kh.mini.handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.kh.mini.controller.MemberController;
import com.kh.mini.model.vo.Book;
import com.kh.mini.model.vo.Member;
import com.kh.mini.view.BookClick;
import com.kh.mini.view.RentFinish;

public class BookRent extends MouseAdapter {// �����ϱ� �������� �̺�Ʈ

	private Member m; //���� ������ ���
	private Book b; //å ��ü
	private MemberController mc; 
	private BookClick bc; //���� �˾�(å ����Ŭ���ϸ� �ߴ� å ����, å �����ϱ� ��ư�� �ִ� �˾�)

	public BookRent(BookClick bc, Member m, Book b, MemberController mc) {
		this.bc = bc;
		this.mc = mc;
		this.m = m;
		this.b = b;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		super.mouseClicked(e);

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());// ���� ��¥ �ð����� ������
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // ��¥ ��� ���� ����
		String rentDate = df.format(cal.getTime()); // rentDate ������, �� �������� ���� ��¥ ����

		cal.add(Calendar.DATE, 7);// ���� ��¥�� 7���� ���Ѵ�.
		String backDate = df.format(cal.getTime()); // backDate ������, �� �������� 7�� �� ��¥(�ݳ���¥) ����

		b.setRentDate(rentDate);// �ش� å ��ü�� �뿩��¥�� ���� ��¥�� ����
		b.setBackDate(backDate);// �ش� å ��ü�� �ݳ���¥�� 7�� �� ��¥�� ����

		boolean rent = true; // �뿩�� �⺻������ �������·� ����

		if (m != null) { // ���� ������ ����� ������ ���� ��
			if (m.getRentBook1() == null) { // ������ ����� �뿩��å1�� ����ִٸ�
				m.setRentBook1(b); // �ش� å�� ������ ����� ������ ����

			} else if (m.getRentBook2() == null) { // ������ ����� �뿩��å2�� ����ִٸ�
				m.setRentBook2(b); // �ش� å�� ������ ����� ������ ����
			} else if (m.getRentBook3() == null) { // ������ ����� �뿩��å3�� ����ִٸ�
				m.setRentBook3(b); // �ش� å�� ������ ����� ������ ����
			} else { // �� �� �ƴ϶�� rent�� false�� ����(�뿩 ���з� ����)
				rent = false;
			}
		} else { // ���� ������ ����� ������ ���ٸ� rent�� false�� ����(�뿩 ���з� ����)
			rent = false;
		}
		mc.saveMember(m);// �������Ŀ� ȸ����ü�� ���Ͽ� ����
		new RentFinish(bc, rent, b).setVisible(true); // ���� �Ϸ� or ���� �Ұ��� ������ �˾��� ȣ��
	}

}
