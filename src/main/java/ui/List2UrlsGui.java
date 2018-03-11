package main.java.ui;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List2UrlsGui {
    private JPanel panel;
    private JButton btnFetch;
    private JTextPane textPaneUrls;
    private JTextPane textPaneList;

    public List2UrlsGui() {
        btnFetch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPaneUrls.setText(new fetcher.Fetcher().fetch(textPaneList.getText()));
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("List2Urls");
        frame.setContentPane(new List2UrlsGui().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
