import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class BuyerTradingMenu extends TradingMenu {

    private boolean boolSubmit = false;

    private JLabel lTradingName = new JLabel();
    private JLabel lDueDate = new JLabel();
    private JTextField tbOffering = new JTextField();
    private JLabel lSuggestedOffering = new JLabel();
    private JLabel lBidding = new JLabel();
    private JButton bSubmit = new JButton();
    private JButton bCancel = new JButton();

    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();

    BuyerTradingMenu() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        private void jbInit() {
            jLabel1.setText("Assignment : ");
            jLabel1.setBounds(new Rectangle(20, 36, 91, 18));
            this.getContentPane().setLayout(null);
            lTradingName.setText("jLabel2");
            lTradingName.setBounds(new Rectangle(258, 35, 282, 18));
            jLabel3.setText("Due Date");
            jLabel3.setBounds(new Rectangle(21, 81, 92, 18));
            lDueDate.setText("jLabel4");
            lDueDate.setBounds(new Rectangle(254, 82, 294, 18));
            jLabel5.setText("Solution");
            jLabel5.setBounds(new Rectangle(24, 128, 93, 18));
            tbOffering.setText("jTextField1");
            tbOffering.setBounds(new Rectangle(251, 127, 211, 22));
            jLabel6.setText("Suggested Solution");
            jLabel6.setBounds(new Rectangle(24, 174, 117, 18));
            jLabel7.setText("Grade");
            jLabel7.setBounds(new Rectangle(23, 224, 41, 18));
            lSuggestedOffering.setText("jLabel8");
            lSuggestedOffering.setBounds(new Rectangle(259, 169, 201, 18));
            lBidding.setText("jLabel9");
            lBidding.setBounds(new Rectangle(258, 226, 41, 18));
            bSubmit.setText("Submit");
            bSubmit.setBounds(new Rectangle(476, 124, 79, 29));
            bSubmit.addActionListener(e -> bSubmit_actionPerformed());
            bCancel.setText("Cancel");
            bCancel.setBounds(new Rectangle(475, 164, 79, 29));
            bCancel.addActionListener(e -> bCancel_actionPerformed());
            this.getContentPane().add(jLabel1, null);
            this.getContentPane().add(jLabel3, null);
            this.getContentPane().add(jLabel5, null);
            this.getContentPane().add(jLabel6, null);
            this.getContentPane().add(lTradingName, null);
            this.getContentPane().add(lDueDate, null);
            this.getContentPane().add(tbOffering, null);
            this.getContentPane().add(jLabel7, null);
            this.getContentPane().add(lSuggestedOffering, null);
            this.getContentPane().add(lBidding, null);
            this.getContentPane().add(bSubmit, null);
            this.getContentPane().add(bCancel, null);

    }

    /*
     * check if the buyer has already had a offering or not. if not , create a new
     * offering for the buyer. after showing the offering attach the offering;
     */
    public void ShowMenu(Trading trading, Person thePerson) {
        OfferingIterator theIter = trading.GetSolutionIterator();
        Offering theOffering = (Offering) theIter.next(thePerson.UserName);
        if (theOffering == null) {
            tbOffering.setText("");
            lBidding.setText("-1");
        } else {
            tbOffering.setText(theOffering.OfferingFileName);
            lBidding.setText(theOffering.getBiddingString());

        }

        lTradingName.setText(trading.tradingName);
        lDueDate.setText(trading.DueDate.toString());
        lSuggestedOffering.setText(trading.SuggestOffering.OfferingFileName);

        setVisible(true);

        if (boolSubmit) {
            if (theOffering == null) {
                theOffering = new Offering();
                trading.AddOffering(theOffering);
            }
            theOffering.theOfferor = thePerson.UserName;
            theOffering.OfferingFileName = tbOffering.getText();
            theOffering.theSubmittedDate = new Date();
        }
    }

    private void bCancel_actionPerformed() {
        boolSubmit = false;
        dispose();
    }

    private void bSubmit_actionPerformed() {
        boolSubmit = true;
        dispose();
    }
}
