package com.kh.mini.controller;

import com.kh.mini.model.dao.MemberDB;
import com.kh.mini.model.vo.Member;

public class MemberController {

	private MemberDB md = new MemberDB();
	public void startDB() {//���α׷������� �� members.txt���Ͽ� �ִ� ȸ�������� DB�ؽ��ʿ� ����ִ°�
		md.startDB();
		
	}
	

	public void saveMember(Member u) {
		md.saveMember(u);
	}
	public boolean existId(String id) {
		return md.existId(id);
	}
	public int checkPw(String id,String pw) {
		return md.checkPw(id,pw);
	}
	public Member loadMember(String id) {
		return md.loadMember(id);
	}
}
