package model;

import java.util.List;

public class Code1013_PostMutterLogic {

	public void execute(Code1002_Mutter mutter,
			List<Code1002_Mutter> mutterList){
		mutterList.add(0,mutter);	//先頭に追加
	}

}
