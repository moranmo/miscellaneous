import java.util.ArrayList;

public class Bank {

	private String name;
	private ArrayList<Branch> branches;

	public Bank(String name) {
		this.name = name;
		branches = new  ArrayList<Branch>();
	}

	public boolean addNewBranch(String branchName)
	{
		if (findBranch(branchName) == null)
		{
			branches.add(new Branch(branchName));
			return true;

		}
		return false;
	}

	public boolean addNewCustomer(String branchName,String cutomerName,Double amount)
	{
		Branch existingBrunch = findBranch(branchName);
		if (existingBrunch != null)
		{
			existingBrunch.addNewCustomer(cutomerName, amount);
			return true;

		}
		return false;
	}

	//	
	public boolean addTransaction(String branchName,String cutomerName,Double amount){
		Branch existingBrunch = findBranch(branchName);
		if (existingBrunch != null)
		{
			existingBrunch.addTransaction(cutomerName, amount);
			return true;

		}
		return false;
	}

	private Branch findBranch(String name)
	{
		for(int i=0;i<branches.size();i++)
		{
			if (branches.get(i).getName().equals(name))
			{
				return branches.get(i);
			}
		}
		return null;
	}



	public boolean showCustomersAndTransactions(String branchName,boolean showTrans)

	{

		Branch existingBrunch = findBranch(branchName);
		if (existingBrunch != null)
		{
			ArrayList<Customer> customers = new ArrayList<Customer>();
			customers =existingBrunch.getCustomrList();
			System.out.println("branchName" +existingBrunch.getName() +"has the following Customers :" );

			for (int i=0;i<customers.size();i++)

			{
				System.out.println("Customer " + i+1 +" "+customers.get(i).getName());
				if (showTrans)
				{
					System.out.println("customer" +customers.get(i).getName() +" did the following transactions :" );
					Customer existingCustomer = customers.get(i);

					{
						for(int j=0;j<existingCustomer.getTransactionsLst().size();j++)
						{
							System.out.println(existingCustomer.getTransactionsLst().get(j));

						}
					}
				}
			}

			return true;

		}
		return false;
	}


}

