public abstract class NodeVisitor {

	NodeVisitor(){

	}

	public abstract void visitProduct(Product product);

	public abstract void visitTrading(Trading trading);

	public abstract void visitFacade(Facade facade);

}