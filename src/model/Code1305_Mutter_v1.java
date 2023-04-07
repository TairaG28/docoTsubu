package model;

import java.io.Serializable;

public class Code1305_Mutter_v1 implements Serializable {

	private int id;
	private String userName; //ユーザー名
	private String text; //つぶやき内容
	private String timeStamp; //つぶやきタイムスタンプ


	public Code1305_Mutter_v1(){}
	public Code1305_Mutter_v1(String userName, String text){
		this.userName = userName;
		this.text = text;

	}

	public Code1305_Mutter_v1(int id, String userName, String text){
		this(userName,text);
		this.id = id;
	}

	public Code1305_Mutter_v1(int id, String userName, String text,String timeStamp){
		this(id,userName,text);
		this.timeStamp=timeStamp;

	}


	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getText() {
		return text;
	}

	public String getTimeStamp() {
		return timeStamp;
	}


}
