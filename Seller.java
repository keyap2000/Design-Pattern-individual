public class Seller extends Person {

	Seller(){
		type = 1;
	}

	public boolean showMenu() {
		super.ShowMenu();
		showAddButton();
		showViewButton();
		showComboxes();
		showRadioButton();
		show();
		return ifLogout();
	}

	public void CreateProductMenu(Product product, int level) {

		//factory design pattern
		if (level == 0)/// 0: MeatProduct defined in ProductSelectDialog.
		{
			 theProductMenu = new MeatProductMenu();
		} else/// 1: Product Produce
		{
			 theProductMenu = new ProduceProductMenu();
		}
	}
}