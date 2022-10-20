import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

	private ReminderVisitor reminderVisitor;
	private Product[] product;

	public void ClassProductList(){

	}

	public ClassProductList(){}

    public void InitializeFromFile() {
		try {
			BufferedReader file;
			String strProductName;
			file = new BufferedReader(new FileReader("ProductInfo.txt"));
			while ((strProductName = file.readLine()) != null) {
				Product product = new Product(strProductName);
				System.out.println("product : " + product);
				add(product);
				System.out.println("product added");
			}
		} catch (Exception ignored) {
		}
	}
}