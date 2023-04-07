package test;

import java.util.List;

import dao.Code1303_EmployeeDAO;
import model.Code1302_Employee;

public class Code1304_SelectEmployeeSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ


		//employeeテーブルの全レコードを取得
		Code1303_EmployeeDAO empDAO = new Code1303_EmployeeDAO();
		List<Code1302_Employee> empList = empDAO.findAll();

		//取得したデータを出力
		for(Code1302_Employee emp:empList){
		System.out.println("ID:"+emp.getId());
		System.out.println("名前:"+emp.getName());
		System.out.println("年齢:"+emp.getAge()+"\n");

		}

	}
}
