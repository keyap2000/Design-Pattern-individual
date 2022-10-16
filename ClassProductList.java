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
}