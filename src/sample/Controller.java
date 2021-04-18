package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Camera;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.media.Media;
import java.io.File;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.text.Position;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    public ImageView play;
    @FXML
    AnchorPane leftPane;
    @FXML
    AnchorPane rightPane;
    @FXML
    AnchorPane middlePane;
    @FXML
    Button menuBtn;
    @FXML
    AnchorPane crosshiar;
    @FXML
    AnchorPane scene;
    @FXML
    Text timer;
    @FXML
    ImageView ship;
    @FXML
    ImageView wheel;
    @FXML ImageView exit;
    @FXML
    MediaView video;

    //--animácie a časovače--
    double i = 0;
    AnimationTimer animationTimer = new AnimationTimer() {
        private long lastUpdate = 0;
        @Override
        public void handle(long now) {
            if (now-lastUpdate>=999000000){
                doHandle();
                lastUpdate=now;
                System.out.println(middle);
            }
            middle.get(0).setZ(i);
            i+=10;
            System.out.println(middle.get(0).getZ());
        }
    };

    private void  doHandle(){
        newMeteor();
    }


    Random rn = new Random();
    Timer tmr = new Timer();
    int seconds = -1;
    int minute = 0;
    TimerTask tmrtask =  new TimerTask() {
        @Override
        public void run() {
            seconds++;
            timer.setText(minute+" : "+seconds);
            if (seconds>=59){
                minute++;
                seconds = -1;
            }
        }
    };

    //--metoerit--
    ArrayList<position> left = new ArrayList<>();
    ArrayList<position> right = new ArrayList<>();
    ArrayList<position> middle = new ArrayList<>();


    public void newMeteor(){
        int rnd = rn.nextInt(3);
        if (rnd == 1){
            Path path = new Path();
            Meteor meteor = new Meteor(rn.nextInt(900), rn.nextInt(401)+100,rn.nextInt(500),rn.nextInt(30)+10);
            middlePane.getChildren().add(meteor.getGrafika());
            middle.add(meteor);


        }
        if (rnd == 0){
            Meteor meteor = new Meteor(rn.nextInt(268), rn.nextInt(470)+80,rn.nextInt(500),rn.nextInt(30)+10);
            leftPane.getChildren().add(meteor.getGrafika());
            left.add(meteor);
        }
        if (rnd == 2){
            Meteor meteor = new Meteor(rn.nextInt(267), rn.nextInt(470)+80,rn.nextInt(500),rn.nextInt(30)+10);
            rightPane.getChildren().add(meteor.getGrafika());
            right.add(meteor);
        }
        crosshiar.toFront();
        ship.toFront();
        timer.toFront();
        wheel.toFront();

    }

    //--Šípky--
    public void up(){
        double pos=0;
        pos=crosshiar.getTranslateY();
        crosshiar.setTranslateY(pos-10);
    }
    public void down(){
        double pos=0;
        pos=crosshiar.getTranslateY();
        crosshiar.setTranslateY(pos+10);

    }
    public void left(){
        double pos=0;
        pos=crosshiar.getTranslateX();
        crosshiar.setTranslateX(pos-10);


    }
    public void right(){
        double pos=0;
        pos=crosshiar.getTranslateX();
        crosshiar.setTranslateX(pos+10);




    }
    public void shoot(){
        System.out.println(middle);
        middlePane.getChildren().clear();

    }

    //--hudba a spustenie hry--

    String path= "soundtrack.mp3";
    Media media= new Media(new File(path).toURI().toString());
    MediaPlayer mediaPlayer= new MediaPlayer(media);
    public void startGame(ActionEvent event) {
        mediaPlayer.play();
        menuBtn.setVisible(false);
        crosshiar.setVisible(true);
        timer.setVisible(true);
        tmr.scheduleAtFixedRate(tmrtask, 0, 1000);
        animationTimer.start();
    }
    //--otacanie lode--

    public int rotate =0;
    public void tright(){
        wheel.getTransforms().add(new Rotate(-45, 225, 184.5));
        rightPane.getChildren().clear();
    }
    public void  tleft(){
        wheel.getTransforms().add(new Rotate(45, 225, 184.5));
        leftPane.getChildren().clear();
        }



    //--budúce funkcie--

    public void launchGame(MouseEvent mouseEvent) {

    }

    public void exitGame(MouseEvent mouseEvent) {
        Platform.exit();
    }
}




