import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

	private ProductIterator productIterator;
	private ReminderVisitor reminderVisitor;
	private Product[] product;
	
	public ClassProductList(){

	}

	public void accept(NodeVisitor visitor) {
		//visitor.visitFacade(visitor);
	}


    public void InitializeFromFile() {
		try {
			BufferedReader file;
			String strProductName;
			file = new BufferedReader(new FileReader("ProductInfo.txt"));
			while ((strProductName = file.readLine()) != null) {
				Product product;
				product = new Product(strProductName);
		        //product.productName = strProductName;
				System.out.println(product);
				add(product);
			}
		} catch (Exception ignored) {
		}
    }
}