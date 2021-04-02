
public class Hamburger {

	private String name;
	private String meat;
	private double price;
	private String bread;

//	private double totalPrice;

	private String HamburgerAddingName1;
	private double HamburgerAddingPrice1;

	private String HamburgerAddingName2;
	private double HamburgerAddingPrice2;

	private String HamburgerAddingName3;
	private double HamburgerAddingPrice3;

	public Hamburger(String name, String meat, double d, String bread) {
		//	super();
		this.name = name;
		this.meat = meat;
		this.price = d;
		this.bread = bread;
	} 

	public void AddHamburgerAdding1(String name , double d)
	{
		this.HamburgerAddingName1 = name;
		this.HamburgerAddingPrice1 = d;
	}

	public void AddHamburgerAddingName2(String name , double d)
	{
		this.HamburgerAddingName2 = name;
		this.HamburgerAddingPrice2 = d;
	}

	public void AddHamburgerAddingName3(String name , double d)
	{
		this.HamburgerAddingName3 = name;
		this.HamburgerAddingPrice3 = d ;
	}

	public double CalculateMealPrice()
	{
		if (HamburgerAddingName1!=null)
		{
			price+= HamburgerAddingPrice1; 
		}

		return price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeat() {
		return meat;
	}

	public void setMeat(String meat) {
		this.meat = meat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	





}
