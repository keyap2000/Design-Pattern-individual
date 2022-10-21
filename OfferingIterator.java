import java.util.Iterator;

public class OfferingIterator implements Iterator {

	private OfferingList offeringlist;

	///  pointing to the location before the first element
	private int CurrentOfferingNumber = -1;

	OfferingIterator(OfferingList theofferinglist)
	{
		offeringlist = theofferinglist;
		MoveToHead();
	}

	public boolean hasNext() {

		return CurrentOfferingNumber <  offeringlist.size() - 1;
	}

	public void MoveToHead() {
		CurrentOfferingNumber=-1;
	}

	public void remove() {
		offeringlist.remove(CurrentOfferingNumber);
	}

	/// get the next offering that fits the Username;
	Object next(String UserName)
	{
		Offering offering = (Offering) next();
		while(offering!=null)
		{
			if(UserName.compareTo(offering.theOfferor)==0)
			{
				return offering;
			}
			offering=(Offering) next();
		}
		return null;
	}

	public Object next()
	{
		if (hasNext())
		{
			CurrentOfferingNumber ++;
			return offeringlist.get(CurrentOfferingNumber);
		}
		else
		{
			return null;
		}
	}
}