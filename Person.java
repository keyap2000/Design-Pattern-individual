import java.util.Iterator;

public abstract class Person {

	public int type = 0;		//by default buyer(0)
	public String UserName;

	ProductMenu theProductMenu;
	ClassProductList classProductList;
	Product currentProduct;

	Person(){
		classProductList = new ClassProductList();
	}

	void showComboxes() {theProductMenu.showComboxes();	}

	void show() {
		theProductMenu.setVisible(true);
	}

	public void showAddButton() {
		theProductMenu.showAddButton();
	}

	public void showViewButton() {
		theProductMenu.showViewButton();
	}

	public void showRadioButton() {
		theProductMenu.showRadioButton();
	}

	public void showLabels() {
		theProductMenu.setVisible(true);
	}

	boolean ifLogout() {
		return theProductMenu.ifLogout();
	}


	public abstract boolean showMenu();

	public abstract void CreateProductMenu(Product product, int level);

	public ClassProductList GetProductList() {
		return  classProductList;
	}

	public void AddProduct(Product theSelectedProduct) {
		System.out.println("selected product added");
		classProductList.add(theSelectedProduct);
	}

	public boolean ShowMenu() {

		// creating a iterator for the trading list
		//iterator design pattern
		Iterator theIter = currentProduct.tradingList.iterator();

		theProductMenu.theProduct = currentProduct;
		Trading trading;
		System.out.println("in person class showmenu method");
		while (theIter.hasNext()) {
			trading = (Trading) theIter.next();
			System.out.println("trading in person showmenu : " + trading);
			theProductMenu.TradingCombox.addItem(trading);
		}
		return false;
	}
}