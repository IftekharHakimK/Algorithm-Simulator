package sample;

import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.Duration;
import sun.security.krb5.SCDynamicStoreConfig;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Vector;


public class BinsearchController implements EventHandler<ActionEvent> {
    int p,i;int[] array;int search;
    @FXML
    Button next,a_submit;
    Stage f;
    @FXML
    TextField T,t0,t1,t2,t3,t4,t5,t6,t7,ts;
    @FXML
    Text alert_for_size,a0,a1,a2,a3,a4,a5,a6,a7,as,alert_for_field;

    TextField t[];
    Text a[];
    public void bsclicked(Button bubblesort) throws Exception {

        Node node = FXMLLoader.load(getClass().getResource("sbin.fxml"));
        Group g1=new Group();
        Stage f=(Stage)bubblesort.getScene().getWindow();

        g1.getChildren().add(node);
        f.setScene(new Scene(g1,900,800));
        f.show();
    }

    @Override
    public void handle(ActionEvent Event) {
        if (Event.getSource() == next) {
            t=new TextField[9];
            a=new Text[9];
            t[0]=t0;
            t[1]=t1;
            t[2]=t2;
            t[3]=t3;
            t[4]=t4;
            t[5]=t5;
            t[6]=t6;
            t[7]=t7;
            a[0]=a0;
            a[1]=a1;
            a[2]=a2;
            a[3]=a3;
            a[4]=a4;
            a[5]=a5;
            a[6]=a6;
            a[7]=a7;

            String s = T.getText();
            i = Integer.parseInt(s);
            System.out.println(i);
            if (i >= 1 && i <= 8) {
                array = new int[i];
                p = 0;
                ts.setVisible(true);
                as.setVisible(true);
                for(int u=0;u<i;u++)
                {
                    t[u].setVisible(true);
                    a[u].setVisible(true);
                }
                a_submit.setVisible(true);
                alert_for_size.setVisible(false);

                T.setLayoutY(T.getLayoutY()-8);
                T.setStyle("-fx-background-color:transparent;-fx-text-fill: white;-fx-font-size:20px");
                T.setEditable(false);
                next.setVisible(false);
            }
            else
            {
                alert_for_size.setVisible(true);
            }
        }
        else if (Event.getSource() ==a_submit) {
            System.out.println("ekhane");
            int u;
            for( u=0;u<i;u++)
            {
                if (t[u].getText() == null || t[u].getText().trim().isEmpty()||ts.getText()==null||ts.getText().trim().isEmpty()||Integer.parseInt(t[u].getText())>=1000) {

                    alert_for_field.setVisible(true);
                    break;
                }
                else
                {
                    array[u]=Integer.parseInt(t[u].getText());
                }
            }
            System.out.println(u);

            if(u==i)
            {
                try {
                    search=Integer.parseInt(ts.getText());
                    showbinsearch();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void showbinsearch() throws java.lang.InterruptedException
    {
        Group group=new Group();
        Scene scene = new Scene(group, 1300, 800);
        try
        {
            javafx.scene.image.Image image=new Image("file:chalkboard.jpg");

            ImageView imageView=new ImageView(image);
            imageView.setFitWidth(1300);
            imageView.setFitHeight(800);
            group.getChildren().add(imageView);
        }
        catch (Exception e)
        {
            System.out.println("mor");
        }
        int n=i;
        int[] a=array;
        Arrays.sort(a);
        Circle[] c=new Circle[n];
        Text[] text=new Text[n];
        int tempo=(n+1)/2;
        tempo=tempo*80;
        tempo=450-tempo-50;
        Stage stage = (Stage)a_submit.getScene().getWindow();
        for (int i = 0; i < n; i++) {
            c[i] = new Circle(tempo+80 * (i + 1), 400, 40);
            c[i].setFill(Color.RED);
            c[i].setSmooth(true);
            text[i] = new Text();
            text[i].setText(String.valueOf(a[i]));
            if(a[i]<10)
                text[i].setX(tempo+80 * (i + 1) - 2);
            else if(a[i]<100)
                text[i].setX(tempo+80 * (i + 1) - 2-5);
            else
                text[i].setX(tempo+80 * (i + 1) - 2-10);
            text[i].setY(404);
        }
        group.getChildren().addAll(c);
        group.getChildren().addAll(text);
        Button bt1=new Button("PAUSE");
        bt1.setLayoutX(1170);
        bt1.setLayoutY(30);
        bt1.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "0.5X",
                        "0.7X",
                        "1.0X",
                        "1.2X",
                        "1.4X",
                        "1.5X"
                );
        Text line[]=new Text[11];
        line[0]=new Text("procedure Binary Search(Array,"+search+")");
        line[1]=new Text("low=0 , high=n-1");
        line[2]=new Text("while low<=high :");
        line[3]=new Text("  mid=(low+high)/2");
        line[4]=new Text("  if Array[mid]=="+search+" :");
        line[5]=new Text("      return True");
        line[6]=new Text("  else if Array[mid]<"+search+" :");
        line[7]=new Text("      low=mid+1");
        line[8]=new Text("  else");
        line[9]=new Text("      high=mid-1");
        line[10]=new Text("return False");
        for(int i=0;i<11;i++)
        {
            line[i].setX(880);
            line[i].setY(200+30*i);
            line[i].setFill(Color.WHITE);
            line[i].setFont(Font.font("Segoe Script",20));
        }
        group.getChildren().addAll(line);
        ComboBox comboBox = new ComboBox(options);
        comboBox.setLayoutX(1170);
        comboBox.setLayoutY(90);
        comboBox.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        comboBox.setMaxHeight(50);
        comboBox.setMaxWidth(120);
        comboBox.setMinHeight(50);
        comboBox.setMinWidth(120);
        comboBox.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4;-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        comboBox.setPromptText("SPEED");
        group.getChildren().add(comboBox);
        group.getChildren().add(bt1);
        Text text1=new Text(382,210,"SEARCHING "+search);
        text1.setUnderline(true);
        text1.setStyle("-fx-font-weight: bold");
        Text text2=new Text();
        text1.setFill(Color.WHITE);
        text1.setFont(Font.font("Segoe Script",20));
        text2.setFill(Color.WHITE);
        text2.setFont(Font.font("Segoe Script",20));
        text2.setX(400);
        text2.setY(600);
        arrows alow,ahigh,amid;
        Button back=new Button("Back To Home");
        back.setLayoutX(130);
        back.setLayoutY(30);
        back.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");

        group.getChildren().add(back);
        alow=new arrows(c[0].getCenterX(),275,c[0].getCenterX(),325,15);
        ahigh=new arrows(c[n-1].getCenterX(),505,c[n-1].getCenterX(),455,15);
        alow.setFill(Color.WHITE);
        ahigh.setFill(Color.WHITE);
        group.getChildren().addAll(text1,alow,ahigh);
        final int[] low = {0};
        final int[] high = {n - 1};
        Text ltext=new Text(c[0].getCenterX()-15,255,"LOW");
        ltext.setFill(Color.WHITE);
        ltext.setFont(Font.font("Segoe Script",20));
        Text htext=new Text(c[n-1].getCenterX()-15,545,"HIGH");
        htext.setFill(Color.WHITE);
        htext.setFont(Font.font("Segoe Script",20));
        group.getChildren().addAll(ltext,htext);

        javafx.scene.control.ScrollPane scrollPane=new ScrollPane();
        scrollPane.setMaxWidth(300);
        scrollPane.setMaxHeight(800);
        scrollPane.setMinHeight(800);
        scrollPane.setMinWidth(300);
        scrollPane.setLayoutX(-300);
        scrollPane.setStyle("-fx-background-color: RED");
        scrollPane.setStyle("-fx-background:WHITE");
        Text tt1[];

        VBox vBox=new VBox();
        tt1=new Text[400];
        for(int i=0;i<400;i++)
        {
            tt1[i]=new Text();
            tt1[i].setFont(Font.font("Segoe Script",20));
        }
        tt1[0].setText("Event Log:                                    ");
        vBox.getChildren().addAll(tt1);
        vBox.setStyle("-fx-background-color:#576987 ;-fx-background:#576987");
        scrollPane.setContent(vBox);
        scrollPane.setPannable(true);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(40));
        ImageView imageView1[]=new ImageView[1];
        try
        {
            javafx.scene.image.Image image=new Image("ham.jpg");
            imageView1[0]=new ImageView(image);
            imageView1[0].setFitWidth(100);
            imageView1[0].setFitHeight(100);
            imageView1[0].setX(20);
            imageView1[0].setY(10);

        }

        catch (Exception e)
        {
            System.out.println("mor");
        }
        group.getChildren().add(imageView1[0]);
        group.getChildren().add(scrollPane);
        new Thread(()->
        {
            line[1].setFill(Color.BLUE);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            line[1].setFill(Color.WHITE);
            Thread thread;
            thread=Thread.currentThread();
            int paneMove[]={0};
            imageView1[0].setOnMouseClicked(e->
            {
                ParallelTransition parallelTransition=new ParallelTransition();
                TranslateTransition translateTransition[]=new TranslateTransition[3];
                for(int i=0;i<3;i++)
                {
                    translateTransition[i]=new TranslateTransition();
                }
                translateTransition[0].setNode(scrollPane);
                translateTransition[1].setNode(back);
                translateTransition[2].setNode(imageView1[0]);
                if(paneMove[0]%2==0)
                {
                    System.out.println("oya");;
                    translateTransition[0].setByX(300);
                    translateTransition[1].setByX(300);
                    translateTransition[2].setByX(300);
                }
                else {
                    translateTransition[0].setByX(-300);
                    translateTransition[1].setByX(-300);
                    translateTransition[2].setByX(-300);
                    System.out.println("eta");
                }
                paneMove[0]++;
                translateTransition[0].setDuration(Duration.seconds(0.5));
                translateTransition[1].setDuration(Duration.seconds(0.5));
                translateTransition[2].setDuration(Duration.seconds(0.5));
                parallelTransition.getChildren().addAll(translateTransition);
                parallelTransition.play();
            });
            int[] er={0};
            back.setOnAction(e->
            {
                Main main=new Main();
                try {
                    main.then(stage);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
            bt1.setOnAction(e->
            {
                er[0]++;
                if (er[0] % 2 == 1) {
                    bt1.setText("RESUME");
                    thread.suspend();

                } else
                {
                    bt1.setText("Pause");
                    thread.resume();

                }
            });
            int[] speed={1000};
            comboBox.setOnAction(e->
            {
                String q=(String)comboBox.getValue();
                q=q.substring(0,3);
                System.out.println(q);
                double d=Double.parseDouble(q);
                System.out.println(d);
                speed[0]=(int)(1000/d);
                System.out.println(speed[0]);
            });
            int even=1;
            while (low[0] <= high[0])
            {
                line[2].setFill(Color.BLUE);
                try {
                    Thread.sleep(speed[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                line[2].setFill(Color.WHITE);
                int mid=(low[0] + high[0])/2;
                tt1[even].setText("MID is found at "+mid+" with LOW="+low[0]+" and HIGH= "+high[0]);
                even++;
                text2.setText("MID IS "+mid);
                text2.setX(407);
                line[3].setFill(Color.BLUE);
                c[mid].setFill(Color.BLUE);
                try {
                    Thread.sleep(speed[0]*2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c[mid].setFill(Color.RED);
                line[3].setFill(Color.WHITE);

                ScaleTransition scaleTransition;
                if(a[mid]==search)
                {
                    line[4].setFill(Color.BLUE);
                    try {
                        Thread.sleep(speed[0]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    line[4].setFill(Color.WHITE);
                    line[5].setFill(Color.BLUE);

                    c[mid].setFill(Color.GREEN);
                    text1.setText(search+" IS FOUND IN THE ARRAY");
                    text1.setX(350);
                    text1.setFill(Color.GREEN);
                    tt1[even].setText(search+" is found at Array["+mid+"]");
                    even++;
                    break;
                }
                else if(a[mid]<search)
                {
                    line[6].setFill(Color.BLUE);
                    try {
                        Thread.sleep(speed[0]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    line[6].setFill(Color.WHITE);
                    text2.setText("Array["+mid+"]<"+search);
                    text2.setX(398);
                    line[7].setFill(Color.BLUE);
                    TranslateTransition tt;
                    ParallelTransition parallelTransition=new ParallelTransition();
                    tt=new TranslateTransition();
                    tt.setNode(alow);
                    tt.setDuration(Duration.millis(speed[0]*2));
                    double r=c[mid].getCenterX()-c[low[0]].getCenterX()+80;
                    tt.setByX(r);
                    parallelTransition.getChildren().add(tt);
                    //TranslateTransition tt;
                    tt=new TranslateTransition();
                    tt.setNode(ltext);
                    tt.setDuration(Duration.millis(speed[0]*2));
                    tt.setByX(r);
                    parallelTransition.getChildren().add(tt);
                    low[0]=mid+1;
                    parallelTransition.play();
                    try
                    {
                        Thread.sleep(speed[0]*5);
                    }catch (InterruptedException ie)
                    {
                        ;
                    }
                    tt1[even].setText("LOW moved to position="+low[0]);
                    even++;
                    line[7].setFill(Color.WHITE);
                }

                else
                {
                    line[8].setFill(Color.BLUE);
                    try {
                        Thread.sleep(speed[0]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    line[8].setFill(Color.WHITE);
                    line[9].setFill(Color.BLUE);
                    text2.setText("Array["+mid+"]>"+search);
                    text2.setX(398);
                    TranslateTransition tt;
                    ParallelTransition parallelTransition=new ParallelTransition();
                    tt=new TranslateTransition();
                    tt.setNode(ahigh);
                    tt.setDuration(Duration.millis(speed[0]*2));
                    double r=c[mid].getCenterX()-c[high[0]].getCenterX();
                    r-=80;
                    tt.setByX(r);
                    parallelTransition.getChildren().add(tt);
                    //TranslateTransition tt;
                    tt=new TranslateTransition();
                    tt.setNode(htext);
                    tt.setDuration(Duration.millis(speed[0]*2));
                    tt.setByX(r);
                    parallelTransition.getChildren().add(tt);
                    high[0] =mid-1;
                    parallelTransition.play();
                    try
                    {
                        Thread.sleep(speed[0]*5);
                    }catch (InterruptedException ie)
                    {
                        ;
                    }
                    tt1[even].setText("HIGH moved to position="+high[0]);
                    even++;
                    line[9].setFill(Color.WHITE);
                }

            }
            if(low[0]>high[0])
            {
                line[2].setFill(Color.RED);
                line[10].setFill(Color.BLUE);
                text1.setText(search+" IS NOT FOUND");
                text1.setX(373);
                text1.setFill(Color.RED);
                tt1[even].setText(search+" is not found");
                even++;
            }
            bt1.setDisable(true);
            comboBox.setDisable(true);
        }).start();
        stage.setScene(scene);
        stage.show();
    }

}
