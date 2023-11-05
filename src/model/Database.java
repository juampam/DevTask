package model;
import java.io.*;
import java.util.*;

public class Database{
	private String database;
	private String oldValue;

	public Database(String database){
		this.database = database;
	}

	public void create(String text, int values){
		String valuemodel = "value";
		String mvalue="";
		for(int i = 0; i<values; i++){
			mvalue += "\""+text +"@"+ valuemodel + "-" + i + "\": Null,\n\t\t";	
		}

		String ftext = "{\n\t\"" + text+"\":[\n\t\t{\t"+"\n\t\t"+mvalue+"\n\t\t}\n\t]," + "\n}";
		try (FileWriter writer = new FileWriter(database, true);
             		BufferedWriter bufferWriter = new BufferedWriter(writer);
             		PrintWriter out = new PrintWriter(bufferWriter)) {
            		out.println(ftext);
        	} catch (IOException e) {
            		e.printStackTrace();
        	}
	}
	public void createProject(String name,String desc,String nom, String owner,String users){
		String mvalue="";
	/*	for(int i = 0; i<values; i++){
			mvalue += "\""+text +"@"+ valuemodel + "-" + i + "\": Null,\n\t\t";	
		}*/
		mvalue += "\"ID\":"+"\""+name +"@"+ owner+"\",\n\t\t";
		mvalue += "\"Description\":"+"\""+desc+"\",\n\t\t";
		mvalue += "\"Nomenclature\":"+"\""+nom+"\",\n\t\t";
		mvalue += "\"Owner\":"+"\""+owner+"\",\n\t\t";
		mvalue += "\"Users\":"+"\""+users+"\",\n\t\t";

		String ftext = "{\n\t\"" + name+"\":[\n\t\t{\t"+"\n\t\t"+mvalue+"\n\t\t}\n\t]," + "\n}";
		try (FileWriter writer = new FileWriter(database, true);
             		BufferedWriter bufferWriter = new BufferedWriter(writer);
             		PrintWriter out = new PrintWriter(bufferWriter)) {
            		out.println(ftext);
        	} catch (IOException e) {
            		e.printStackTrace();
        	}
	}


}
