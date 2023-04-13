package kylefNonograms.model;

//CLEARED
public class CluesImpl implements Clues {
  private int width;
  private int height;
  private int[][] pRowClues;
  private int[][] pColClues;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    if (rowClues == null | colClues == null) {
      throw new IllegalArgumentException();
    }
    pRowClues = rowClues;
    pColClues = colClues;
    height = rowClues.length;
    width = colClues.length;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int[] getRowClues(int index) {
    return pRowClues[index];
  }

  public int[] getColClues(int index) {
    return pColClues[index];
  }

  public int getRowCluesLength() {
    return pRowClues[0].length;
  }

  public int getColCluesLength() {
    return pColClues[0].length;
  }
}
