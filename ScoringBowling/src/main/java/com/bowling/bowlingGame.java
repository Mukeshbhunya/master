package com.bowling;

public class bowlingGame
{
	private int itsCurrentFrame = 0;
	private boolean firstThrowInFrame = true;
	private BowlingScore itsScorer = new BowlingScore();
	
  public int score()
  {
    return frameScore(itsCurrentFrame);
  }

  public void add(int pins)
  {
    itsScorer.addThrow(pins);
    adjustCurrentFrame(pins);
  }

  private void adjustCurrentFrame(int pins)
  {
    if (firstThrowInFrame == true)
    {
      if (adjustFrameForStrike(pins) == false)
        firstThrowInFrame = false;
    }
    else
    {
      firstThrowInFrame=true;
      advanceFrame();
    }
  }

  private boolean adjustFrameForStrike(int pins)
  {
    if (pins == 10)
    {
      advanceFrame();
      return true;
    }
    return false;
  }  

  private void advanceFrame()
  {
    itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);
  }

  public int frameScore(int theFrame)
  {
    return itsScorer.frameScore(theFrame);
  }
}