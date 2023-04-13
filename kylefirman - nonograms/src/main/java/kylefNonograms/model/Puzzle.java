package kylefNonograms.model;

// CLEARED
public class Puzzle {
  private Clues pClues;
  private BoardImpl board;

  public Puzzle(Clues clues) {
    if (clues == null) {
      throw new IllegalArgumentException();
    }
    pClues = clues;
    board = new BoardImpl(clues);
  }

  public Clues getClues() {
    return pClues;
  }

  public BoardImpl getBoard() {
    return board;
  }
}
