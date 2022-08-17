package com.bowling;

import junit.framework.TestCase;

public class TestGame extends TestCase
{
  public TestGame(String name)
  {
    super(name);
  }

  private bowlingGame bg;

  public void setUp()
  {
    bg = new bowlingGame();
  }
//  A gutter game (20 times 0 pin) should score 0
  public void testGutterGame()
  {
    for (int i=0; i<9; i++)
    {
      bg.add(0);
      bg.add(0);
    }
    bg.add(0);
    bg.add(0); // 10th frame spare
    bg.add(0); // Strike in last position of array.
    assertEquals(0, bg.score());
   }

//  An all one game (20 times 1 pin) should score 20
  public void testallOneGame()
  {
    for (int i=0; i<9; i++)
    {
      bg.add(1);
      bg.add(1);
    }
    bg.add(1);
    bg.add(1); // 10th frame spare
    bg.add(1); // Strike in last position of array.
    assertEquals(20, bg.score());
   }
//  A spare followed by a 3 should score 16
  public void testSpareFollwedByThree()
  {
    bg.add(3);
    bg.add(7);
    bg.add(3);
    bg.add(0);
    assertEquals(13, bg.frameScore(1));
    assertEquals(16, bg.frameScore(2));
    assertEquals(16, bg.score());
  }
//  A strike followed by a 3 and a 4 should score 24
  public void testStrikeFollowedByThreeFour()
  {
    bg.add(10);
    bg.add(3);
    bg.add(4);
    assertEquals(17, bg.frameScore(1));
    assertEquals(24, bg.score());
  }

  public void testSimpleSpare()
  {
    bg.add(3);
    bg.add(7);
    bg.add(3);
    assertEquals(13, bg.frameScore(1));
  }

  public void testPerfectGame()
  {
    for (int i=0; i<12; i++)
    {
      bg.add(10);
    }
    assertEquals(300, bg.score());
  }

  public void testSampleGame()
  {
    bg.add(1);
    bg.add(4);
    bg.add(4);
    bg.add(5);
    bg.add(6);
    bg.add(4);
    bg.add(5);
    bg.add(5);
    bg.add(10);
    bg.add(0);
    bg.add(1);
    bg.add(7);
    bg.add(3);
    bg.add(6);
    bg.add(4);
    bg.add(10);
    bg.add(2);
    bg.add(8);
    bg.add(6);
    assertEquals(133, bg.score());
  }

}
