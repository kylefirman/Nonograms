package kylefNonograms.model;

public class BoardImpl implements Board {
  private Clues pClue;
  public int[][] boardArray;
  private int width;
  private int height;

  public BoardImpl(Clues clue) {
    if (clue == null) {
      throw new IllegalArgumentException();
    }
    pClue = clue;
    width = pClue.getWidth();
    height = pClue.getHeight();
    boardArray = new int[height][width];

  }

  @Override
  public boolean isShaded(int row, int col) {
    if (row < 0 || col < 0 || row >= height || col >= width) {
      throw new IndexOutOfBoundsException();
    }
    return (boardArray[row][col] == 1);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    if (row < 0 || col < 0 || row >= height || col >= width) {
      throw new IndexOutOfBoundsException();
    }
    return (boardArray[row][col] == 2);
  }

  @Override
  public boolean isSpace(int row, int col) {
    if (row < 0 || col < 0 || row >= height || col >= width) {
      throw new IndexOutOfBoundsException();
    }
    return (boardArray[row][col] == 0);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (row < 0 || col < 0 || row >= height || col >= width) {
      throw new IndexOutOfBoundsException();
    }
    if (this.isShaded(row, col)) {
      boardArray[row][col] = 0;         // already shaded, toggle back to space
    } else {
      boardArray[row][col] = 1;         // not shaded, toggle to shaded
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (row < 0 || col < 0 || row >= height || col >= width) {
      throw new IndexOutOfBoundsException();
    }
    if (this.isEliminated(row, col)) {
      boardArray[row][col] = 0;         // already eliminated, toggle back to space
    } else {
      boardArray[row][col] = 2;         // not eliminated, toggle to eliminated
    }
  }

  @Override
  public void clear() {
    boardArray = new int[boardArray.length][boardArray[0].length];
    for (int i = 0; i < boardArray.length; i++) {
      for (int j = 0; j < boardArray[0].length; j++) {
        boardArray[i][j] = 0;
      }
    }
    //Arrays.fill(boardArray, 0);
  }
}
