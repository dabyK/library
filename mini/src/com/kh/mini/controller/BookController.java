package com.kh.mini.controller;

import java.util.ArrayList;

import javax.swing.JComboBox;

import com.kh.mini.model.dao.BookDB;
import com.kh.mini.model.vo.Book;

public class BookController {

	public ArrayList<Book> searchBook(String genre, String name) {// 선택한 장르와 이름을 받아옴
		// 책을 검색하는 메소드
		Book[] books = new BookDB().saveBook();// 저장된 책 정보들을 books 객체배열에 저장

		ArrayList<Book> blist = new ArrayList<Book>();// 저장된 책을 list에 저장해주기 위해 선언

		for (int i = 0; i < books.length; i++) { // 책 갯수만큼 for문 돌리기
			if (genre.equals("모든장르")) { // 콤보박스에서 모든장르를 선택했고
				if (books[i].getbName().contains(name)) { // 검색창에 검색한 내용이 북리스트의 이름에 포함될 때.
					blist.add(books[i]); // 리스트 저장.
				}
			} else if (!genre.equals("모든장르")) { // 모든장르가 아닐 때.

				if (genre.equals(books[i].getGenre()) && // 콤보박스에서 선택한 장르와 북리스트 장르가 동일하고
						books[i].getbName().contains(name)) { // 검색창에 검색한 내용이 북리스트의 이름에 포함될 때.
					blist.add(books[i]); // 리스트 저장.
				}
			}
		}
		return blist; // 저장된 리스트를 반환해줌

	}

	public ArrayList<Book> selectBook(int index) {
		//장르 콤보박스에서, 장르 선택만 해도 해당 장르의 책들이 게시판에 출력되는 기능
		//

		Book[] books = new BookDB().saveBook();

		ArrayList<Book> blist = new ArrayList<Book>();
		if (index == 1) {
			for (int i = 0; i < 5; i++) {//학습서일때
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

	public Book clickBook(String click) {// 매개변수 : 클릭한 책이름
		Book[] books = new BookDB().saveBook();// 책의 목록을 반환받음
		Book b = null;
		for (int i = 0; i < books.length; i++) {
			if (books[i].getbName().equals(click)) {// 클릭한 책이름이 책 목록에 있다면
				b = books[i];// 그 책을 b객체에 저장해줌
			}
		}
		return b;// 클릭한 책이름과 같은 객체를 반환

	}

}