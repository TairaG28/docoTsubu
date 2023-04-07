package model;

import java.io.Serializable;

public class Code13ex_UserEnt implements Serializable {

	private String name; //ユーザー名
	private String pass; //　パスワード
	private String email; //　パスワード

	public Code13ex_UserEnt(){}
	public Code13ex_UserEnt(String name, String pass,String email){

		this.name = name;
		this.pass = pass;
		this.email = email;

	}


	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}

	public String getEmail() {
		return email;
	}


}
