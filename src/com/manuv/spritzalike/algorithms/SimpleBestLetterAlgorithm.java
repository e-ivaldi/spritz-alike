package com.manuv.spritzalike.algorithms;

public class SimpleBestLetterAlgorithm implements BestLetterAlgorithm {

  @Override
  public int getMostImportantCharPosition(String word) {

    if (word == null) {
      throw new IllegalArgumentException("input can't be null");
    } else {
      word = word.replaceAll(" ", "");
      int length = word.length();
      int mostImportantCharPosition;

      if (length == 0) {
        mostImportantCharPosition = -1;
      } else if (length == 1) {
        mostImportantCharPosition = 0;
      } else {
        mostImportantCharPosition = 1 + (calculateLetterPositionBasedOnCharWeight(word.substring(1, length), length)) / 4;
      }

      System.out.println(mostImportantCharPosition + "\t" + word);
      return mostImportantCharPosition;
    }
  }

  private int calculateLetterPositionBasedOnCharWeight(String word, int length) {
    float weight = 0;
    for (Character c : word.toCharArray()) {
      if (isVowel(c)) {
        weight += 1.2f;
      } else {
        weight += 0.8f;
      }
    }
    return (int) Math.floor(weight);
  }

  private boolean isVowel(Character c) {
    return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
  }

}
