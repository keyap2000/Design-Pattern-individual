import java.util.regex.Pattern;

public class Reminder {

    public void showReminder(ClassProductList getProductList) {
        ReminderVisitor visitor = new ReminderVisitor(this);
        //visitor.visitFacade(Design-Pattern-individual-.theFacade);
        //setVisible(true);
    }
}