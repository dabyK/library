package com.kh.mini.model.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.kh.mini.model.vo.SBoard;
import com.kh.mini.model.vo.Study;

public class StudyDB {
	
    //모두 비어있는 좌석들. 아무도 예약하지 않았을 때 기본값. 
	HashMap<Integer, Study> study = new HashMap<Integer, Study>();
	
	public HashMap<Integer, Study> studySeat() {
		//좌석의 예약상태가 전혀 없을때, 기본상태 맵을 만들어주는 로직
		for (int i = 1; i < 47; i++) {
			//47개의 좌석에 각각 키와 객체를 할당해줌, 여기서 key는 자리 번호(숫자)
			study.put(i, new Study(null, true));//멤버,자리
		}
		return study;
	}
	
	
	//파일을 만들어서 study맵 저장.
	public void saveMapStudy(HashMap<Integer, Study> study) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Study.txt"))) {

			oos.writeObject(study);
			//보내준 맵을 파일에 저장하기

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//프로그램을 시작했을 때, 기본 좌석상태를 불러오는 로직
	public HashMap<Integer, Study> startSTD() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Study.txt"))) {
			study = (HashMap<Integer, Study>) ois.readObject();
			//파일에 저장되어 있던 맵을 study에 저장해 반환해줌

		} catch (FileNotFoundException e) {
			//만약 파일이 없다면, 새로 만들어주기
			File f = new File("Study.txt");
			try {
				f.createNewFile();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//새로 만든 후, 기본 좌석 상태도 배당해주기(위의 메소드 불러와 실행) - 만들어진 파일에는 좌석 상태가 없으므로
			studySeat();
			
		} catch (EOFException e) {
			
		
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return study;
	}

	
	
}
