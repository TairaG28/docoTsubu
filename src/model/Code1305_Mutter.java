package model;

import java.io.Serializable;

public class Code1305_Mutter implements Serializable {

	private int id;
	private String userName; //ユーザー名
	private String text; //つぶやき内容
	private String timeStamp; //つぶやきタイムスタンプ
	private String email;

	public Code1305_Mutter(){}

	public Code1305_Mutter(String userName, String text){
		this.userName = userName;
		this.text = text;

	}

	//つぶやき入力用
	public Code1305_Mutter(String userName, String text,String email){
		this(userName,text);
		this.email =email;
	}


	//つぶやき出力用
	public Code1305_Mutter(int id, String userName, String text,String timeStamp,String email){
		this(userName,text,email);
		this.id = id;
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

	public String getEmail() {
		return email;
	}


}
