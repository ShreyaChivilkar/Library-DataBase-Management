package Lib;
import java.io.*;
import java.lang.*;
import java.util.*;


public class Library implements Admin {
	
	File infile = new File("C:\\Users\\user\\Documents\\BookList.txt");
	File outfile = new File("C:\\Users\\user\\Documents\\output.txt");
	BufferedReader reader;
	BufferedWriter writer;
	FileInputStream in = null;
	RandomAccessFile file = null;
	
	public void searchBook(String bookName,String author) {
	try {
		//file = new RandomAccessFile(outfile, "rws");
		
		reader = new BufferedReader(new FileReader(infile));
		writer = new BufferedWriter(new FileWriter(outfile));
		//in = new FileInputStream(infile);
		/*byte[] byteArray = new byte[(int)infile.length()];
	    in.read(byteArray);
	    String data = new String(byteArray);
	    String[] stringArray = data.split("\r\n");
	    System.out.println("Number of lines in the file are ::"+stringArray.length);*/
		int ch=0;
		String line = reader.readLine();
		while(line!=null) {
			writer.write(line);
			writer.newLine();
			//System.out.println(line);
		if(line.contains(bookName))
					{
					//	System.out.println(bookName);
						line = reader.readLine();
						if(line.contains(author))
						{
						//	System.out.println(line);
							line = reader.readLine();
							writer.write(author);
							writer.newLine();
							//if(line)	to check for non zero number of books
							int checkIfNonZero = Integer.parseInt(line);
							if(checkIfNonZero != 0) {
								System.out.println("Your book is issued successfully! ");
								checkIfNonZero-=1;
								writer.write(" "+checkIfNonZero);
								writer.newLine();
								//writer.write(checkIfNonZero); to replace the existing data
							}
							else {
								System.out.println("Your book is currently out of stock \n Request for new stock is sent!! ");
								checkStock(bookName, author);
							}
						}
						ch = 1;	
					}
					line = reader.readLine();
					}
		if (ch == 0)
		{
			System.out.println("Requested book is unavailable ");
		}
		}
	catch(IOException e) {
		System.out.println("File not found!");
	}finally {
		try {
			
			reader.close();
			writer.close();
			
			
		}catch(IOException e) {
			System.out.println("Error");
		}
	}
	}
	
	
public void insertBook(String bookName,String author, int n) {
	try {
	//file = new RandomAccessFile(outfile, "rws");
	writer = new BufferedWriter(new FileWriter(outfile));
	reader = new BufferedReader(new FileReader(infile));
	int flag = 0;
	String line;
	line = reader.readLine();
	
	while(line!=null) {
		writer.write(line);		//write data present in file
		writer.newLine();
		
		if(line.contains(bookName))
		{
			//System.out.println(bookName);
			line = reader.readLine();
			if(line.contains(author))
			{
				//System.out.println(line);
				line = reader.readLine();
				writer.write(author);
				writer.newLine();
				//if(line)	to check for non zero number of books
				int checkIfNonZero = Integer.parseInt(line);
				checkIfNonZero+=n;
				writer.write(" "+checkIfNonZero);
				writer.newLine();
				System.out.println("New stock has been added successfully");
				
			}
			flag = 1;
		}
		line = reader.readLine();
		}
	
	if(flag == 0) {
	writer.append(bookName); //append data
	writer.newLine();
	
	
	writer.append(author);
	writer.newLine();
	writer.append(" "+n);
	System.out.println("new quantity");
	}
	
	
	
	}catch(IOException e) {
		
	}finally {
		try {
			reader.close();
			writer.close();
		}catch(IOException e) {
			
		}
	}
	
}

/*void deleteBook() {
	try {
		reader = new BufferedReader(new FileReader(infile));
		
	}catch(IOException e) {
		
	}finally {
		
	}
}*/
public void checkStock(String bookName, String author) {
	try {
	
		
		reader = new BufferedReader(new FileReader(infile));
		writer = new BufferedWriter(new FileWriter(outfile));
		
		
		String line = reader.readLine();
		while(line!=null) {
			writer.write(line);
			writer.newLine();
			//System.out.println(line);
		if(line.contains(bookName))
					{
					//	System.out.println(bookName);
						line = reader.readLine();
						if(line.contains(author))
						{
						//	System.out.println(line);
							line = reader.readLine();
							writer.write(author);
							writer.newLine();
							//if(line)	to check for non zero number of books
							int checkIfNonZero = Integer.parseInt(line);
							if(checkIfNonZero == 0) {
								int x= checkIfNonZero+Admin.stock;
								writer.write(" "+x);
								writer.newLine();
								System.out.println("New stock successfully inserted");
								//writer.write(checkIfNonZero); to replace the existing data
							}else {
								System.out.println("There is sufficient stock!");
							}
						}
							
					}
					line = reader.readLine();
					}
		
		}
	catch(IOException e) {
		
	}finally {
		try {
			
			reader.close();
			writer.close();
			
			
		}catch(IOException e) {
			System.out.println("Error");
		}
	}
	
	
}


public void return_book(String bookName, String author) {
	// TODO Auto-generated method stub
	try {
		//file = new RandomAccessFile(outfile, "rws");
		
		reader = new BufferedReader(new FileReader(infile));
		writer = new BufferedWriter(new FileWriter(outfile));
		//in = new FileInputStream(infile);
		/*byte[] byteArray = new byte[(int)infile.length()];
	    in.read(byteArray);
	    String data = new String(byteArray);
	    String[] stringArray = data.split("\r\n");
	    System.out.println("Number of lines in the file are ::"+stringArray.length);*/
		int ch=0;
		String line = reader.readLine();
		while(line!=null) {
			writer.write(line);
			writer.newLine();
			//System.out.println(line);
		if(line.contains(bookName))
					{
					//	System.out.println(bookName);
						line = reader.readLine();
						if(line.contains(author))
						{
						//	System.out.println(line);
							line = reader.readLine();
							writer.write(author);
							writer.newLine();
							//if(line)	to check for non zero number of books
							int checkIfNonZero = Integer.parseInt(line);
							
								System.out.println("Your book is returned successfully! ");
								checkIfNonZero+=1;
								writer.write(" "+checkIfNonZero);
								writer.newLine();
								//writer.write(checkIfNonZero); to replace the existing data
							
							
						}
						ch = 1;	
					}
					line = reader.readLine();
					}
		if(ch == 0) {
			writer.append(bookName); //append data
			writer.newLine();
			
			
			writer.append(author);
			writer.newLine();
			writer.append(" "+1);
			System.out.println("Your book is returned successfully!");
		}
		
		}
	catch(IOException e) {
		System.out.println("File not found!");
	}finally {
		try {
			
			reader.close();
			writer.close();
			
			
		}catch(IOException e) {
			System.out.println("Error");
		}
	}
}
}

/*class MyMain{
	public static void main(String args[]) {
		Library l = new Library();
		l.checkStock("BROKEN WING", "SAROJINI NAIDU");
	}
}*/


