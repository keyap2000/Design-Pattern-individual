import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class ProductMenu extends JDialog {

	//Person person = new Person();
	Product theProduct = null;
	boolean bLogout = true;

	JRadioButton TradingRadio = new JRadioButton();
	JComboBox<Trading> TradingCombox = new JComboBox<>();
	JButton TradingViewButton = new JButton();
	JButton TradingAddButton = new JButton();
	JRadioButton OptionRadio = new JRadioButton();
	JComboBox OptionCombo = new JComboBox();
	JButton OptionViewButton = new JButton();
	JButton OptionAddButton = new JButton();
	JButton buttonChangeProduct = new JButton();
	JButton buttonLogout = new JButton();

	ProductMenu(){
		try
		{
			jbInit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		setModal(true);
		setSize(500,300);
	}

	private void jbInit() {
		buttonChangeProduct.setText("Change Product");
		buttonChangeProduct.setBounds(new Rectangle(101, 211, 73, 37));
		buttonChangeProduct.addActionListener(this::buttonChangeProduct_actionPerformed);
		this.getContentPane().setLayout(null);
		this.setTitle("");
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
		buttonLogout.addActionListener(this::buttonLogout_actionPerformed);
		this.getContentPane().add(buttonChangeProduct, null);
		this.getContentPane().add(buttonLogout, null);
	}

	private void buttonChangeProduct_actionPerformed(ActionEvent e) {
		bLogout=false;
		dispose();
	}

	private void buttonLogout_actionPerformed(ActionEvent e)
	{
		bLogout=true;
		dispose();
	}

	boolean ifLogout()
	{
		return bLogout;
	}

	public abstract void showMenu();

	public abstract void showAddButton();
	public abstract void showViewButton();
	public abstract void showRadioButton();

	public abstract void showLabels();

	public abstract void showComboxes();

	void refresh()
	{
		TradingCombox.removeAllItems() ;
		for (Trading trading : theProduct.tradingList) {
			TradingCombox.addItem(trading);
		}
	}

	void TradingAddButton_actionPerformed()
	{
		Main.theFacade.addTrading(theProduct);
		refresh();
	}
	void TradingViewButton_actionPerformed()
	{
		Trading trading = (Trading) TradingCombox.getSelectedItem() ;
		Main.theFacade.viewTrading(trading);
	}
}