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

public class SBoardDB {

	private HashMap<String, SBoard> boards/* = new HashMap<String, SBoard>() */;

	// �Խ��� ������ ���Ͽ� �����ϰ� �ҷ����� �������� �ִ� Ŭ����

	public void saveBoard(SBoard sb, HashMap<String, SBoard> boardss) {
		// �Խñ�(sb)�� boardss �ʿ� ������ ��, ���Ͽ� �������ִ� ����
		// ������ ���� ���� ���Ͽ� ������ �������ִ� ��
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("boards.txt"))) {
			String key = sb.getNum();
			boardss.put(key, sb); // �ʿ� ���� �� ���� �߰��� ��!

			oos.writeObject(boardss);// ������

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveMapBoard(HashMap<String, SBoard> boards2) {
		// �� ��ü�� ������ ���Ͽ� �����ϴ� ����(�����)
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("boards.txt"))) {

			oos.writeObject(boards2);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public SBoard loadBoard(String num) {
//		String key = num;
//		return  boards.get(key);
//
//	}

	public HashMap<String, SBoard> startBDB() {
		// ���α׷��� ������ ��, ���Ͽ� ����� ���� �ҷ����ִ� ����

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("boards.txt"))) {

			boards = (HashMap<String, SBoard>) ois.readObject();
			// ����� ���� �ҷ��� boards�� ����

		} catch (FileNotFoundException e) {
			// �ҷ������� ������ ���ٸ� �� ������ ������
			File f = new File("boards.txt");
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} catch (EOFException e) {
			// ���Ͽ� ���� ���� ���¶��(�������̶��) ���� �����ϳ� ������
			boards = new HashMap<String, SBoard>();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return boards;
	}

}
