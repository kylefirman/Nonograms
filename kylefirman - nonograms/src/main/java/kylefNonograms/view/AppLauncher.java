package kylefNonograms.view;

import kylefNonograms.PuzzleLibrary;
import kylefNonograms.controller.ControllerImpl;
import kylefNonograms.model.Clues;
import kylefNonograms.model.Model;
import kylefNonograms.model.ModelImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class AppLauncher extends Application {

//CLEARED
  @Override
  public void start(Stage stage) {
      int width = 1080;
      int height = 720;
      stage.setTitle("Nonograms");
      java.util.List<Clues> clues = PuzzleLibrary.create();
      ModelImpl model = new ModelImpl(clues);
      ControllerImpl controller = new ControllerImpl(model);
      GameView view = new GameView(controller);
      Scene scene = new Scene(view.render(), width, height);
      stage.setScene(scene);

      model.addObserver(
              (Model m) -> {
                  scene.setRoot(view.render());
                  stage.sizeToScene();
              });

      stage.show();
  }
}
