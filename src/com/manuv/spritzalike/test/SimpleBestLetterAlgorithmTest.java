package com.manuv.spritzalike.test;
import org.junit.Assert;
import org.junit.Test;

import com.manuv.spritzalike.BestLetterAlgorithm;
import com.manuv.spritzalike.SimpleBestLetterAlgorithm;

public class SimpleBestLetterAlgorithmTest {

  private BestLetterAlgorithm algorithm = new SimpleBestLetterAlgorithm();

  @Test
  public void workTest(){
    Assert.assertEquals("", algorithm.getMostImportantChar(" "));
    Assert.assertEquals("", algorithm.getMostImportantChar("    "));
    Assert.assertEquals("a", algorithm.getMostImportantChar("  a  "));
    Assert.assertEquals("b", algorithm.getMostImportantChar("  a  b  "));
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullInpuTest(){
    Assert.assertEquals("", algorithm.getMostImportantChar(null));
  }

  @Test
  public void spritzLikeTest() {
    Assert.assertEquals("f", algorithm.getMostImportantChar("if"));
    Assert.assertEquals("n", algorithm.getMostImportantChar("and"));
    Assert.assertEquals("i", algorithm.getMostImportantChar("with"));
    Assert.assertEquals("w", algorithm.getMostImportantChar("powered"));
    Assert.assertEquals("e", algorithm.getMostImportantChar("developers"));
    Assert.assertEquals("h", algorithm.getMostImportantChar("technologies"));
    Assert.assertEquals("v", algorithm.getMostImportantChar("having"));
    Assert.assertEquals("r", algorithm.getMostImportantChar("front"));
    Assert.assertEquals("n", algorithm.getMostImportantChar("minute"));
    Assert.assertEquals("l", algorithm.getMostImportantChar("welcome"));
  }

}
