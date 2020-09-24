import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Browser extends JFrame {

    private JPanel container;
    private JPanel header;
    private JPanel center;
    private JPanel SearchBar;
    private JPanel quick;
    private JButton forwardButton;
    private JButton refreshButton;
    private JButton topsearch;
    private JTextField topBox;
    private JButton back;
    private JLabel google;
    private JTextField centerbox;
    private JButton centersearch;
    private JButton button2;
    private JButton button1;
    private JButton button3;
    private JButton button4;

    Browser(){
        super("WEB BROWSER");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //windows close event//
        //Start
        addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
           int x = JOptionPane.showConfirmDialog(null,"Do You Want To Close?","Close Windows",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if (x==JOptionPane.YES_OPTION){
                //dispose();
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
            else setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
          }
        });

        //END

        //Search top EVENT
        //Start
        topsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new page2(topBox.getText());
                dispose();
            }
        });

        //END

        //Start Center Event//
        //Start
        centerbox.setText("Enter Your URL");
        topBox.setText("https://");
        centersearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new page2(centerbox.getText());
                dispose();
            }
        });
        //END

        add(container);
        setVisible(true);
    }
}