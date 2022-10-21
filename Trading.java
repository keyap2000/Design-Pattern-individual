import java.text.DateFormat;
import java.util.Date;

public class Trading {

	public String tradingName;
	public Offering SuggestOffering = new Offering();
	OfferingList offeringList = new OfferingList();
	Date DueDate=new Date();

	public Trading(){}

	void AddOffering(Offering offering)
	{
		offeringList.add(offering);
	}

	OfferingIterator GetOfferingIterator()
	{
		return new OfferingIterator(offeringList);
	}

	public String toString()
	{
		return tradingName;
	}

	String getDueDateString()
	{
		DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
		return  dateFormat.format(DueDate);
	}

	//visitor design pattern
	public void accept(NodeVisitor visitor) {
		visitor.visitTrading(this);
	}

}