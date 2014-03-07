package com.manuv.spritzalike.test;
import org.junit.Assert;
import org.junit.Test;

import com.manuv.spritzalike.BestLetterAlgorithm;
import com.manuv.spritzalike.SimpleBestLetterAlgorithm;

public class SimpleBestLetterAlgorithmTest {

  private BestLetterAlgorithm algorithm = new SimpleBestLetterAlgorithm();

  @Test
  public void workTest(){
    Assert.assertEquals(-1, algorithm.getMostImportantCharPosition(" "));
    Assert.assertEquals(-1, algorithm.getMostImportantCharPosition("    "));
    Assert.assertEquals(0, algorithm.getMostImportantCharPosition("  a  "));
    Assert.assertEquals(1, algorithm.getMostImportantCharPosition("  a  b  "));
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullInpuTest(){
    Assert.assertEquals(-1, algorithm.getMostImportantCharPosition(null));
  }

  @Test
  public void spritzLikeTest() {
    Assert.assertEquals(1, algorithm.getMostImportantCharPosition("if"));
    Assert.assertEquals(1, algorithm.getMostImportantCharPosition("and"));
    Assert.assertEquals(1, algorithm.getMostImportantCharPosition("with"));
    Assert.assertEquals(2, algorithm.getMostImportantCharPosition("powered"));
    Assert.assertEquals(3, algorithm.getMostImportantCharPosition("developers"));
    Assert.assertEquals(3, algorithm.getMostImportantCharPosition("technologies"));
    Assert.assertEquals(2, algorithm.getMostImportantCharPosition("having"));
    Assert.assertEquals(1, algorithm.getMostImportantCharPosition("front"));
    Assert.assertEquals(2, algorithm.getMostImportantCharPosition("minute"));
    Assert.assertEquals(2, algorithm.getMostImportantCharPosition("welcome"));
  }

}
