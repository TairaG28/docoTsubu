package model;

import java.io.Serializable;

public class Code1001_User implements Serializable {

	private String name; //ユーザー名
	private String pass; //　パスワード

	public Code1001_User(){}
	public Code1001_User(String name, String pass){

		this.name = name;
		this.pass = pass;

	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}


}
