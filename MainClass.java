package Main;
import Lib.Library;
import Student.*;
import java.util.*;
import java.lang.*;
public class MainClass {
	

public static void main(String args[]) {
	System.out.println("Welcome to LIBRARY");	
	System.out.println("To access admin account enter 1");
	System.out.println("To access student account enter 2");
	int choice,num;
	Scanner sc = new Scanner(System.in);
	choice = sc.nextInt();
	Library libObj = new Library();
	
	switch(choice) {
	case 1:
	{
		System.out.println(" Welcome to admin account");
		String ch,ch1;
		System.out.println(" What operation is to be performed:\n  Do you want to check the stock? ");
		ch = sc.next();
		if (ch.equalsIgnoreCase("yes")) {
			System.out.println("Enter number of books to be checked for:");
			num = sc.nextInt();
			String bookName[] = new String[num];
			String author[] = new String[num];
			for (int i = 0; i < num; i++) {
				System.out.println("Enter bookname");			
				bookName[i] = sc.next();
				System.out.println("Enter author name");
				author[i] = sc.next();
			
				libObj.checkStock(bookName[i], author[i]);
				
			}
			
		}
		System.out.println(" Do you want to insert new stock? ");
		ch1 = sc.next();
		if (ch1.equalsIgnoreCase("yes")) {
			System.out.println("Enter number of books to be inserted for:");
			num = sc.nextInt();
			String bookName[] = new String[num];
			String author[] = new String[num];
			int n[] = new int[num];
			for (int i = 0; i < num; i++) {
				System.out.println("Enter bookname of books to be inserted");
				bookName[i] = sc.next();
				System.out.println("Enter author name of books to be inserted");
				author[i] = sc.next();
				System.out.println("Enter the quantity of books to be inserted");
				n[i] = sc.nextInt();
				libObj.insertBook(bookName[i], author[i], n[i]);
				
			}
			
		}
		System.out.println("Admin section ended successfully");
		break;
		}
	case 2:
	{
		System.out.println("Enter number of students:");
		num = sc.nextInt();
		Student stuObj[] = new Student[num];
		for (int i = 0; i < num; i++) {
			try {
			 stuObj[i] = new Student();
			 stuObj[i].get_books();}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		System.out.println("Student section ended successfully");
		break;
	}
		
	}
	

}
}
