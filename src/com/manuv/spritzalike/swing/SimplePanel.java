package com.manuv.spritzalike.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JPanel;

import com.manuv.spritzalike.algorithms.BestLetterAlgorithm;
import com.manuv.spritzalike.utils.ResourceLoader;

@SuppressWarnings("serial")
public class SimplePanel extends JPanel {

  private String[] words;
  private BestLetterAlgorithm algorithm;
  private AtomicInteger counter = new AtomicInteger(0);
  private int wordsPerMinute = 600;

  public SimplePanel(BestLetterAlgorithm algorithm) {
    this.algorithm = algorithm;
    final SimplePanel thisPanel = this;
    try {
      words = ResourceLoader.getAllWordsFromFile("text-content");
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          counter.getAndIncrement();
          System.out.println("counter: " + counter.get());
          try {
            Thread.sleep((long)((60f/(float)wordsPerMinute)*1000));
            thisPanel.repaint();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    t.start();
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(640, 480);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    int fontSize = 20;
    int letterSpacing = 0;
    int speciaLetterHighlightOffset = 5;

    FontMetrics fm = g2d.getFontMetrics();
    int ypos = 50 + fm.getHeight();

    String word = words[counter.get() % words.length];
    g2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN, fontSize));
    int mostImportantCharPosition = algorithm.getMostImportantCharPosition(word);

    for (int i = 0; i < word.length(); i++) {
      int x = 150 + i * (fontSize + letterSpacing)
          - ( mostImportantCharPosition * (fontSize + letterSpacing));

      if (i == mostImportantCharPosition) {
        g2d.drawString("_", x, ypos-fontSize-speciaLetterHighlightOffset);
        g2d.drawString("_", x, ypos+speciaLetterHighlightOffset);
        g2d.setColor(Color.RED);
      } else {
        g2d.setColor(Color.BLACK);
      }

      g2d.drawString(Character.toString(word.charAt(i)), x, ypos);

    }
    g2d.dispose();
  }

}