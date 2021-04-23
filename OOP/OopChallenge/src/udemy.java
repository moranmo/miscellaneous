
public class udemy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hamburger hamburger = new Hamburger("Mcroyal", "beaaf", 3.0, "White Bread");
		
		
		hamburger.AddHamburgerAdding1("lettuce", 1.0);
		
		HealthBurger healthburger = new HealthBurger("beef", 3.5);
		
		SpecialBurger specBurger= new SpecialBurger("Special", "Bacon & beef", 7.0, "white");
		
		
//		System.out.println(hamburger.getName()+" costs" +hamburger.getPrice());
		System.out.println("total meal price is "+ hamburger.CalculateMealPrice() + "$");
		
		System.out.println("total healthy meal price is "+ healthburger.CalculateMealPrice() + "$");
		System.out.println("special burger price"+ specBurger.CalculateMealPrice() + "$");
		
		specBurger.AddHamburgerAdding1("egg", 2.0);
		

		
		
//		hamburger.CalculateMealPrice()
		
			}

}
