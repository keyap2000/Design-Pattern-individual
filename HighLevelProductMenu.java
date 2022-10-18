import java.awt.*;

public class HighLevelProductMenu extends ProductMenu{

    HighLevelProductMenu(){}

    @Override
    public void showMenu() {

    }

    @Override
    public void showAddButton() {
        TradingAddButton.addActionListener(e -> TradingAddButton_actionPerformed());
        TradingAddButton.setText("Add");
        TradingAddButton.setBounds(new Rectangle(389, 54, 79, 29));
        OptionAddButton.setText("Add");
        OptionAddButton.setBounds(new Rectangle(390, 125, 79, 29));
        this.getContentPane().add(TradingAddButton, null);
        this.getContentPane().add(OptionAddButton, null);
    }

    private void TradingAddButton_actionPerformed() {
    }

    @Override
    public void showViewButton() {
        TradingViewButton.setText("View");
        TradingViewButton.setBounds(new Rectangle(290, 54, 79, 29));
        TradingViewButton.addActionListener(e -> AssignmentViewButton_actionPerformed());
        OptionViewButton.setText("View");
        OptionViewButton.setBounds(new Rectangle(290, 124, 79, 29));
        this.getContentPane().add(TradingViewButton, null);
        this.getContentPane().add(OptionViewButton, null);
    }

    private void AssignmentViewButton_actionPerformed() {
    }

    @Override
    public void showRadioButton() {
        TradingRadio.setText("Trading");
        TradingRadio.setBounds(new Rectangle(21, 55, 103, 26));
        this.getContentPane().add(TradingRadio, null);
        OptionRadio.setText("HighLevel Presentation");
        OptionRadio.setBounds(new Rectangle(21, 128, 103, 26));
        this.getContentPane().add(OptionRadio, null);
    }

    @Override
    public void showLabels() {

    }

    @Override
    public void showComboxes() {
        TradingCombox.setBounds(new Rectangle(140, 57, 126, 22));
        OptionCombo.setBounds(new Rectangle(137, 127, 126, 22));
        this.getContentPane().add(TradingCombox, null);
        this.getContentPane().add(OptionCombo, null);
        refresh();
    }
}
