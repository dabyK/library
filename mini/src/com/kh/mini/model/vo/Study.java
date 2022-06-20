package com.kh.mini.model.vo;

import java.io.Serializable;

import javax.swing.JLabel;

public class Study implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2213932572946802226L;
	private Member m; //자리를 빌린 사람
	private boolean r; //자리를 빌릴 수 있는지 (true:예약가능,false:예약 불가)

	public Study() {

	}

	public Study(Member m, boolean r) {
		super();
		this.m = m;
		this.r = r;
	}

	public Member getM() {
		return m;
	}

	public void setM(Member m) {
		this.m = m;
	}

	public boolean getR() {
		return r;
	}

	public void setR(boolean r) {
		this.r = r;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m == null) ? 0 : m.hashCode());
		result = prime * result + (r ? 1231 : 1237);
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
		Study other = (Study) obj;
		if (m == null) {
			if (other.m != null)
				return false;
		} else if (!m.equals(other.m))
			return false;
		if (r != other.r)
			return false;
		return true;
	}

}
