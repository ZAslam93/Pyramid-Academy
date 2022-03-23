import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard {
    private static final int MAX_WIDTH = 5;
    private static final int MAX_HEIGHT = 5;
    private JPanel MainPanel;
    private JPanel displayPanel;
    private JPanel controlPanel;
    private JTextArea consoleText;
    private JButton STATSButton;
    private JButton UPButton;
    private JButton QUITButton;
    private JButton LEFTButton;
    private JButton DOWNButton;
    private JButton RIGHTButton;

    // 2D Array to hold Labels for Land rendering
    private JLabel[][] jLandArr = new JLabel[MAX_WIDTH][MAX_HEIGHT];


    // FInd out how to get the 2D labels on the sscreen
    public GameBoard() {
        STATSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
