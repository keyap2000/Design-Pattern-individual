import java.util.Date;

public class Offering {

	//the buyer who offered the price for any product
	public String theOfferor = "";

	//the price offered
	public String OfferedPrice;

	//on which date the price was offered
	public Date theSubmittedDate = new Date();

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
		string = theOfferor + "  " + OfferedPrice + " Bidding=" + getBiddingInt() + "  ";
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