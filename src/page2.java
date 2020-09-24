import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class page2 extends JFrame {

    //CONVERT HTML AND SET AS STRING
    void HtmlToStr(String seturl) {
        try {
            display.setPage(seturl);
            topBox.setText(seturl);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private JPanel header;
    private JButton forwardButton;
    private JButton refreshButton;
    private JButton topsearch;
    private JTextField topBox;
    private JButton back;
    private JPanel header2;
    private JEditorPane display;
    private JScrollBar scroll;

    page2(String geturl) {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //header2.add(scroll);
        add(header2);
        setVisible(true);
        topBox.setText(geturl);
        display.setEditable(false);

        //windows close event//
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int x = JOptionPane.showConfirmDialog(null,"Do You Want To Close?","Close Windows",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
                if (x==JOptionPane.YES_OPTION){
                    //dispose();
                    System.out.println("Thank You For Browsing ");
                    setDefaultCloseOperation(EXIT_ON_CLOSE);
                }
                else setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            }
        });

        topsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("YOU ARE BROWSING "+topBox.getText());
                HtmlToStr(topBox.getText());
            }
        });

        topBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("YOU ARE BROWSING "+e.getActionCommand());
                HtmlToStr(e.getActionCommand());
            }
        });

        //link update and pass string
        //Start
       display.addHyperlinkListener(new HyperlinkListener() {
           @Override
           public void hyperlinkUpdate(HyperlinkEvent e) {
               if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                   HtmlToStr(e.getURL().toString());
               }
           }
       });
       //End
    }
}