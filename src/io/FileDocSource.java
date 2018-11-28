package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class FileDocSource extends DocSource {

	//Create a constructor which takes a file path as a string
	//Use FileFinder to return an array of files 
	
	
	
	private String _path;
	private ArrayList<File> _fileNames;

	public static BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	
	
	
	public FileDocSource(String path) {
		_path = path;
		_fileNames = FileFinder.GetAllFiles(path);
	}
	
	@Override
	public int getNumDocs() {
		return _fileNames.size();
	}

	@Override
	public String getDoc(int id)  {
		StringBuilder sb = new StringBuilder();
		try {
		BufferedReader fin = new BufferedReader(new FileReader(_fileNames.get(id)));
		String line = fin.readLine();
		while(line != null) {
		sb.append(line);
		sb.append(" "); //check if this is right 
		line = fin.readLine();
		}
		fin.close();
		} catch(IOException e) {
			System.out.print("e");
		}
		
		return sb.toString() ;
	}

	public ArrayList<File> getFileNames() {
		return _fileNames;
	}
	
	
}
