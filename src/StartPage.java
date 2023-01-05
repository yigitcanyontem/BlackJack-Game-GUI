import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StartPage extends JFrame {
    static JButton newGame;
    static JTextField nameField;
    static ImageIcon backgroundImage;
    public StartPage() throws HeadlessException {
        super("Black Jack");
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        newGame = new JButton("START");
        newGame.setBackground(new Color(189, 233, 219));
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Objects.equals(nameField.getText(), "")){
                    String temp = nameField.getText().toLowerCase();
                    temp = temp.substring(0, 1).toUpperCase() + temp.substring(1).toLowerCase();
                    MainFrame.playerName = temp;
                    MainFrame.loc = getLocation();
                }
                StartPage.super.dispose();
                new MainFrame();
            }
        });

        gc.weightx = 0;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.SOUTH;
        gc.insets = new Insets(0,0,50,0);
        add(newGame, gc);

        //dealerWins label
        gc.weightx = 0;
        gc.weighty = 1;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0,0,0,0);
        add(imageB(), gc);


        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(100,20));
        nameField.setMinimumSize(nameField.getPreferredSize());


        gc.weightx = 2;
        gc.weighty = 0;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(75,0,0,490);
        add(nameField, gc);


        pack();
        getContentPane().setBackground(new Color(0,55,47));
        setSize(800,500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }

    private JPanel imageB(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(new Color(0,55,47));

        backgroundImage = new ImageIcon(Objects.requireNonNull(getClass().getResource("/background3.jpg")));
        JLabel backPanel = new JLabel();
        backPanel.setIcon(backgroundImage);
        panel.add(backPanel);

        return panel;
    }


}
