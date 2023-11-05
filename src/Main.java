import java.util.List;
import model.User;
import model.UserManager;
import model.Database;
import model.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String mainpage = "";
    System.out.println("DevTask Connect");
	 System.out.println("********************************************************************************");
        System.out.println("                                UVG POO-Grupo 6 Software Inc.");
        System.out.println("                                DevTask Connect");
        System.out.println();
        System.out.println("Copyright (C) 2023 UVG-POO Grupo 6");
        System.out.println();
        System.out.println("This program is free software: you can redistribute it and/or modify it under");
        System.out.println("the terms of the GNU General Public License as published by the Free Software");
        System.out.println("Foundation, either version 3 of the License, or (at your option) any later version.");
        System.out.println();
        System.out.println("This program is distributed in the hope that it will be useful, but WITHOUT ANY");
        System.out.println("WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A");
        System.out.println("PARTICULAR PURPOSE.  See the GNU General Public License for more details.");
        System.out.println();
        System.out.println("You should have received a copy of the GNU General Public License along with this");
        System.out.println("program. If not, see <http://www.gnu.org/licenses/>.");
        System.out.println();
        System.out.println("For questions or more information, contact juampam at mur21856@uvg.edu.gt.");
        System.out.println();
        System.out.println("Please note that this software may include third-party libraries or components");
        System.out.println("with their own licensing terms. Make sure to review and comply with those terms");
        System.out.println("when using or distributing this software.");
        System.out.println();
        System.out.println("Enjoy using our Software!");
        System.out.println("********************************************************************************");
	int kha = 1;
	while(kha == 1){
    		System.out.println("Please Select an Option:\n1. Login\n2. Register");
		mainpage = scanner.nextLine();
		switch(mainpage){
			case "1":
				System.out.println("Login");
				kha += 1;
			break;
			case "2":
				System.out.println("Register");
				kha += 1;
			break;
			default:
				System.out.println("Please select a valid option");
			break;
		}

	}

	System.out.println("Creando nuevo proyecto");
	ProjectController pc = new ProjectController();
	pc.createProject();

    }
}
