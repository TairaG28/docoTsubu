package model;

import dao.Code1306_MutterDAO;

public class Code1307_PostMutterLogic {

	public void execute(Code1305_Mutter mutter){

		Code1306_MutterDAO dao = new Code1306_MutterDAO();
		dao.create(mutter);

	}

}
