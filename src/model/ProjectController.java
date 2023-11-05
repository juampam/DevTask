// controller
//
package model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ProjectController{
	Scanner scanner = new Scanner(System.in);
	Database db = new Database("projects.JSON");
	Project project = new Project();
	
	private String projectname;
	private String description;
	private String owner;
	private String users;
	private String nom;

	public ProjectController(){
	
	}
	
	public void createProject(){
		String selected_nom = "";
		System.out.println("Project Name:");
		projectname = scanner.nextLine();
		System.out.println("Description:");
		description = scanner.nextLine();
		System.out.println("Elija el formato de variables para este pryecto:\n\t1. snake_case\n\t2. camelCase\n\t3. kebab-case ");
		nom = scanner.nextLine();
		switch(nom){
			case "1":
				selected_nom = "snake_case";
			break;
			case "2":
				selected_nom = "camelCase";
			break;
			case "3":
				selected_nom = "kebeb-case";
			break;
			default:
				System.out.println("invalid option, using camelCase by default");
				selected_nom = "camelCase";
			break;
		}
 		db.createProject(projectname,description,selected_nom,"tester","[]");	
	}
}

