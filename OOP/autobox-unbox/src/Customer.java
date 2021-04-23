import java.util.ArrayList;

public class Customer {
	String name;
	Double initial;
	Double transaction;
	
	ArrayList<Double> transactionsLst;
	
	public Customer(String name,Double initialAmount) {
		this.name = name;
		this.transactionsLst = new ArrayList<Double>();
		addTransactionAmount(initialAmount);

	}
	
	public void addTransactionAmount(double transAmount)
	{
		transactionsLst.add(transAmount);
	}
	
	
	public Double getInitial() {
		return initial;
	}


	public void setInitial(Double initial) {
		this.initial = initial;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addTransation(Double transaction)
	{
		transactionsLst.add(transaction);
		
	}

	public ArrayList<Double> getTransactionsLst() {
		return transactionsLst;
	}
	
	
	
	
	

	
	
	
	
	

}
