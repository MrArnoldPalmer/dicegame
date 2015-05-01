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

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




        setVisible(true);
    }

    public void newGame() {
        total = Integer.parseInt(JOptionPane.showInputDialog("Enter total betting $"));
        totalLabel.setText("$" + Integer.toString(total));
    }
}
