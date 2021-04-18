
package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage Stage) throws Exception{
        FXMLLoader game = new FXMLLoader(getClass().getResource("sample1.fxml"));
        Parent root2 = game.load();
        Scene scene2 = new Scene(root2);
        Controller controller1 = game.getController();
        Camera camera = new PerspectiveCamera();
        


        FXMLLoader menu = new FXMLLoader(getClass().getResource("sample0.fxml"));
        Parent root = menu.load();
        Scene scene = new Scene(root);
        Controller controller = menu.getController();

        scene2.setCamera(camera);
        controller.play.setOnMouseClicked(event -> Stage.setScene(scene2));
        scene2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case UP:
                        controller1.up();
                        break;
                    case DOWN:
                        controller1.down();
                        break;
                    case LEFT:
                        controller1.left();
                        break;
                    case RIGHT:
                        controller1.right();
                        break;
                    case SPACE:
                        controller1.shoot();
                        break;
                    case Q:
                        controller1.tright();
                        break;
                    case E:
                        controller1.tleft();
                        break;
                }
            }
        });
        Stage.setScene(scene);
        Stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}

