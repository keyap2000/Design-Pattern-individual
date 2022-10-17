public abstract class Person {

	public int type = 0;		//by default buyer(0)
	String uname;
	private ProductMenu theProductMenu;
	ClassProductList classProductList;

	public abstract void showMenu();

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public abstract ProductMenu CreateProductMenu();

	public ClassProductList GetProductList() {
		return  classProductList;
	}
}