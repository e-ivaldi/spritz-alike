package com.manuv.spritzalike;

public class SimpleBestLetterAlgorithm implements BestLetterAlgorithm {

  @Override
  public String getMostImportantChar(String word) {

    if (word == null) {
      throw new IllegalArgumentException("input can't be null");
    } else {
      word = word.replaceAll(" ", "");
      int length = word.length();
      String importantLetter;

      if (length == 0) {
        importantLetter = "";
      } else if (length == 1) {
        importantLetter = word;
      } else {
        int start = 1 + (calculateLetterBasedOnCharWeight(word.substring(1, length), length)) / 4;
        int end = start + 1;
        importantLetter = word.substring(start, end);
      }
      System.out.println(importantLetter + "\t" + word);
      return importantLetter;
    }
  }

  private int calculateLetterBasedOnCharWeight(String word, int length) {
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

  public boolean isVowel(Character c) {
    return "aeiou".indexOf(Character.toLowerCase(c)) != -1;
  }

}
