import java.util.Iterator;

public abstract class Person {

	public int type = 0;		//by default buyer(0)
	public String UserName;
	String uname;
	private ProductMenu theProductMenu;
	ClassProductList classProductList;
	Product currentProduct;

	public abstract void showMenu();

	public void showAddButton() {

	}

	public void showViewButton() {

	}

	public void showRadioButton() {

	}

	public void showLabels() {

	}

	public abstract void CreateProductMenu(Product product, int level);

	public ClassProductList GetProductList() {
		return  classProductList;
	}

	public void AddProduct(Product theSelectedProduct) {
		classProductList.add(theSelectedProduct);
	}

	//public void CreateProductMenu(Product theSelectedProduct, int nProductCategory) {
	//}

	public boolean ShowMenu() {
		// create a iterator for the assignment list
		// Iterator theIter=new ListIterator(CurrentCourse.AssList );

		Iterator theIter = currentProduct.classProductList.iterator();

		//theProductMenu.theProduct = currentProduct;
		//Assignment theAssignment;
//		while (theIter.hasNext()) {
//			theAssignment = (Assignment) theIter.next();
//			theCourseMenu.AssignmentCombox.addItem(theAssignment);
//		}
		return false;
	}
}