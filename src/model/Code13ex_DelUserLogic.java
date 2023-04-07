package model;

import dao.Code13ex_UserDAO;

public class Code13ex_DelUserLogic {

	public boolean execute(Code13ex_LoginEnt loginEnt){

		Code13ex_UserDAO dao = new Code13ex_UserDAO();
		return dao.remove(loginEnt);

	}

}
