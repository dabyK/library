package com.kh.mini.model.vo;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Objects;

import com.kh.mini.view.RentFinish;



public class Member implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6561573445601738822L;
	private String id;
	private String pw;
	private String pw2;
	private String name;
	private String phone;
	private String address;
	//private List<Book> rentBook=new ArrayList<Book>();
	private Book rentBook1;
	private Book rentBook2;
	private Book rentBook3;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String id, String pw, String pw2, String name, String phone, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.pw2 = pw2;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw2() {
		return pw2;
	}
	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
//	public List<Book> getRentBook() {
//		return rentBook;
//	}
//	public void setRentBook(List<Book> rentBook) {
//		this.rentBook = rentBook;
//	}
	public Book getRentBook1() {
		return rentBook1;
	}
	public void setRentBook1(Book rentBook1) {
		this.rentBook1 = rentBook1;
	}
	public Book getRentBook2() {
		return rentBook2;
	}
	public void setRentBook2(Book rentBook2) {
		this.rentBook2 = rentBook2;
	}
	public Book getRentBook3() {
		return rentBook3;
	}
	public void setRentBook3(Book rentBook3) {
		this.rentBook3 = rentBook3;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Member) {
			Member m = (Member)o;
			if(this.id.equals(m.id)) {
				return true;
			}
		}
		return false;
	}
	

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", pw2=" + pw2 + ", name=" + name + ", phone=" + phone + ", address="
				+ address + ", rentBook1=" + rentBook1 + ", rentBook2=" + rentBook2 + ", rentBook3=" + rentBook3 + "]";
	}
	
	
	
	
	
}
