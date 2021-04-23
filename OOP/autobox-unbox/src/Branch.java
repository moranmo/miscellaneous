import java.util.ArrayList;

public class Branch {
	ArrayList<Customer> customrList;
	String name;

	public Branch(String name) {
		this.name = name;
		this.customrList= new ArrayList<Customer>();
	}



	public boolean addNewCustomer(String name,double amount)
	{
		if (findCustomer(name) == null)
		{
			customrList.add(new Customer(name, amount));
			return true;

		}
		return false;
	}

	public boolean addTransaction(String customerName,double amoount){
		Customer existingCustomer = findCustomer(customerName);
		if (existingCustomer != null)
		{
			existingCustomer.addTransactionAmount(amoount);
			return true;

		}
		return false;
	}



	private Customer findCustomer(String name)
	{
		for(int i=0;i<customrList.size();i++)
		{
			if (customrList.get(i).getName().equals(name))
			{
				return customrList.get(i);
			}
		}
		return null;
	}



	public ArrayList<Customer> getCustomrList() {
		return customrList;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	
}
