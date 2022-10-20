import java.text.DateFormat;
import java.util.Date;

public class Trading {

	public String tradingName;
	public Offering SuggestOffering = new Offering();
	private Product product;
	OfferingList offeringList = new OfferingList();
	String offeringName;
	Date DueDate=new Date();

	public Trading(){}

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