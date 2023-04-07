package model;

import dao.Code13ex_UserDAO;

public class Code13ex_LoginLogic {

	public boolean execute(Code13ex_LoginEnt loginEnt){

		Code13ex_UserDAO dao = new Code13ex_UserDAO();
		Code13ex_UserEnt userEnt = dao.findByLogin(loginEnt);
		return userEnt != null;

	}


}
