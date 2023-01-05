import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class HitButtonListener implements ActionListener {
    static String card3;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.player3Label.getName() == null){
            MainFrame.player3Label.setIcon(DealButtonListener.creater());
            card3 = DealButtonListener.temp1;
            MainFrame.player3Label.setName("chosen");
        }else{
            JLabel jLabel = new JLabel(DealButtonListener.creater());
            MainFrame.panel.add(jLabel);
        }

        MainFrame.playerHand += DealButtonListener.scoreTemp;
        MainFrame.valueUpdate();


        if(MainFrame.playerHand == 11 && (DealButtonListener.card1.equals("ace") || DealButtonListener.card2.equals("ace") || card3.equals("ace"))){
            MainFrame.player.setText(MainFrame.playerName + " Won With Natural Blackjack");
            MainFrame.playerScore += 1;
            MainFrame.scoreUpdate();
            MainFrame.buttonDisable();
        }
    }
}
