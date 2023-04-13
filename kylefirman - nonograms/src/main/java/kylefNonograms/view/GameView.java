package kylefNonograms.view;

import kylefNonograms.controller.ControllerImpl;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class GameView implements FXComponent {
  private ControllerImpl pControllerImpl;

  public GameView(ControllerImpl ci) {
    pControllerImpl = ci;
  }

  @Override
  public Parent render() {
    // Set up game board
    BoardView board = new BoardView(pControllerImpl);
    LeftLabel left = new LeftLabel(pControllerImpl);
    TopLabel top = new TopLabel(pControllerImpl);
    Buttons buttons = new Buttons(pControllerImpl);

    BorderPane game = new BorderPane();
    game.setCenter(board.render());
    game.setLeft(left.render());
    game.setTop(top.render());
    game.setBottom(buttons.render());

    return game;
  }
}
