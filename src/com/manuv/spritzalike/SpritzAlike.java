package com.manuv.spritzalike;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.manuv.spritzalike.algorithms.BestLetterAlgorithm;
import com.manuv.spritzalike.algorithms.SimpleBestLetterAlgorithm;
import com.manuv.spritzalike.swing.SimplePanel;

public class SpritzAlike {

  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Spritz-Alike");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    BestLetterAlgorithm algorithm = new SimpleBestLetterAlgorithm();

    String[] wordsPerMinute = { "Words per minute (default=250)", "250", "300", "350", "400", "500", "600",
        "700", "800", "900", "1000", "1100", "1200" };
    final JComboBox wordsPerMinuteList = new JComboBox(wordsPerMinute);
    wordsPerMinuteList.setVisible(true);
    wordsPerMinuteList.setSelectedIndex(0);

    final SimplePanel simplePanel = new SimplePanel(algorithm);
    simplePanel.setWordsPerMinute(250);
    wordsPerMinuteList.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        if (wordsPerMinuteList.getSelectedIndex() > 0) {
          int wordsPerMinute = Integer.parseInt((String) wordsPerMinuteList.getSelectedItem());
          System.out.println("wordsPerMinute: " + wordsPerMinute);
          simplePanel.setWordsPerMinute(wordsPerMinute);
        }
      }

    });

    frame.add(simplePanel);
    frame.add(wordsPerMinuteList, BorderLayout.NORTH);
    frame.pack();
    frame.setVisible(true);
  }

}
