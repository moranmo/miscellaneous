import java.util.Scanner;

public class runApp {
	private static Scanner scan = new Scanner(System.in); 
	private static Bank myBank = new Bank("Mizrachi");

	public static void main(String[] args) {


		boolean quit = false;
		int choice;

		while(!quit)
		{
			System.out.println("Enter your choice:");
			choice = scan.nextInt();

			switch(choice)
			{
			case 0:
			{
				printInstructions();
				break;
			}
			case 1:
			{
				System.out.println("Add a Branch name :");
				String branch = scan.next();
				if (myBank.addNewBranch(branch))
				{
					System.out.println("Branch created successfuly");
				}
				else
				{
					System.out.println("Branch already exists");
				}

				break;
			}
			case 2:
			{
				System.out.println("Add the Branch name :");
				String branchName = scan.next();
				System.out.println("Add the Customer name :");
				String cutomerName = scan.next();
				System.out.println("Add the Initial amount :");
				double amount = scan.nextDouble();
				if (myBank.addNewCustomer(branchName, cutomerName, amount))
				{
					System.out.println("Customer added successfuly to the Branch");
				}
				else
				{
					System.out.println("Branch is not found");
				}
				break;
			}
			case 3:
			{
				System.out.println("specify the Branch name :");
				String branchName = scan.next();
				System.out.println("specify the Customer name :");
				String cutomerName = scan.next();
				System.out.println("Add the transaction :");
				double amount = scan.nextDouble();
				if (myBank.addTransaction(branchName, cutomerName, amount))
				{
					System.out.println("Transaction added successfuly");
				}
				else
				{
					System.out.println("Transation was not added");
				}
				break;
				

			}
			case 4:
			{
				System.out.println("Add the Branch name :");
				String branchName = scan.next();
				if (myBank.showCustomersAndTransactions(branchName,false))
				{
					
				}
				else
				{
					System.out.println("Branch is not found");
				}
				break;
			
				
			}
			case 5:
			{
				System.out.println("Add the Branch name :");
				String branchName = scan.next();
				if (myBank.showCustomersAndTransactions(branchName,true))
				{
					
				}
				else
				{
					System.out.println("Branch is not found");
				}
				break;
			
			}
			}
		}



	}
	private static void printInstructions() {
		// TODO Auto-generated method stub
		System.out.println("\nPress ");
		System.out.println("\t 0- To print the insructions");
		System.out.println("\t 1- To add a Branch");
		System.out.println("\t 2- To add a new Customer ");
		System.out.println("\t 3- To Add transation to customer ");
		System.out.println("\t 4- To show cutomers ");
		System.out.println("\t 5- To show customer and their transcations ");
		
		
		
		
//		System.out.println("\t 4- To remove remove a contact ");
//		System.out.println("\t 5- To query a contact ");


	}

}
