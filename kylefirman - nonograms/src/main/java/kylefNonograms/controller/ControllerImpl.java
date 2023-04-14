package kylefNonograms.controller;

import kylefNonograms.model.Clues;
import kylefNonograms.model.Model;
import kylefNonograms.model.ModelImpl;

import java.util.Random;

public class ControllerImpl implements Controller {
  private Model pModel;

  public ControllerImpl(Model model) {
    if (model == null) {
      throw new IllegalArgumentException();
    }
    pModel = model;
  }

  @Override
  public Clues getClues() {
    return ((ModelImpl) pModel).thisPuzzle().getClues();
  }

  @Override
  public boolean isSolved() {
    return pModel.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return pModel.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return pModel.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    pModel.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    pModel.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    int index = pModel.getPuzzleIndex();
    if (index + 1 < pModel.getPuzzleCount()) {
      pModel.setPuzzleIndex(index + 1);
    }
  }

  @Override
  public void prevPuzzle() {
    int index = pModel.getPuzzleIndex();
    if (index - 1 >= 0) {
      pModel.setPuzzleIndex(index - 1);
    }
  }

  @Override
  public void randPuzzle() {
    int bound = getPuzzleCount();
    Random random = new Random();
    int randInt = random.nextInt(bound);
    pModel.setPuzzleIndex(randInt);
  }

  @Override
  public void clearBoard() {
    pModel.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return pModel.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return pModel.getPuzzleCount();
  }
}
