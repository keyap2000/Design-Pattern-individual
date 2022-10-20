import java.util.Iterator;

public class ProductIterator implements Iterator{

	private ClassProductList classProductList;
	private int CurrentProductNumber=-1;

	ProductIterator(ClassProductList classproductlist){
		classProductList = classproductlist;
	}

	public boolean hasNext() {
		System.out.println("class product list : " + classProductList);
		return CurrentProductNumber < classProductList.size() - 1;
	}

	@Override
	public Object next() {
		return null;
	}


	public Product Next() {

		if(hasNext()){
			CurrentProductNumber ++;
			return classProductList.get(CurrentProductNumber);
		}
		else{
			return null;
		}
	}

	public void MoveToHead() {

	}

	public void Remove() {
		classProductList.remove(CurrentProductNumber);
	}

    public Product next(String strProductName) {
		Product product = (Product) Next();
		while(product != null)
		{
			if(strProductName.compareTo(product.toString())==0)
			{
				return product;
			}
			product = (Product) Next();
		}
		return null;
	}
}