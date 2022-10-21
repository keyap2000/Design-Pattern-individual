import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OfferingBiddingDialog extends JDialog {

    private Offering offering;
    private JLabel jLabel1 = new JLabel();
    private JTextField tfBidding = new JTextField();
    private JButton buttonOK = new JButton();
    private JLabel labelOfferedPrice = new JLabel();

    OfferingBiddingDialog(){
        try {
            jbInit();
            setSize(316, 186);
            setModal(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() {
        jLabel1.setText("Offering File Name");
        jLabel1.setBounds(new Rectangle(23, 30, 121, 18));
        this.getContentPane().setLayout(null);
        tfBidding.setBounds(new Rectangle(25, 66, 100, 22));
        buttonOK.setText("OK");
        buttonOK.setBounds(new Rectangle(217, 67, 79, 29));
        buttonOK.addActionListener(this::buttonOK_actionPerformed);
        labelOfferedPrice.setBounds(new Rectangle(212, 34, 163, 18));
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(tfBidding, null);
        this.getContentPane().add(labelOfferedPrice, null);
        this.getContentPane().add(buttonOK, null);
    }

    private void buttonOK_actionPerformed(ActionEvent actionEvent) {
        offering.theBidding = Integer.parseInt(tfBidding.getText());
        dispose();
    }

    public void show(Offering offering) {
        offering = offering;
        tfBidding.setText("" + offering.getBiddingInt());
        labelOfferedPrice.setText(offering.OfferedPrice);
        setVisible(true);
    }
}