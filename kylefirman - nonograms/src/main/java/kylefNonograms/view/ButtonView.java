package kylefNonograms.view;

import kylefNonograms.controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;

public class ButtonView implements FXComponent {
  private Controller pController;

  public ButtonView(Controller c) {
    pController = c;
  }

  @Override
  public Parent render() {
    GridPane buttons = new GridPane();

    Button nextButton = new Button("Next Puzzle");
    buttons.setHgap(20);
    nextButton.setOnMouseClicked(
        MouseEvent -> {
          if (MouseEvent.getButton() == MouseButton.PRIMARY) {
            pController.nextPuzzle();
          }
        });

    Button prevButton = new Button("Previous Puzzle");
    buttons.setHgap(20);
    nextButton.setOnMouseClicked(
            MouseEvent -> {
              if (MouseEvent.getButton() == MouseButton.PRIMARY) {
                pController.prevPuzzle();
              }
            });

    Button randomButton = new Button("Random Puzzle");
    buttons.setHgap(20);
    nextButton.setOnMouseClicked(
            MouseEvent -> {
              if (MouseEvent.getButton() == MouseButton.PRIMARY) {
                pController.randPuzzle();
              }
            });

    Button resetButton = new Button("Reset Puzzle");
    buttons.setHgap(20);
    nextButton.setOnMouseClicked(
            MouseEvent -> {
              if (MouseEvent.getButton() == MouseButton.PRIMARY) {
                pController.clearBoard();
              }
            });

    buttons.add(prevButton, 0, 1, 1, 2);
    buttons.add(nextButton, 1, 1, 1, 2);
    buttons.add(randomButton, 1, 1, 1, 2);
    buttons.add(resetButton, 1, 1, 1, 2);
    buttons.setAlignment(Pos.BOTTOM_CENTER);

    return buttons;
  }
}
