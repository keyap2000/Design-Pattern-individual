import java.text.DateFormat;
import java.util.Date;

public class Trading {

	private Product product;
	private OfferingList offeringList = new OfferingList();
	Offering offering = new Offering();
	String offeringName;
	Date DueDate=new Date();

	public  Trading(){}

	////add the theSolution to the Solutionlist
	void AddOffering(Offering offering)
	{
		offeringList.add(offering);
	}

	OfferingIterator GetSolutionIterator()
	{
		return new OfferingIterator(offeringList);
	}

	public String toString()
	{
		return offeringName;
	}

	String getDueDateString()
	{
		DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
		return  dateFormat.format(DueDate);
	}
	public void accept(NodeVisitor visitor) {
		visitor.visitTrading(this);
	}

}
