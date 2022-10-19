public class Buyer extends Person {

	Buyer(){
		type = 0;
	}

	public void showMenu() {
		super.ShowMenu();
		//showViewButtons();
		//showComboxes();
		//showRadios();
		//show();
		//return ifLogout();
	}

	@Override
	public void CreateProductMenu(Product product, int level) {

		if (level == 0) {
			ProductMenu theProductMenu = new MeatProductMenu();
		} else {
			ProductMenu theProductMenu = new ProduceProductMenu();
		}
	}
}