import java.util.Iterator;

public abstract class Person {

	public int type = 0;		//by default buyer(0)
	public String UserName;
	String uname;
	private ProductMenu theProductMenu;
	ClassProductList classProductList;
	Product currentProduct;

	Person(){
		classProductList = new ClassProductList();
	}

	public abstract void showMenu();

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


	public abstract void CreateProductMenu(Product product, int level);

	public ClassProductList GetProductList() {
		return  classProductList;
	}

	public void AddProduct(Product theSelectedProduct) {
		classProductList.add(theSelectedProduct);
	}

	public boolean ShowMenu() {
		// create a iterator for the trading list
		//Iterator theIter=new ListIterator(CurrentProduct.AssList );

		Iterator theIter = currentProduct.classProductList.iterator();

		theProductMenu.theProduct = currentProduct;
		Trading trading;
		while (theIter.hasNext()) {
			trading = (Trading) theIter.next();
			theProductMenu.TradingCombox.addItem(trading);
		}
		return false;
	}
}