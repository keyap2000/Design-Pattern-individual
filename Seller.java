public class Seller extends Person {

	Seller(){
		type = 1;
	}

	public void showMenu() {
		super.ShowMenu();
		showAddButton();
		//showViewButtons();
		//showComboxes();
		//showRadios();
		//show();
		//return ifLogout();
	}

	public void CreateProductMenu(Product product, int level) {
		if (level == 0)/// 0: MeatProduct defined in ProductSelectDialog.
		{
			ProductMenu productMenu = new MeatProductMenu();
		} else/// 1: Product Produce
		{
			ProductMenu productMenu = new ProduceProductMenu();
		}
	}

}
