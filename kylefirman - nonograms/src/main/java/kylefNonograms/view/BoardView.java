package kylefNonograms.view;

import kylefNonograms.controller.ControllerImpl;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardView implements FXComponent {
  private ControllerImpl pControllerImpl;

  public BoardView(ControllerImpl ci) {
    pControllerImpl = ci;
  }

  @Override
  public Parent render() {
    // Set up game board
    GridPane board = new GridPane();
    board.setPrefSize(500, 500);
    board.setHgap(5);
    board.setVgap(5);
    board.setPadding(new Insets(0,0,0,-100));


    // Fill board with tiles
    for (int i = 0; i < pControllerImpl.getClues().getHeight(); i++) {
      for (int j = 0; j < pControllerImpl.getClues().getWidth(); j++) {
        int r = i;
        int c = j;
        Rectangle rec = new Rectangle(30, 30);
        rec.setFill(Color.LIGHTGREY);
        rec.setOnMouseClicked(event -> mouseClick(r, c, rec, event));

        StackPane stack = new StackPane();
        stack.getChildren().add(rec);

        if (pControllerImpl.isEliminated(r, c)) {
          rec.setFill(Color.RED);
        } else if (pControllerImpl.isShaded(r, c)) {
          rec.setFill(Color.BLACK);
        }

        rec.setOnMouseClicked(event -> mouseClick(r, c, rec, event));
        board.add(stack, j, i, 1, 1);
      }
    }

    if (pControllerImpl.isSolved()) {
      Alert solvedAlert = new Alert(Alert.AlertType.CONFIRMATION);
      solvedAlert.setTitle("Complete!");
      solvedAlert.setContentText("Puzzle Complete");
      solvedAlert.show();
    }
    board.setAlignment(Pos.CENTER);
    return board;
  }

  public void mouseClick(int row, int col, Rectangle rec, MouseEvent me) {
    if (me.getButton() == MouseButton.PRIMARY) {
      pControllerImpl.toggleShaded(row, col);
    } else if (me.getButton() == MouseButton.SECONDARY) {
      pControllerImpl.toggleEliminated(row, col);
    }
  }
}
