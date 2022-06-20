package com.kh.mini.controller;

import java.util.ArrayList;

import javax.swing.JComboBox;

import com.kh.mini.model.dao.BookDB;
import com.kh.mini.model.vo.Book;

public class BookController {

	public ArrayList<Book> searchBook(String genre, String name) {// ������ �帣�� �̸��� �޾ƿ�
		// å�� �˻��ϴ� �޼ҵ�
		Book[] books = new BookDB().saveBook();// ����� å �������� books ��ü�迭�� ����

		ArrayList<Book> blist = new ArrayList<Book>();// ����� å�� list�� �������ֱ� ���� ����

		for (int i = 0; i < books.length; i++) { // å ������ŭ for�� ������
			if (genre.equals("����帣")) { // �޺��ڽ����� ����帣�� �����߰�
				if (books[i].getbName().contains(name)) { // �˻�â�� �˻��� ������ �ϸ���Ʈ�� �̸��� ���Ե� ��.
					blist.add(books[i]); // ����Ʈ ����.
				}
			} else if (!genre.equals("����帣")) { // ����帣�� �ƴ� ��.

				if (genre.equals(books[i].getGenre()) && // �޺��ڽ����� ������ �帣�� �ϸ���Ʈ �帣�� �����ϰ�
						books[i].getbName().contains(name)) { // �˻�â�� �˻��� ������ �ϸ���Ʈ�� �̸��� ���Ե� ��.
					blist.add(books[i]); // ����Ʈ ����.
				}
			}
		}
		return blist; // ����� ����Ʈ�� ��ȯ����

	}

	public ArrayList<Book> selectBook(int index) {
		//�帣 �޺��ڽ�����, �帣 ���ø� �ص� �ش� �帣�� å���� �Խ��ǿ� ��µǴ� ���
		//

		Book[] books = new BookDB().saveBook();

		ArrayList<Book> blist = new ArrayList<Book>();
		if (index == 1) {
			for (int i = 0; i < 5; i++) {//�н����϶�
				blist.add(books[i]);

			}
		} else if (index == 2) {
			for (int i = 5; i < 10; i++) {
				blist.add(books[i]);

			}
		} else if (index == 3) {
			for (int i = 10; i < 15; i++) {
				blist.add(books[i]);

			}
		} else if (index == 4) {
			for (int i = 15; i < 20; i++) {
				blist.add(books[i]);

			}
		} else if (index == 5) {
			for (int i = 20; i < 25; i++) {
				blist.add(books[i]);

			}
		} else if (index == 6) {
			for (int i = 25; i < 30; i++) {
				blist.add(books[i]);

			}
		} else if (index == 7) {
			for (int i = 30; i < 35; i++) {
				blist.add(books[i]);

			}
		} else if (index == 8) {
			for (int i = 35; i < 40; i++) {
				blist.add(books[i]);

			}
		} else if (index == 9) {
			for (int i = 40; i < 45; i++) {
				blist.add(books[i]);

			}
		}
		return blist;
	}

	public Book clickBook(String click) {// �Ű����� : Ŭ���� å�̸�
		Book[] books = new BookDB().saveBook();// å�� ����� ��ȯ����
		Book b = null;
		for (int i = 0; i < books.length; i++) {
			if (books[i].getbName().equals(click)) {// Ŭ���� å�̸��� å ��Ͽ� �ִٸ�
				b = books[i];// �� å�� b��ü�� ��������
			}
		}
		return b;// Ŭ���� å�̸��� ���� ��ü�� ��ȯ

	}

}