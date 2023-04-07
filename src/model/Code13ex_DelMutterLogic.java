package model;

import dao.Code1306_MutterDAO;

public class Code13ex_DelMutterLogic {

	public boolean execute(Code1305_Mutter delmutter){

		Code1306_MutterDAO dao = new Code1306_MutterDAO();
		return dao.remove(delmutter);

	}


}
