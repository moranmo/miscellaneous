
public class SpecialBurger extends Hamburger {

	public SpecialBurger(String name, String meat, double d, String bread) {
		super(name, meat, d, bread);
		
	}

	@Override
	public void AddHamburgerAdding1(String name, double d) {
					System.out.println("Not Allowed any addings to special burger");
	}
	

	

}
