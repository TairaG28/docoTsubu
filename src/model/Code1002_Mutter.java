package model;

import java.io.Serializable;

public class Code1002_Mutter implements Serializable {

	private String userName; //ユーザー名
	private String text; //つぶやき内容

	public Code1002_Mutter(){}
	public Code1002_Mutter(String userName, String text){
		this.userName = userName;
		this.text = text;

	}



	public String getUserName() {
		return userName;
	}

	public String getText() {
		return text;
	}



}
