package model;

public class Code1004_LoginLogic {

	public boolean execute(Code1001_User user){

		if(user.getPass().equals("1234")){ return true;}

		return false;

	}


}
