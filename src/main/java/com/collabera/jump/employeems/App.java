package com.collabera.jump.employeems;

import com.collabera.jump.ems.app.EmployeeManagementSystem;
import com.collabera.jump.ems.exceptions.EmployeeNotFoundException;
import com.collabera.jump.ems.model.Employee;
import com.collabera.jump.ems.util.ScannerUtil;
import com.collabera.jump.ems.util.ScannerUtil.Result;
import com.collabera.jump.ems.util.ScannerUtil.TYPES;

public class App {

	private static boolean exitFlag = true;

	public static void main(String[] args) {

		EmployeeManagementSystem ems = new EmployeeManagementSystem();

		// ScannerUtil scannerUtil = new ScannerUtil();

//		System.out.println("++++++++++++++++++++");
//		System.out.println("+++++++++EMS++++++++");
//		System.out.println("++++++++++++++++++++");
		
		System.out.println(
				" #####  ####### #       #          #    ######  ####### ######     #    \n" + 
				"#     # #     # #       #         # #   #     # #       #     #   # #   \n" + 
				"#       #     # #       #        #   #  #     # #       #     #  #   #  \n" + 
				"#       #     # #       #       #     # ######  #####   ######  #     # \n" + 
				"#       #     # #       #       ####### #     # #       #   #   ####### \n" + 
				"#     # #     # #       #       #     # #     # #       #    #  #     # \n" + 
				" #####  ####### ####### ####### #     # ######  ####### #     # #     # \n" + 
				"                                                                        \n" + 
				"");

		System.out.println(
				" _       __     __                             __           ________  ________\n" + 
				"| |     / /__  / /________  ____ ___  ___     / /_____     / ____/  |/  / ___/\n" + 
				"| | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\   / __/ __ \\   / __/ / /|_/ /\\__ \\ \n" + 
				"| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/  / /_/ /_/ /  / /___/ /  / /___/ / \n" + 
				"|__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/   \\__/\\____/  /_____/_/  /_//____/  \n" + 
				"                                                                              ");

		do {
			System.out.println("Please choose an option to proceed:");

			System.out.println("1. CREATE");
			System.out.println("2. UPDATE");
			System.out.println("3. DELETE");
			System.out.println("4. SEARCH");
			System.out.println("5. EXIT");
			
			Employee emp = new Employee();
			
			Employee emp1 = new Employee();
			
			if( emp.equals(emp1))
			{
				System.out.println("They are same employee");
			}

			Result option = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 5);
			Result option2;

			switch (option.getValueAsInt()) {
			case 1: {
				System.out.println("Please choose an option to proceed:");
				System.out.println("1. EMPLOYEE");
				System.out.println("2. MANAGER");
				option = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 2);
				// scanner.nextLine();
				switch (option.getValueAsInt()) {
				case 1:
					ems.createEmployeeWithInputs();
					break;
				case 2:
					System.out.println("Create Manager");
					ems.createEmployeeWithInputs();
					ems.createManagerWithInputs();
					break;
				default:
					System.out.println("Invalid Input");
					break;
				}

			}
				break;
			case 2:
				System.out.println(2);
				System.out.println("Please enter Employee's ID that you wish to update:");				
				option = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 10);
				
				ems.searchEmployee(option.getValueAsInt());
				
				System.out.println("Please select which record field you are updating:");
				System.out.println("1. SSN");
				System.out.println("2. Email_ID");
				System.out.println("3. Employee Name");
				System.out.println("4. Age");
				System.out.println("6. Date of Birth");
				System.out.println("7. Phone Number");
				System.out.println("8. Home Address");
				System.out.println("9. Work Address");
				System.out.println("5. Gender");
				System.out.println("5. Report To Mgr");
				System.out.println("5. Job Tile");
				System.out.println("5. Department");

//				ems.updateEmployee(option.getValueAsInt());

				break;
			case 3:
				System.out.println("Please enter Employee's ID that you wish to delete:");				
				option = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 10);
				
				ems.searchEmployee(option.getValueAsInt());
				System.out.println("Please confirm if you wish to delete this employee record? 1=Yes or 2=No");
				option2 = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 10);
				
				if (option2.getValueAsInt() == 1)
				{
					ems.deleteEmployee(option.getValueAsInt());
				}
				else
				{
					break;
				}				
			case 4:
				System.out.println("Please enter Employee's ID that you are searching for:");				
				option = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 10);
				ems.searchEmployee(option.getValueAsInt());				
				break;
			case 5:
				exitFlag = false;
				System.out.println("Thanks for using EMS!");
				break;
			default:
				break;
			}
		} while (exitFlag);

		ScannerUtil.close();

	}

}
