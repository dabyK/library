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

	private HashMap <String,Member>members = new HashMap<String,Member>();//����� ���� �ؽ��� ����
	
	
	public void saveMember(Member m) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("members.txt"))){
			String key = m.getId();//���̵��� Ű������ ����

			members.put(key,m);//�ؽ��ʿ� ����� �߰�
			oos.writeObject(members);//�ؽ����� members.txt�� ����
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		//return true;
	}
	public Member loadMember(String id) {
		String key = id;
		
		return members.get(key);//���̵� �ش��ϴ� �����ü�� ��ȯ
	}
	public void startDB() {//���α׷� ���۽� ȣ��
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("members.txt"))){
			
				members = (HashMap<String, Member>)ois.readObject();//txt������ �ؽ��ʿ� ����
				
			
			
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

	public boolean existId(String id) {//DB�� HashMap members�� Ű����
		
		String key = id;
			if (members.containsKey(key)) {
				return true;
		}
		return false;
		
	}
	public int checkPw(String id,String pw) {
		String key = id;
		if(members.containsKey(key)) {//���̵� �ִ� ���
			Member m =members.get(key);
			if(m.getPw().equals(pw)) {
				return 1;//�Է��� ��й�ȣ�� DB�� ��й�ȣ�� ��ġ�ϴ°��
			}else {
				return 0;//�Է��� ��й�ȣ�� DB�� ��й�ȣ�� ��ġ���� �ʴ� ���
			}
		}
		else {//���̵� ���� ���
			return -1;
		}
		
	}
	
}
