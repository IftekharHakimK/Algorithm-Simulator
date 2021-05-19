package sample;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;

public class Main extends Application {

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        MediaPlayer player = new MediaPlayer( new Media(getClass().getResource("video.mp4").toExternalForm()));
        MediaView mediaView = new MediaView(player);
        player.setMute(true);
        player.play();
        mediaView.setFitWidth(930);
        mediaView.setFitHeight(830);
        mediaView.setPreserveRatio(false);
        window = primaryStage;
        player.setOnEndOfMedia(()->
        {
            try {
                then(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mediaView.setVisible(false);
        });
        mediaView.setOnMouseClicked(event -> {
            try {
                then(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            player.stop();
            mediaView.setVisible(false);
        });

       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Algorithm Simulator");
        primaryStage.setResizable(false);
        Group node=new Group();
       node.getChildren().add(mediaView);
        primaryStage.setScene(new Scene(node, 900, 800));
        primaryStage.show();
    }
    public void then(Stage window) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group node=new Group(root);
        window.setTitle("Algorithm Simulator");
        window.setScene(new Scene(node, 900, 700));
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}