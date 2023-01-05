import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class DealButtonListener implements ActionListener {
    static int scoreTemp = 0;
    static String temp1;
    static String card1;
    static String card2;
    static String deal1;
    static String deal2;
    static ImageIcon icon;
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.player1Label.setIcon(creater());
        MainFrame.playerHand += scoreTemp;
        card1 = temp1;
        MainFrame.player2Label.setIcon(creater());
        card2 = temp1;
        MainFrame.playerHand += scoreTemp;
        MainFrame.computer1Label.setIcon(creater());
        MainFrame.dealerHand += scoreTemp;
        deal1 = temp1;
        MainFrame.player3Label.setName("chosen");

        MainFrame.hitBtn.setEnabled(true);
        MainFrame.stayBtn.setEnabled(true);
        MainFrame.dealBtn.setEnabled(false);
        MainFrame.valueUpdate();

        MainFrame.player3Label.setName(null);

        if (((card1.equals("10") || card1.equals("jack") || card1.equals("queen") || card1.equals("king")) && card2.equals("ace")) || ((card2.equals("10") || card2.equals("jack") || card2.equals("queen") || card2.equals("king")) && card1.equals("ace"))){
            MainFrame.computer2Label.setIcon(DealButtonListener.creater());
            deal2 = temp1;
            MainFrame.dealerHand += DealButtonListener.scoreTemp;
            if (((deal1.equals("10") || deal1.equals("jack") || deal1.equals("queen") || deal1.equals("king")) && deal2.equals("ace")) || ((deal2.equals("10") || deal2.equals("jack") || deal2.equals("queen") || deal2.equals("king")) && deal1.equals("ace"))){
                MainFrame.player.setText("Push!");
                MainFrame.buttonDisable();
            }else{
                MainFrame.player.setText(MainFrame.playerName + " Won With Natural Blackjack");
                MainFrame.playerScore += 1;
                MainFrame.scoreUpdate();
                MainFrame.buttonDisable();
            }
        }
    }

    static ImageIcon creater(){
        Random random = new Random();
        String[] card = {"ace","jack","queen","king","2","3","4","5","6","7","8","9","10"};
        String[] temp = {"c","d","h","s"};
        int i = random.nextInt(card.length);
        int j = random.nextInt(temp.length);
        String tempCard ="/cards/" +card[i] + temp[j]+".jpg";

        if(MainFrame.deck.contains(tempCard)){
            return creater();
        }else{
            if (card[i].equals("jack") || card[i].equals("queen") || card[i].equals("king")){
                scoreTemp = 10;
            }else if(card[i].equals("ace") && MainFrame.playerHand < 11){
                scoreTemp = 11;
            }else if(card[i].equals("ace") && MainFrame.playerHand >= 11){
                scoreTemp = 1;
            }else{
                scoreTemp = Integer.parseInt(card[i]);
            }
            MainFrame.deck.add(tempCard);
        }

        temp1 = card[i];

        icon = new ImageIcon(Objects.requireNonNull(DealButtonListener.class.getResource(tempCard)));
        return icon;
    }
}
