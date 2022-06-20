package com.kh.mini.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.kh.mini.model.vo.Member;

public class MemberDB {

	private HashMap <String,Member>members = new HashMap<String,Member>();//멤버를 담을 해쉬맵 생성
	
	
	public void saveMember(Member m) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("members.txt"))){
			String key = m.getId();//아이디값을 키값으로 넣음

			members.put(key,m);//해쉬맵에 멤버를 추가
			oos.writeObject(members);//해쉬맵을 members.txt에 저장
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		//return true;
	}
	public Member loadMember(String id) {
		String key = id;
		
		return members.get(key);//아이디에 해당하는 멤버객체를 반환
	}
	public void startDB() {//프로그램 시작시 호출
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("members.txt"))){
			
				members = (HashMap<String, Member>)ois.readObject();//txt파일을 해쉬맵에 저장
				
			
			
		}catch(FileNotFoundException e) {
			File f = new File("members.txt");
			try {
				f.createNewFile();
			}catch(IOException e1) {
				e.printStackTrace();
			}
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public boolean existId(String id) {//DB에 HashMap members의 키를비교
		
		String key = id;
			if (members.containsKey(key)) {
				return true;
		}
		return false;
		
	}
	public int checkPw(String id,String pw) {
		String key = id;
		if(members.containsKey(key)) {//아이디가 있는 경우
			Member m =members.get(key);
			if(m.getPw().equals(pw)) {
				return 1;//입력한 비밀번호와 DB의 비밀번호가 일치하는경우
			}else {
				return 0;//입력한 비밀번호와 DB의 비밀번호가 일치하지 않는 경우
			}
		}
		else {//아이디가 없는 경우
			return -1;
		}
		
	}
	
}
