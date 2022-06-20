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

	// 게시판 내용을 파일에 저장하고 불러오는 로직들이 있는 클래스

	public void saveBoard(SBoard sb, HashMap<String, SBoard> boardss) {
		// 게시글(sb)를 boardss 맵에 저장한 후, 파일에 저장해주는 로직
		// 새글을 쓰고 나면 파일에 덮어쓰기로 저장해주는 셈
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("boards.txt"))) {
			String key = sb.getNum();
			boardss.put(key, sb); // 맵에 새로 쓴 글을 추가해 줌!

			oos.writeObject(boardss);// 저장함

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveMapBoard(HashMap<String, SBoard> boards2) {
		// 맵 자체를 보내서 파일에 저장하는 로직(덮어쓰기)
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
		// 프로그램을 시작할 때, 파일에 저장된 맵을 불러와주는 로직

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("boards.txt"))) {

			boards = (HashMap<String, SBoard>) ois.readObject();
			// 저장된 맵을 불러와 boards에 대입

		} catch (FileNotFoundException e) {
			// 불러오려는 파일이 없다면 새 파일을 만들어라
			File f = new File("boards.txt");
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} catch (EOFException e) {
			// 파일에 맵이 없는 상태라면(빈파일이라면) 맵을 새로하나 만들어라
			boards = new HashMap<String, SBoard>();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return boards;
	}

}
