import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class RestartButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.panel.removeAll();
        MainFrame.playersCards();

        MainFrame.panel1.removeAll();
        MainFrame.computersCards();

        MainFrame.dealerHand = 0;
        MainFrame.playerHand = 0;

        MainFrame.valueUpdate();

        MainFrame.hitBtn.setEnabled(false);
        MainFrame.stayBtn.setEnabled(false);
        MainFrame.dealBtn.setEnabled(true);
        MainFrame.deck = new ArrayList<>();
    }
}
