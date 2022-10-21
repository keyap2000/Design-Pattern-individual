import java.awt.*;

public class MeatProductMenu extends ProductMenu {

	MeatProductMenu(){}

	public void showMenu() {

	}

	public void showAddButton() {
		TradingAddButton.addActionListener(e -> TradingAddButton_actionPerformed());
		TradingAddButton.setText("Add");
		TradingAddButton.setBounds(new Rectangle(390, 55, 80, 30));
		OptionAddButton.setText("Add");
		OptionAddButton.setBounds(new Rectangle(390, 125, 80, 30));
		this.getContentPane().add(TradingAddButton, null);
		this.getContentPane().add(OptionAddButton, null);
	}

	public void showViewButton() {
		TradingViewButton.setText("View");
		TradingViewButton.setBounds(new Rectangle(290, 55, 80, 30));
		TradingViewButton.addActionListener(e -> TradingViewButton_actionPerformed());
		OptionViewButton.setText("View");
		OptionViewButton.setBounds(new Rectangle(290, 125, 80, 30));
		this.getContentPane().add(TradingViewButton, null);
		this.getContentPane().add(OptionViewButton, null);
	}

	public void showRadioButton() {
		TradingRadio.setText("Trading");
		TradingRadio.setBounds(new Rectangle(20, 55, 103, 26));
		this.getContentPane().add(TradingRadio, null);
		OptionRadio.setText("Meat Product");
		OptionRadio.setBounds(new Rectangle(20, 130, 103, 26));
		this.getContentPane().add(OptionRadio, null);
	}

	public void showLabels() {

	}

	public void showComboxes() {
		TradingCombox.setBounds(new Rectangle(140, 57, 126, 22));
		OptionCombo.setBounds(new Rectangle(137, 127, 126, 22));
		this.getContentPane().add(TradingCombox, null);
		this.getContentPane().add(OptionCombo, null);
		refresh();
	}
}