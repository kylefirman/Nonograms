package kylefNonograms.model;

import java.util.ArrayList;
import java.util.List;

// CLEARED
public class ModelImpl implements Model {
  private List<Clues> pClues;
  private ArrayList<Puzzle> puzzleList;
  private ArrayList<ModelObserver> modelObserversList;
  private int currentPuzzle;

  public ModelImpl(List<Clues> clues) {
    pClues = clues;
    puzzleList = new ArrayList<>();
    modelObserversList = new ArrayList<>();

    for (Clues clueList : clues) {
      Puzzle newPuzzle = new Puzzle(clueList);
      puzzleList.add(newPuzzle);
    }
    currentPuzzle = 0;
  }

  public int getPuzzleCount() {
    return puzzleList.size();
  }

  public int getPuzzleIndex() {
    return currentPuzzle;
  }

  public void setPuzzleIndex(int index) {
    if (index < 0 || index > getPuzzleCount()) {
      throw new IndexOutOfBoundsException();
    }
    currentPuzzle = index;
    for (ModelObserver mo : modelObserversList) {
      mo.update(this);
    }
  }

  public void addObserver(ModelObserver observer) {
    modelObserversList.add(observer);
  }

  public void removeObserver(ModelObserver observer) {
    modelObserversList.remove(observer);
  }

  public boolean isSolved() {
    int height = thisPuzzle().getClues().getHeight();
    int width = thisPuzzle().getClues().getWidth();

    // Scan rows one by one, comparing shaded # of cells on the board
    // with shaded # of cells in the clues, return false if any are different
    for (int i = 0; i < height; i++) {
      int shadedRowCells = 0;
      for (int j = 0; j < width; j++) {
        if (thisPuzzle().getBoard().isShaded(i, j)) {
          shadedRowCells++;
        }
      }
      int[] thisRowClues = thisPuzzle().getClues().getRowClues(i);
      int shadedClueCells = 0;
      for (int k = 0; k < thisRowClues.length; k++) {
        shadedClueCells += thisRowClues[k];
      }
      if (shadedRowCells != shadedClueCells) {
        return false;
      }
    }
    // Scan columns one by one, comparing shaded # of cells on the board
    // with shaded # of cells in the clues, return false if any are different
    for (int i = 0; i < width; i++) {
      int shadedColCells = 0;
      for (int j = 0; j < height; j++) {
        if (thisPuzzle().getBoard().isShaded(j, i)) {
          shadedColCells++;
        }
      }
      int[] thisColClues = thisPuzzle().getClues().getColClues(i);
      int shadedClueCells = 0;
      for (int k = 0; k < thisColClues.length; k++) {
        shadedClueCells += thisColClues[k];
      }
      if (shadedColCells != shadedClueCells) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean isShaded(int row, int col) {
    return thisPuzzle().getBoard().isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return thisPuzzle().getBoard().isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return thisPuzzle().getBoard().isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    thisPuzzle().getBoard().toggleCellShaded(row, col);
    for (ModelObserver mo : modelObserversList) {
      mo.update(this);
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    thisPuzzle().getBoard().toggleCellEliminated(row, col);
    for (ModelObserver mo : modelObserversList) {
      mo.update(this);
    }
  }

  @Override
  public void clear() {
    thisPuzzle().getBoard().clear();
    for (ModelObserver mo : modelObserversList) {
      mo.update(this);
    }
  }

  @Override
  public int getWidth() {
    return thisPuzzle().getClues().getWidth();
  }

  @Override
  public int getHeight() {
    return thisPuzzle().getClues().getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return thisPuzzle().getClues().getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return thisPuzzle().getClues().getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return thisPuzzle().getClues().getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return thisPuzzle().getClues().getColCluesLength();
  }

  public Puzzle thisPuzzle() {
    return this.puzzleList.get(currentPuzzle);
  }
}
