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
	
    //��� ����ִ� �¼���. �ƹ��� �������� �ʾ��� �� �⺻��. 
	HashMap<Integer, Study> study = new HashMap<Integer, Study>();
	
	public HashMap<Integer, Study> studySeat() {
		//�¼��� ������°� ���� ������, �⺻���� ���� ������ִ� ����
		for (int i = 1; i < 47; i++) {
			//47���� �¼��� ���� Ű�� ��ü�� �Ҵ�����, ���⼭ key�� �ڸ� ��ȣ(����)
			study.put(i, new Study(null, true));//���,�ڸ�
		}
		return study;
	}
	
	
	//������ ���� study�� ����.
	public void saveMapStudy(HashMap<Integer, Study> study) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Study.txt"))) {

			oos.writeObject(study);
			//������ ���� ���Ͽ� �����ϱ�

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//���α׷��� �������� ��, �⺻ �¼����¸� �ҷ����� ����
	public HashMap<Integer, Study> startSTD() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Study.txt"))) {
			study = (HashMap<Integer, Study>) ois.readObject();
			//���Ͽ� ����Ǿ� �ִ� ���� study�� ������ ��ȯ����

		} catch (FileNotFoundException e) {
			//���� ������ ���ٸ�, ���� ������ֱ�
			File f = new File("Study.txt");
			try {
				f.createNewFile();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			//���� ���� ��, �⺻ �¼� ���µ� ������ֱ�(���� �޼ҵ� �ҷ��� ����) - ������� ���Ͽ��� �¼� ���°� �����Ƿ�
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
