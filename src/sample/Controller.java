package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
public class Controller {

    @FXML
    Button start,back,exit,credit;
    @FXML
    Button bubblesort, bs, mergesort, bfs;

    public void startclicked() throws Exception {

        Stage f = (Stage) start.getScene().getWindow();
        Node root = FXMLLoader.load(getClass().getResource("s2.fxml"));
        f.setTitle("Hello World");
        Group g1 = new Group(root);
        f.setScene(new Scene(g1, 900, 800));
        f.show();
       /* String VOICE_NAME = "kevin16";
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICE_NAME);
        voice.allocate();
        voice.setRate(140);
        System.out.println("where");
        new Thread(()-> {
            voice.speak("You can always use HBox to create custom buttons, after window decoration is removed. Anyway providing your code can help ");
        }
        ).start();*/
    }
    public void exitClicked()
    {
        Stage stage=(Stage)exit.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    public void creditClicked()
    {
        Group group=new Group();
        try
        {
            javafx.scene.image.Image image=new Image("chalkboard.jpg");
            ImageView imageView=new ImageView(image);
            imageView.setFitWidth(1300);
            imageView.setFitHeight(800);
            group.getChildren().add(imageView);
        }
        catch (Exception e)
        {
            System.out.println("mor");
        }
        Text t[];
        t=new Text[4];
        for(int i=0;i<4;i++)
        {
            t[i]=new Text();
            t[i].setFont(Font.font("Segoe Script",20));
            t[i].setFill(Color.WHITE);
        }
        t[0].setText("IFTEKHAR HAKIM KAOWSAR");
        t[1].setText("ROLL: 1705045");
        t[2].setText("MONIRUL HAQ IMON");
        t[3].setText("ROLL: 1705054");
        t[0].setX(100);
        t[0].setY(300);
        t[1].setX(100);
        t[1].setY(330);
        t[2].setX(470);
        t[2].setY(300);
        t[3].setX(470);
        t[3].setY(330);
        Button back=new Button("BACK TO HOME");
        back.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        back.setLayoutX(30);
        back.setLayoutY(30);
        group.getChildren().add(back);
        group.getChildren().addAll(t);
        Stage stage;
        stage=(Stage)credit.getScene().getWindow();
        stage.setScene(new Scene(group,900,800));
        stage.show();
        back.setOnAction(e->
        {
            Main main=new Main();
            try {
                main.then(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
    }

public void option1()
{
    try {
        bubbleController x1 = new bubbleController();
        x1.bubblesortclicked(bubblesort);
    }
    catch (Exception e)
    {
        System.out.println("PROBLEM");
    }
}
    public void option2()
    {
        try {
            System.out.println("hoise ekhane");
            MergeController mergeController=new MergeController();
            mergeController.mergeclicked(mergesort);
        }
        catch (Exception e)
        {
            System.out.println("PROBLEM");
        }


    }
    public void option3()
    {
        try {
            BinsearchController binsearchController=new BinsearchController();
            binsearchController.bsclicked(bs);
        }
        catch (Exception e)
        {
            System.out.println("PROBLEM");
        }

    }
    public void option4()
    {
        try {
            bfsController bf=new bfsController();
            bf.bfsclicked(bs);
        }
        catch (Exception e)
        {
            System.out.println("PROBLEM");
            e.printStackTrace();
        }
    }
    public void backClicked() throws Exception {
        Main m=new Main();
        Stage stage=(Stage)back.getScene().getWindow();
        m.then(stage);
    }
}



