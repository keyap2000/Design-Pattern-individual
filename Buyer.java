public class Buyer extends Person {

	Buyer(){
		type = 0;
	}

	@Override
	public boolean showMenu() {
		super.ShowMenu();
		showViewButton();
		showComboxes();
		showRadioButton();
		show();
		return ifLogout();
	}

	@Override
	public void CreateProductMenu(Product product, int level) {

		//factory design pattern
		if (level == 0) {
			theProductMenu = new MeatProductMenu();
		} else {
			theProductMenu = new ProduceProductMenu();
		}
	}
}