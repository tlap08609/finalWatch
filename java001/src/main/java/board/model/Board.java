package board.model;

import java.io.Reader;
import java.sql.Clob;

public class Board {
	int no;
	String name;
	String mail;
	String time;
	String mainText;
	Clob comment;
	
	
	
	public Board() {
		super();
	}
	public Board(int key) {
		no = key;
	}

	public Board(int no, String name, String mail, String time, String mainText) {
		super();
		this.no = no;
		this.name = name;
		this.mail = mail;
		this.time = time;
		this.mainText = mainText;
	}
	
	public Board(String name, String mail, String time, String mainText) {
		super();
		this.name = name;
		this.mail = mail;
		this.time = time;
		this.mainText = mainText;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMainText() {
		return mainText;
	}
	public void setMainText(String mainText) {
		this.mainText = mainText;
	}
	public Clob getComment() {
		return comment;
	}
	public void setComment(Clob comment) {
		this.comment = comment;
	}
	public String getStringComment() {
		String msg = null;
		try {
			Reader reader = comment.getCharacterStream();
			int size = (int) comment.length();
			char[] ca = new char[size];
			reader.read(ca);
            msg = new String(ca); 
		} catch (Exception e) {
			System.out.println(e);
		}
		return msg;
	}
	

}
