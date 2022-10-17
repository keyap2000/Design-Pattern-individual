public class OfferingIterator implements ListIterator {

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

	public Product Next() {
		//return type - Offering

		if (hasNext())
		{
			CurrentOfferingNumber ++;
			return (Product) offeringlist.get(CurrentOfferingNumber);
		}
		else
		{
			return null;
		}
	}

	public void MoveToHead() {
		CurrentOfferingNumber=-1;
	}

	public void Remove() {
		offeringlist.remove(CurrentOfferingNumber);
	}
}