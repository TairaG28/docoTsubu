package model;

public class Code13ex_LoginEnt {

	private String name;
	private String email; //　パスワード
	private String pass; //　パスワード

	public Code13ex_LoginEnt(){}

	//ログイン時、退会時
	public Code13ex_LoginEnt(String email, String pass){

		this.email = email;
		this.pass = pass;

	}


	//登録時
	public Code13ex_LoginEnt(String name, String email, String pass){

		this(email,pass);
		this.name=name;

	}


	public String getEmail() {
		return email;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
