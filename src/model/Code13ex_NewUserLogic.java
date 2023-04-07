package model;

import dao.Code13ex_UserDAO;

public class Code13ex_NewUserLogic {

	public boolean execute(Code13ex_LoginEnt loginEnt){

		Code13ex_UserDAO dao = new Code13ex_UserDAO();
		return dao.create(loginEnt);

	}


}
