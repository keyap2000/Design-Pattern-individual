import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;

public class SellerTradingMenu extends TradingMenu {
    private Trading trading;
    private JComboBox<Offering> comboOfferingList = new JComboBox<>();

    private JTextField tbTradingName = new JTextField();
    private JTextField tbDueDate = new JTextField();
    private JTextField tbSuggestedOffering = new JTextField();

    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JButton buttonBidding = new JButton();
    private JButton buttonSubmit = new JButton();
    private JButton buttonClose = new JButton();

    SellerTradingMenu(){
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void jbInit() {
        jLabel1.setText("Trading Name");
        jLabel1.setBounds(new Rectangle(25, 31, 118, 18));
        this.getContentPane().setLayout(null);
        tbTradingName.setText("jTextField1");
        tbTradingName.setBounds(new Rectangle(192, 31, 341, 22));
        jLabel2.setText("Due Date");
        jLabel2.setBounds(new Rectangle(28, 90, 113, 18));
        tbDueDate.setText("tbDueDate");
        tbDueDate.setBounds(new Rectangle(195, 87, 337, 22));
        jLabel3.setText("Suggested Offering");
        jLabel3.setBounds(new Rectangle(28, 151, 118, 18));
        tbSuggestedOffering.setText("jTextField2");
        tbSuggestedOffering.setBounds(new Rectangle(197, 149, 339, 22));
        buttonBidding.setText("Bidding");
        buttonBidding.setBounds(new Rectangle(458, 199, 79, 29));
        buttonBidding.addActionListener(this::buttonBidding_actionPerformed);
        buttonSubmit.setText("Submit");
        buttonSubmit.setBounds(new Rectangle(365, 249, 79, 29));
        buttonSubmit.addActionListener(this::buttonSubmit_actionPerformed);
        buttonClose.setText("Close");
        buttonClose.setBounds(new Rectangle(86, 253, 79, 29));
        buttonClose.addActionListener(this::buttonClose_actionPerformed);
        comboOfferingList.setBounds(new Rectangle(32, 204, 413, 22));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tbTradingName, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(tbDueDate, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(tbSuggestedOffering, null);
        this.getContentPane().add(buttonClose, null);
        this.getContentPane().add(comboOfferingList, null);
        this.getContentPane().add(buttonBidding, null);
        this.getContentPane().add(buttonSubmit, null);
    }

    private void buttonClose_actionPerformed(ActionEvent actionEvent) {
        trading.tradingName = tbTradingName.getText() ;
        DateFormat tempDateFormat=DateFormat.getDateInstance(DateFormat.SHORT );
        try
        {
            trading.DueDate=tempDateFormat.parse(tbDueDate.getText() );
        }catch (Exception ignored){}
        trading.SuggestOffering.OfferingFileName =tbSuggestedOffering.getText() ;
        dispose();
    }

    private void buttonSubmit_actionPerformed(ActionEvent actionEvent) {
        OfferingIterator iter=new OfferingIterator(trading.offeringList);
        while(iter.hasNext() )
        {
            Offering anOffer = (Offering) iter.next();
            anOffer.setSubmitted();
        }
        refreshOfferingList();
    }

    private void buttonBidding_actionPerformed(ActionEvent actionEvent) {
        Offering offering = (Offering) comboOfferingList.getSelectedItem() ;
        if (offering==null)
            return;
        OfferingBiddingDialog dialog=new OfferingBiddingDialog();
        dialog.show(offering);
        refreshOfferingList();
    }

    public void ShowMenu(Trading Trading, Person person)
    {
        trading = Trading;
        tbTradingName.setText(trading.tradingName);

        DateFormat theDateFormat=DateFormat.getDateInstance(DateFormat.SHORT );
        tbDueDate.setText(theDateFormat.format(trading.DueDate));
        tbSuggestedOffering.setText(trading.SuggestOffering.OfferingFileName );
        refreshOfferingList();
        setVisible(true);
    }

    private void refreshOfferingList() {
        comboOfferingList.removeAllItems() ;
        OfferingIterator offeringIter = new OfferingIterator(trading.offeringList);
        while(offeringIter.hasNext())
        {
            Offering offering = (Offering) offeringIter.next();
            comboOfferingList.addItem(offering);
        }
    }
}