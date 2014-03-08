package com.manuv.spritzalike;

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

    frame.add(new SimplePanel(algorithm));
    frame.pack();
    frame.setVisible(true);
  }


}
