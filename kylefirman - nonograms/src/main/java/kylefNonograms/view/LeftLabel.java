package kylefNonograms.view;

import kylefNonograms.controller.ControllerImpl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class LeftLabel implements FXComponent {
  private ControllerImpl pControllerImpl;

  public LeftLabel(ControllerImpl ci) {
    pControllerImpl = ci;
  }

  @Override
  public Parent render() {
    GridPane leftLabels = new GridPane();
    leftLabels.setHgap(5);
    leftLabels.setVgap(18);
    leftLabels.setPadding(new Insets(0,0,0,100));

    for (int i = 0; i < pControllerImpl.getClues().getHeight(); i++) {
      for (int j = 0; j < pControllerImpl.getClues().getRowCluesLength(); j++) {
        int clue = pControllerImpl.getClues().getRowClues(i)[j];
        Label thisLabel = new Label();
        thisLabel.setText("" + clue);
        StackPane stack = new StackPane();
        stack.getChildren().add(thisLabel);

        leftLabels.add(stack, j, i, 1, 1);
      }
    }
    leftLabels.setAlignment(Pos.CENTER_RIGHT);
    return leftLabels;
  }
}
