import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class MainFrame extends JFrame {
    static JButton hitBtn;
    static JButton stayBtn;
    static JButton dealBtn;
    JButton restart;
    static JPanel panel;
    static ImageIcon player1;
    static ImageIcon player2;
    static ImageIcon player3;

    static JLabel player1Label;
    static JLabel player2Label;
    static JLabel player3Label;
    static Point loc;
    static JLabel computer1Label;
    static JLabel computer2Label;
    static JLabel computer3Label;

    static JLabel dealer;
    static JLabel player;

    static int dealerHand = 0;
    static int playerHand = 0;

    static JLabel dealerWins;
    static JLabel playerWins;
    static int dealerScore = 0;
    static int playerScore = 0;
    static JPanel panel1;
    static String playerName = "Player";
    static ArrayList<String> deck = new ArrayList<>();

    public MainFrame() throws HeadlessException {
        super("Black Jack");
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(new Color(0,137,47));

        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(new Color(0,137,47));

        restart = new JButton("New Game");
        restart.addActionListener(new RestartButtonListener());

        dealer = new JLabel("Dealer Hand: " + dealerHand);
        player = new JLabel(playerName +" Hand: " + playerHand);

        dealer.setFont(new Font("TimesNewRoman",Font.BOLD,20));
        player.setFont(new Font("TimesNewRoman",Font.BOLD,20));

        dealerWins = new JLabel("Dealer Score: " + dealerScore);
        playerWins = new JLabel(playerName + " Score: " + playerScore);
        dealerWins.setFont(new Font("TimesNewRoman",Font.BOLD,15));
        playerWins.setFont(new Font("TimesNewRoman",Font.BOLD,15));

        playersCards();
        computersCards();

        //dealerWins label
        gc.weightx = 0;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.PAGE_START;
        gc.insets = new Insets(40,0,0,0);
        add(dealerWins, gc);

        //playerWins label
        gc.weightx = 0;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.PAGE_START;
        gc.insets = new Insets(70,0,0,0);
        add(playerWins, gc);

        //restart
        gc.weightx = 0;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.PAGE_START;
        gc.insets = new Insets(100,0,0,0);
        add(restart, gc);

        //dealer label
        gc.weightx = 0;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.NORTH;
        gc.insets = new Insets(20,0,0,0);
        add(dealer, gc);

        //playercards Button
        gc.weightx = 0;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.NORTH;
        gc.insets = new Insets(50,0,0,0);
        add(panel1, gc);

        //player label
        gc.weightx = 0;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.SOUTH;
        gc.insets = new Insets(0,0,120,0);
        add(player, gc);

        //playercards Button
        gc.weightx = 0;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.SOUTH;
        gc.insets = new Insets(0,0,0,0);
        add(panel, gc);

        //stayBtn Button
        gc.weightx = 0;
        gc.weighty = 1;
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.SOUTH;
        gc.insets = new Insets(0,0,10,0);
        add(buttons(), gc);

        if(loc != null){
            setLocation(loc);
        }

        getContentPane().setBackground(new Color(0,137,47));
        setSize(800,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        hitBtn.setEnabled(false);
        stayBtn.setEnabled(false);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }

    private JPanel buttons(){
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(0,3,20,0));

        Border outerBorder = BorderFactory.createEtchedBorder(Color.white, Color.gray);
        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel1.setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));

        //hitBtn Button
        hitBtn = new JButton();
        hitBtn.setText("Hit!");
        hitBtn.setPreferredSize(new Dimension(130,25));
        hitBtn.addActionListener(new HitButtonListener());

        //stayBtn Button
        stayBtn = new JButton();
        stayBtn.setText("Stay!");
        stayBtn.setPreferredSize(new Dimension(130,25));
        stayBtn.addActionListener(new StayButtonListener());

        //delaBtn Button
        dealBtn = new JButton();
        dealBtn.setText("Deal!");
        dealBtn.setPreferredSize(new Dimension(130,25));
        dealBtn.addActionListener(new DealButtonListener());

        panel1.add(hitBtn);
        panel1.add(stayBtn);
        panel1.add(dealBtn);

        panel1.setBackground(new Color(0,137,47));

        return panel1;
    }

    static void playersCards(){
        player1 = new ImageIcon(Objects.requireNonNull(MainFrame.class.getResource("/cards/back.jpg")));
        player2 = new ImageIcon(Objects.requireNonNull(MainFrame.class.getResource("/cards/back.jpg")));
        player3 = new ImageIcon(Objects.requireNonNull(MainFrame.class.getResource("/cards/back.jpg")));

        player1Label = new JLabel(player1);
        player2Label = new JLabel(player2);
        player3Label = new JLabel(player3);

        panel.add(player1Label);
        panel.add(player2Label);
        panel.add(player3Label);
    }

    static void computersCards(){
        player1 = new ImageIcon(Objects.requireNonNull(MainFrame.class.getResource("/cards/back.jpg")));
        player2 = new ImageIcon(Objects.requireNonNull(MainFrame.class.getResource("/cards/back.jpg")));
        player3 = new ImageIcon(Objects.requireNonNull(MainFrame.class.getResource("/cards/back.jpg")));

        computer1Label = new JLabel(player1);
        computer2Label = new JLabel(player2);
        computer3Label = new JLabel(player3);

        panel1.add(computer1Label);
        panel1.add(computer2Label);
        panel1.add(computer3Label);

    }

    static void valueUpdate(){
        if (playerHand > 21){
            player.setText(playerName + " Lost");
            dealerScore += 1;
            scoreUpdate();
            buttonDisable();
        }else if (playerHand == 21){
            player.setText("Player Won");
            playerScore += 1;
            scoreUpdate();
            buttonDisable();
        }else{
            player.setText(playerName + " Hand: " + playerHand);
            dealer.setText("Dealer Hand: " + dealerHand);
        }
    }
    static void scoreUpdate(){
        playerWins.setText(playerName + " Score: " + playerScore);
        dealerWins.setText("Dealer Score: " + dealerScore);
    }

    static void buttonDisable(){
        MainFrame.hitBtn.setEnabled(false);
        MainFrame.stayBtn.setEnabled(false);
        MainFrame.dealBtn.setEnabled(false);
    }

}
