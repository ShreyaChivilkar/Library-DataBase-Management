package Student;
import java.lang.*;
import java.util.*;
import Lib.Library;

public class Student extends Library {		
	Library lib = new Library();
	void check_issue()	
	{	System.out.println("Enter the name of the book");
		String bookn = sc.next();
		System.out.println("Enter the name of the author");
		String author = sc.next();
		System.out.println("Enter the number of books previously issued");
		int n = sc.nextInt();
		int count = 5;
		
		try 
			{
				int x=5-n;
				if(x>0) {
					//code for issuing the book 
					lib.searchBook(bookn, author);
				
				}
				else {
					System.out.println("Sorry but you need to return the previous books to issue new books/n You can issue maximum 5 books at a time not more than that");
					
				}
			}
		catch(Exception e)
		{
			
			}
	}
	String bookn_r, author_r;
	public void check_return()
	{
		System.out.println("Enter the name of the book to be returned");
		bookn_r = sc.next();
		System.out.println("Enter the name of the author");
		author_r = sc.next();
		lib.return_book(bookn_r, author_r);
		//code for changing contents of the file is left.
	}
	int calc()
	{	System.out.println("Enter the ID number");
		id_no= sc.next();
		int dd1, dd2, mm1, mm2, y1, y2, daysoverdue ;
		System.out.println("Enter predecided date of return in the dd-mm-yyyy format");
		dd1= sc.nextInt();
		mm1= sc.nextInt();
		y1=  sc.nextInt();
		System.out.println("Enter today's in the dd-mm-yyyy format");
		dd2= sc.nextInt();
		mm2= sc.nextInt();
		y2=  sc.nextInt();
		daysoverdue = (Math.abs(dd2- dd1) + Math.abs(30*(mm2- mm1)) + Math.abs(365*(y2-y1)));
		return daysoverdue;
	}	
	                                                                                 // Fine calculation
	
	int finecalc(int daysoverdue1)
		{ int daysoverdue=daysoverdue1;
	try
	{
		if (daysoverdue >0 && daysoverdue <=60) 
			{
				if (daysoverdue <=7)
					return (2* daysoverdue);
				else if (daysoverdue >7 && daysoverdue<=15)
					return (5* daysoverdue);
				else if (daysoverdue >15 && daysoverdue<=30)
					return (8* daysoverdue);
				else
					return (10*daysoverdue);
			}
		else
			{
			System.out.println("Your library card has been revoked. Pay the calculated fine and contact the library manager to renew your library subscription.");
			}
				return daysoverdue;
		}
		
	catch(Exception e)
	{
		System.out.println("Your library card has been revoked. Contact the library manager.");
	}
	return daysoverdue;
}		

		String name, id_no,year;

		int choice,ch;
		Scanner sc = new Scanner(System.in);
		public void get_books()
		{
			System.out.println("Enter the name of the student");
			name = sc.next();
			System.out.println("Enter the ID_NUMBER of the student");
			id_no = sc.next();
			System.out.println("Enter the current year of academics");
			year = sc.next();
			System.out.println("What operation do you want to perform");
			System.out.println("Enter 1 for issue and 2 for return");
			ch = sc.nextInt();
			switch (ch)
			{
			case 1:
			
				check_issue();
				break;
			
			
			case 2:
			{
				int daysoverdue, daysoverdue1, ca ;
				System.out.println("This is the Library Fee Management System");
				System.out.println("The following are the charges pressed for various offences:" + "\n1. For the book that is returned late  \t\t\t\t - \t Correctly calculated fee according to the number of days overdue");
				System.out.println("2. Damaged cases & Torn or missing labels, barcodes or RFID tags - " + "\t  See the concerned Staff");
				System.out.println("Enter your category");
				ca= sc.nextInt();
				if(ca==2)
					{
					System.out.println("Contact the Library Manager for next course of action.");
					System.exit(-1);
					}
				System.out.println("Enter the necessarry details for us to calculate the late return charges accordingly.");
				Student obj = new Student();
				daysoverdue1=obj.calc();
				
				int ch;
				
				
				try 
				{
				System.out.println("Enter the number of times you have been a defaluter previously i.e have returned the book late (If not then enter 0)"); //no of times the user has been a defaulter
				System.out.println("The library system is such that it allows users to be defaulters for five times only. If the user crosses this limit the the user's membership is suspended ");
				ch= sc.nextInt();
				
				//if (ch>=0 && ch<6)
					//{
					double fine;
						switch(ch)
						{
							case 0: System.out.println("This fine is for being a defaulter only once i.e this time");
									fine = obj.finecalc(daysoverdue1);
									System.out.println("The number of days over the return date is "+ daysoverdue1 +" & the fine to be paid is Rs. "+ fine + "/-");
							break;
							case 1: fine = obj.finecalc(daysoverdue1);
									fine = fine*1.5; 
									System.out.println("The number of days over the return date is "+ daysoverdue1 +" & the fine to be paid is Rs. "+ fine + "/-");
							break;		
							case 2: fine = obj.finecalc(daysoverdue1);
									fine = fine*2; 
									System.out.println("The number of days over the return date is "+ daysoverdue1 +" & the fine to be paid is Rs. "+ fine + "/-");
							break;
							case 3: fine = obj.finecalc(daysoverdue1);
									fine= fine*4;
									System.out.println("The number of days over the return date is "+ daysoverdue1 +" & the fine to be paid is Rs. "+ fine + "/-");
							break;
							case 4: fine = obj.finecalc(daysoverdue1);
									fine= fine*8;
									System.out.println("The number of days over the return date is "+ daysoverdue1 +" & the fine to be paid is Rs. "+ fine + "/-");
							break;
							case 5: fine = obj. finecalc(daysoverdue1);
									fine= fine*10; 
									System.out.println("The number of days over the return date is "+ daysoverdue1 +" & the fine to be paid is Rs. "+ fine + "/-");
							break;
							default:fine = obj.finecalc(daysoverdue1);
									System.out.println("You have been a defaulter for more than 5 times because of which your library card has been revoked. Contact your library manager for further details" + " & the fine to be paid for "+daysoverdue1+" days is Rs. "+ fine + "/-");
									
						}
				//}
				//else
					//System.out.println("You have been a defaulter for more than 5 times because of which your library card has been revoked. Contact your library manager for further details.");
					}
				catch(Exception e)
				{System.out.println(e);}
				 check_return();

					
					break;
				
				//System.out.println("The number of days over the return date is"+ daysoverdue +"The fine to be paid is"+ fine);
			}
						}

				
			
			}
		//String bookn, author;
		//int n,x;
			
		}







			
		
	



