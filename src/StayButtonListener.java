import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StayButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        boolean b = true;
        MainFrame.computer2Label.setIcon(DealButtonListener.creater());
        DealButtonListener.deal2 = DealButtonListener.temp1;
        if (((DealButtonListener.deal1.equals("10") || DealButtonListener.deal1.equals("jack") || DealButtonListener.deal1.equals("queen") || DealButtonListener.deal1.equals("king")) && DealButtonListener.deal2.equals("ace")) || ((DealButtonListener.deal2.equals("10") || DealButtonListener.deal2.equals("jack") || DealButtonListener.deal2.equals("queen") || DealButtonListener.deal2.equals("king")) && DealButtonListener.deal1.equals("ace"))){
            MainFrame.player.setText("Dealer Won With Natural BlackJack!");
            MainFrame.dealerScore += 1;
            MainFrame.buttonDisable();
            MainFrame.scoreUpdate();
            b = false;
        }
        MainFrame.dealerHand += DealButtonListener.scoreTemp;

        if (b){
            if (MainFrame.dealerHand < 18){
                MainFrame.computer3Label.setIcon(DealButtonListener.creater());
                MainFrame.dealerHand += DealButtonListener.scoreTemp;
            }

            while (MainFrame.dealerHand < 18){
                JLabel jLabel = new JLabel(DealButtonListener.creater());
                MainFrame.panel1.add(jLabel);
                MainFrame.dealerHand += DealButtonListener.scoreTemp;
            }
            MainFrame.valueUpdate();

            if (MainFrame.dealerHand > 21){
                MainFrame.player.setText(MainFrame.playerName + " Won");
                MainFrame.playerScore += 1;
                MainFrame.buttonDisable();
            } else if (MainFrame.playerHand > MainFrame.dealerHand){
                MainFrame.player.setText(MainFrame.playerName + " Won");
                MainFrame.playerScore += 1;
                MainFrame.buttonDisable();
            }else if (MainFrame.playerHand < MainFrame.dealerHand){
                MainFrame.player.setText(MainFrame.playerName + " Lost");
                MainFrame.dealerScore += 1;
                MainFrame.buttonDisable();
            }else {
                MainFrame.player.setText("Draw");
                MainFrame.buttonDisable();
            }
            MainFrame.scoreUpdate();
        }


    }
}
