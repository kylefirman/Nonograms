package kylefNonograms.view;

import kylefNonograms.controller.ControllerImpl;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Buttons implements FXComponent {
  private ControllerImpl controller;

  public Buttons(ControllerImpl c) {
    this.controller = c;
  }

  @Override
  public Parent render() {
    HBox layout = new HBox();

    Button prevButton = new Button("Previous Puzzle");
    prevButton.setOnAction((ActionEvent event) -> {
        controller.prevPuzzle();
    });
    Button nextButton = new Button("Next Puzzle");
    nextButton.setOnAction((ActionEvent event) -> {
        controller.nextPuzzle();
    });
    Button randButton = new Button("Random Puzzle");
    randButton.setOnAction((ActionEvent event) -> {
        controller.randPuzzle();
    });
    Button resetButton = new Button("Reset Puzzle");
    resetButton.setOnAction((ActionEvent event) -> {
        controller.clearBoard();
    });

    layout.getChildren().add(prevButton);
    layout.getChildren().add(nextButton);
    layout.getChildren().add(randButton);
    layout.getChildren().add(resetButton);
    layout.setAlignment(Pos.TOP_CENTER);

    return layout;
  }
}
