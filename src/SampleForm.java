import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mitchellvaline on 4/30/15.
 */
public class SampleForm extends JFrame {
    private JButton quitButton;
    private JPanel rootPanel;
    private JButton newGameButton;
    private JLabel totalLabel;
    private JTextField betText;
    private JButton rollDiceButton;

    int total;


    public SampleForm() {
        super("Hello World");

        setContentPane(rootPanel);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SampleForm.this.newGame();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SampleForm.super.dispose();
            }
        });

        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    SampleForm.this.rollDice(Integer.parseInt(betText.getText()));
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Enter positive integers only");
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "An unknown error occurred, please try again");
                }
                finally {
                    betText.setText("");
                }

            }
        });

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        setVisible(true);
    }

    public void newGame() {
        try {
            total = Integer.parseInt(JOptionPane.showInputDialog("Enter total betting $"));
            totalLabel.setText("$" + Integer.toString(total));
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Enter positive integers only");
            newGame();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "An unknown error occurred, please try again");
            newGame();
        }
    }

    public void rollDice(int bet) {
        if(bet > 0 && bet <= total) {
            Dice dice1 = new Dice();
            Dice dice2 = new Dice();

            dice1.rollDice();
            dice2.rollDice();

            int result = dice1.getValue() + dice2.getValue();

            String message;
            if (result == 7 || result == 11) {
                total = total + (bet * 3);
                message = "Congratulations, You rolled a " + Integer.toString(result)
                        + ". You won: $" + Integer.toString(bet * 3);
            } else {
                total = (total - bet);
                message = "Sorry, You rolled a " + Integer.toString(result);
            }
            JOptionPane.showMessageDialog(null, message);

            totalLabel.setText("$" + Integer.toString(total));
        }
        else if(bet > total){
            JOptionPane.showMessageDialog(null, "You don't have that much money");
        }
        else{
            JOptionPane.showMessageDialog(null, "Enter a positive integer");
        }
    }
}
