package ui;

import fetcher.YoutubeVideoUrlFetcher;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class List2UrlsGui {
  private JPanel panel;
  private JButton btnFetch;
  private JTextPane textPaneUrls;
  private JTextPane textPaneList;

  public List2UrlsGui() {
    btnFetch.addActionListener(e -> {
      ArrayList<String> list = new ArrayList<>(Arrays.asList(textPaneList.getText().split("\\r?\\n")));
      textPaneUrls.setText(String.join("\n", new YoutubeVideoUrlFetcher().imFeelingLuckySearch(list)));
    });
  }

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    JFrame frame = new JFrame("List2Urls");
    frame.setContentPane(new List2UrlsGui().panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
