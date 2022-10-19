import java.util.Date;

public class Offering {

	public String theOfferor = "";
	public String OfferingFileName;
	public Date theSubmittedDate = new Date();
	private OfferingList offeringList;
	int theBidding;
	private boolean submitted = false;

	Offering(){

	}
	public String getBiddingString() {
		if (isSubmitted())
			return "" + theBidding;
		else
			return "-1";
	}

	public String toString() {
		String string;
		string = theOfferor + "  " + OfferingFileName + " Bidding=" + getBiddingInt() + "  ";
		if (isSubmitted())
			string += "submitted";
		else
			string += "not submitted";

		return (string);
	}


	int getBiddingInt() {
		return theBidding;
	}

	void setSubmitted() {
		this.submitted = true;
	}

	private boolean isSubmitted() {
		return submitted;
	}
}