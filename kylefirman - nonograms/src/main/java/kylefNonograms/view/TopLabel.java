package kylefNonograms.view;

import kylefNonograms.controller.ControllerImpl;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class TopLabel implements FXComponent {
  private ControllerImpl pControllerImpl;

  public TopLabel(ControllerImpl ci) {
    pControllerImpl = ci;
  }

  @Override
  public Parent render() {
    GridPane topLabels = new GridPane();
    topLabels.setHgap(28);
    topLabels.setVgap(5);
    //topLabels.setPadding(new Insets(10, 10, 10, 10));

    for (int i = 0; i < pControllerImpl.getClues().getColCluesLength(); i++) {
      for (int j = 0; j < pControllerImpl.getClues().getWidth(); j++) {
        int clue = pControllerImpl.getClues().getColClues(j)[i];
        Label thisLabel = new Label();
        thisLabel.setText("" + clue);
        StackPane stack = new StackPane();
        stack.getChildren().add(thisLabel);

        topLabels.add(stack, j, i, 1, 1);
      }
    }
    topLabels.setAlignment(Pos.TOP_CENTER);
    return topLabels;
  }
}
