package model;

import java.util.List;

import dao.Code1306_MutterDAO;

public class Code1308_GetMutterListLogic {

	public List<Code1305_Mutter> execute(){
		Code1306_MutterDAO dao = new Code1306_MutterDAO();
		List<Code1305_Mutter> mutterList = dao.findAll();
		return mutterList;
	}

}
