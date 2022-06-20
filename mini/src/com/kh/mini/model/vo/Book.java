package com.kh.mini.model.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Book implements Serializable {
	//책 객체
	/**
	 * 
	 */
	private static final long serialVersionUID = -6575686002434046316L;
	private String bName; //책 이름
	private String bWriter; //글쓴이
	private String pu; //출판사
	private String genre; //장르
	private String bookNum; //책번호=책 이미지
	private String rentDate; //빌린 날짜
	private String backDate; //반납 날짜

	public Book() {

	}

	public Book(String bName, String bWriter, String pu, String genre, String bookNum, String rentDate,
			String backDate) {
		super();
		this.bName = bName;
		this.bWriter = bWriter;
		this.pu = pu;
		this.genre = genre;
		this.bookNum = bookNum;
		this.rentDate = rentDate;
		this.backDate = backDate;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getPu() {
		return pu;
	}

	public void setPu(String pu) {
		this.pu = pu;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getBookNum() {
		return bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {

		this.rentDate = rentDate;
	}

	public String getBackDate() {
		return backDate;
	}

	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}

	@Override
	public String toString() {
		return "Book [bName=" + bName + ", bWriter=" + bWriter + ", pu=" + pu + ", genre=" + genre + ", bookNum="
				+ bookNum + ", rentDate=" + rentDate + ", backDate=" + backDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bName == null) ? 0 : bName.hashCode());
		result = prime * result + ((bWriter == null) ? 0 : bWriter.hashCode());
		result = prime * result + ((backDate == null) ? 0 : backDate.hashCode());
		result = prime * result + ((bookNum == null) ? 0 : bookNum.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((pu == null) ? 0 : pu.hashCode());
		result = prime * result + ((rentDate == null) ? 0 : rentDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bName == null) {
			if (other.bName != null)
				return false;
		} else if (!bName.equals(other.bName))
			return false;
		if (bWriter == null) {
			if (other.bWriter != null)
				return false;
		} else if (!bWriter.equals(other.bWriter))
			return false;
		if (backDate == null) {
			if (other.backDate != null)
				return false;
		} else if (!backDate.equals(other.backDate))
			return false;
		if (bookNum == null) {
			if (other.bookNum != null)
				return false;
		} else if (!bookNum.equals(other.bookNum))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (pu == null) {
			if (other.pu != null)
				return false;
		} else if (!pu.equals(other.pu))
			return false;
		if (rentDate == null) {
			if (other.rentDate != null)
				return false;
		} else if (!rentDate.equals(other.rentDate))
			return false;
		return true;
	}

}
