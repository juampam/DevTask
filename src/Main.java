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
    ProjectController pc = new ProjectController();

   /*
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
*/
//	System.out.println("Creando nuevo proyecto");
//	pc.createProject();

    System.out.println("Leyendo JSON");
	pc.getProject();
    }
}
