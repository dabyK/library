package com.kh.mini.controller;

import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kh.mini.model.dao.SBoardDB;
import com.kh.mini.model.vo.Member;
import com.kh.mini.model.vo.SBoard;

public class BoardController {

	public SBoard ClickBoard(HashMap<String, SBoard> boards, String num) {// 게시글이 저장된 맵과 게시글 번호를 받아옴
		// 게시글을 조회할 수 있도록 도와주는 메소드
		// 보내준 맵과 숫자(게시글 번호)를 통해, 게시글을 클릭한 순간
		// 게시글map에서 그 게시글 번호(key)에 해당하는 board객체(글)을 리턴해주기
		return boards.get(num);

	}

	public boolean removePost(Member m, SBoard sb, HashMap<String, SBoard> boards, JTable table, int row) {
		// 접속해있는 사람정보, 클릭한 게시글, 게시글이 저장된 맵, 현재 게시글이 띄워져있는 테이블, 클릭한 행의 번호를 받아옴

		// 게시글을 삭제할 때, 글쓴 사람과 삭제하려는 사람이 같은지 확인해주고 /
		// 삭제했다면 삭제된 상태를 파일에 저장하고
		// 테이블에 반영하는 메소드

		if (sb.getWriter().equals(m.getId())) {// 글쓴 사람과, 삭제를 시도한 사람이 같다면
			boards.remove(sb.getNum(), sb);// 그 글 번호에 해당하는 글을 맵에서 삭제해라

			new SBoardDB().saveMapBoard(boards);// 해당 글이 삭제된 맵을 파일에 덮어써라(저장)
			DefaultTableModel model = (DefaultTableModel) table.getModel();// 현재 테이블 상태를 불러와서
			model.removeRow(row);// 삭제를 시도한 글의 행을 테이블에서 삭제해라(테이블에서 글을 삭제해라)
		} else {
			return false;
		}
		return true;

	}
}
