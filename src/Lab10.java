import java.util.*;
import java.io.*;

public class Lab10 {
	public static void main(String[] args) {
		ArrayList<Account> list = new ArrayList<Account>();
		String filename = "";
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the name of the input file: ");
		filename = s.nextLine();
		
		try{
		//YOU DO THIS:
		//Open the file in the 'filename' variable
		Scanner file = new Scanner(new File(filename));
		//Parse each line, create an Account object, and add it to the list
		while (file.hasNext()){
			String input = file.nextLine();
			int num = 0;
			String name = "";
			double amount =0;
			StringTokenizer st = new StringTokenizer(input, "," );
			while (st.hasMoreTokens()){
				num = Integer.parseInt(st.nextToken());
				name = st.nextToken();
				amount = Double.parseDouble(st.nextToken());
			}
			list.add(new Account(num,name,amount));
		}
		file.close();
		}catch(IOException a){
			System.out.println("File not found. Check filename and rerun program");
			System.exit(0);
		}
		
		char option;
		do {
			System.out.print("Enter (p)rint, (d)eposit, (w)ithdrawal, (l)ookup, or (q)uit: ");
			option = (s.nextLine()).charAt(0);
			switch (option) {
				case 'p':	// print - find and display and account object
					System.out.print("Enter account number: ");
					int num = Integer.parseInt(s.nextLine());
					
					Account a = find(list, num);
					System.out.println(a);
					break;

				case 'd':	// deposit money into an account
					System.out.print("Enter account number: ");
					 num = Integer.parseInt(s.nextLine());
					//YOU DO THIS:
					a = find(list,num);
					//Call 'find' method below to retrieve the account with entered account number
				try{
					System.out.print("Enter deposit amount: ");
					double dep = Double.parseDouble(s.nextLine());
					
					//YOU DO THIS:
					a.deposit(dep);
					//Call deposit method on the account retrieved from find method to deposit 'dep'
				}
				catch(NumberFormatException nf){
					System.out.println("Enter numbers only. No characters allowed");
				}
					break;

				case 'w':	// withdraw money from an account
					System.out.print("Enter account number: ");
					num = Integer.parseInt(s.nextLine());
					//YOU DO THIS:
					a = find(list,num);
					//Call 'find' method below to retrieve the account with entered account number
				try{
					System.out.print("Enter withdrawal amount: ");
					double with = Double.parseDouble(s.nextLine());
					
					//YOU DO THIS:
					a.withdrawal(with);
					//Call withdrawal method on the account retrieved from find method to withdraw 'with'
				}catch(NumberFormatException nf){
					System.out.println("Enter numbers only. No characters allowed");
				}
					break;

				case 'l':	// lookup - find an account and display using account name
					System.out.print("Enter name: ");
					String name = s.nextLine();
					
					//YOU DO THIS:
					
					for( Account b : list){
						String input = b.getName();
						if(input.equals(name)){
							System.out.println(b.getNum());
						}
					}
					//Loop through each account, calling get to get each one (or using an Iterator)
						//for each account, see if object's name matches the name entered by user (ignore case)
						//if found, print the number for that account
						
					break;
			} // end switch
		} while (option != 'q');
	} // end main
	
	public static Account find(ArrayList<Account> accounts, int num) {
		//YOU DO THIS
		
		for (Account c : accounts){
			if(c.getNum() == num)
				return c;
			}
		
		
		//loop through accounts, calling get to get each account (or using an Iterator)
			//for each account, see if object's account number matches the number entered by user
			//if found, return that account
			
		//leave this at the very end of the method in case the account isn't found
		return null;
	}// end find
 
}	
