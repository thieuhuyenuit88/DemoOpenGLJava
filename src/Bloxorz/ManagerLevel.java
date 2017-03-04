package Bloxorz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;

public class ManagerLevel {
	static public int msUnlock;
	static public int msTotal = 11;
	static final String FilePath ="level.txt";
	static public void Load (){
		try {
			String path = new java.io.File(".").getCanonicalPath();
			String fullpath = path+"\\"+FilePath;
			FileInputStream fstream = new FileInputStream(fullpath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			msUnlock = 1;
			strLine = br.readLine();
			msUnlock = Integer.parseInt(strLine);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
	static public void Save () {
		try {
			String path = new java.io.File(".").getCanonicalPath();
			String fullpath = path+"\\"+FilePath;			
			
			  File file = new File(fullpath);
			  Writer output = null;
			  String text = ""+msUnlock;
			  output = new BufferedWriter(new FileWriter(file));
			  output.write(text);
			  output.close();
			  System.out.println("Your file has been written"); 
			  
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
