package model;
import java.io.*;
import java.util.*;


public class Database{
	private String database;
	private String oldValue;

	public Database(String database){
		this.database = database;
	}
	 

	public boolean checker() {
        File archivo = new File("projects.JSON"); // Reemplaza "ruta_del_archivo" con la ruta de tu archivo
        if (archivo.exists() && archivo.length() == 0) {
           return true;
        } else {
        	return false;
        }
    }
	public void replaceF(char caracterViejo, char caracterNuevo){
		 String nombreArchivo = "projects.JSON";
		 try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
             BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt"))) {
            int caracterLeido;
            while ((caracterLeido = br.read()) != -1) {
                char caracter = (char) caracterLeido;
                if (caracter == caracterViejo) {
                    bw.write(caracterNuevo);
                } else {
                    bw.write(caracter);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Renombrar el archivo temporal al nombre original
        File archivoOriginal = new File(nombreArchivo);
        File archivoTemporal = new File("temp.txt");
        archivoOriginal.delete();
        archivoTemporal.renameTo(archivoOriginal);

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
	public void createProject(String name,String desc, String owner,String users,String languages){
		String mvalue="";
		boolean filechecker = checker();
		String ftext = "";
	/*	for(int i = 0; i<values; i++){
			mvalue += "\""+text +"@"+ valuemodel + "-" + i + "\": Null,\n\t\t";	
		}*/
		String identificator = name.replace(" ","_");
		mvalue += "\"IdProject\":"+"\""+owner +"/"+ identificator+"\",\n\t\t";
		mvalue += "\"projectName\":"+"\""+ name +"\",\n\t\t";
		mvalue += "\"description\":"+"\""+desc+"\",\n\t\t";
	//	mvalue += "\"Nomenclature\":"+"\""+nom+"\",\n\t\t";
		mvalue += "\"author\":"+"\""+owner+"\",\n\t\t";
		mvalue += "\"devs\":"+"\""+users+"\",\n\t\t";
		mvalue += "\"languages\":"+"\""+languages+"\"\n\t\t";
		if(filechecker == true){
			ftext = "[\n\t{" +"\n\t\t"+mvalue+"\n\t}" + "\n]";
		}else{
			replaceF(']',',');
			ftext = "\n\t{" +"\n\t\t"+mvalue+"\n\t}" + "\n]";
		}
		try (FileWriter writer = new FileWriter(database, true);
             		BufferedWriter bufferWriter = new BufferedWriter(writer);
             		PrintWriter out = new PrintWriter(bufferWriter)) {
            		out.println(ftext);
        	} catch (IOException e) {
            		e.printStackTrace();
        	}
	}
/*
  public  void ReadFile(String projectId) {
    String filePath = "projects.JSON";
	String fileContent = "";
	StringBuilder contentBuilder = new StringBuilder();

	try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

    	String sCurrentLine;
    	while ((sCurrentLine = br.readLine()) != null) 
    	{
        contentBuilder.append(sCurrentLine).append("\n");
    	}
	} catch (IOException e) {
    e.printStackTrace();
	}

	fileContent = contentBuilder.toString();
	String[] separator = fileContent.split("{");
	for(int i=0;i<separator.length;i++){
		if(separator[i].contains(projectId)){
			System.out.println(separator[i]);
			String[] nline = separator[i].split("\n");
			for(int x=0;x<nline.length;x++){
				System.out.println(nline[x]);
			}
		}
	}
  }*/
}


