package sample;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
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

public class bubbleController implements EventHandler<ActionEvent> {
    int p,i,even=1;int[] array;
    Text tt1[];
    @FXML
    Button next,a_submit;
    Stage f;
    @FXML
    TextField T,t0,t1,t2,t3,t4,t5,t6,t7;
    @FXML
    Text alert_for_size,a0,a1,a2,a3,a4,a5,a6,a7,alert_for_field;

    TextField t[];
    Text a[];
    public void bubblesortclicked(Button bubblesort) throws Exception {

        Node node = FXMLLoader.load(getClass().getResource("sbubble.fxml"));

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
        else if(Event.getSource()==a_submit)
        {
            System.out.println("ekhane");
            int u;
            for( u=0;u<i;u++)
            {
                if (t[u].getText() == null || t[u].getText().trim().isEmpty()||Integer.parseInt(t[u].getText())>=1000) {

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
                    showsort();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void showsort() throws java.lang.InterruptedException
    {
        int n = i;
        Circle[] c = new Circle[n];
        Text[] text = new Text[n];
        int[] a = array;
        int tempo=(n+1)/2;
        tempo=tempo*80;
        tempo=450-tempo-50;
        Stage stage = (Stage)a_submit.getScene().getWindow();
        for (int i = 0; i < n; i++) {
            c[i] = new Circle(tempo+80 * (i + 1), 300, 40);
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
            text[i].setY(304);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }

        System.out.println("on");
        javafx.scene.shape.Rectangle rectangle=new Rectangle();
        rectangle.setWidth(80);rectangle.setHeight(3);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLUE);
        rectangle.setY(370);
        rectangle.setVisible(false);

        Text whichpos=new Text();
        String whichpos1=new String("Position to be corrected: ");
        whichpos.setFont(javafx.scene.text.Font.font(20));
        whichpos.setX(300);
        whichpos.setY(500);

        Text swap_text=new Text(new String("Total swap till now: 0"));
        swap_text.setY(160);
        swap_text.setX(500);
        swap_text.setFont(Font.font(20));
        swap_text.setFill(Color.BLACK);

        Button back=new Button("Back To Home");
        back.setLayoutX(130);
        back.setLayoutY(30);
        Button bt1=new Button("PAUSE");
        bt1.setLayoutX(1170);
        bt1.setLayoutY(30);
        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setMaxWidth(300);
        scrollPane.setMaxHeight(800);
        scrollPane.setMinHeight(800);
        scrollPane.setMinWidth(300);
        scrollPane.setLayoutX(-300);
        scrollPane.setStyle("-fx-background-color: RED");
        scrollPane.setStyle("-fx-background:WHITE");

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
        Group root = new Group();
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
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "0.5X",
                        "0.7X",
                        "1.0X",
                        "1.2X",
                        "1.4X",
                        "1.5X"
                );
        ComboBox comboBox = new ComboBox(options);
        comboBox.setLayoutX(1170);
        comboBox.setLayoutY(90);
        Scene scene = new Scene(root, 1300, 800);

        try
        {
            javafx.scene.image.Image image=new Image("chalkboard.jpg");
            ImageView imageView=new ImageView(image);
            imageView.setFitWidth(1300);
            imageView.setFitHeight(800);
            root.getChildren().add(imageView);
        }
        catch (Exception e)
        {
            System.out.println("mor");
        }
        swap_text.setFont(Font.font("Segoe Script",20));
        whichpos.setFont(Font.font("Segoe Script",20));
        swap_text.setFill(Color.WHITE);
        whichpos.setFill(Color.WHITE);
        bt1.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        back.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        comboBox.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4;-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        comboBox.setMaxHeight(50);
        comboBox.setMaxWidth(120);
        comboBox.setMinHeight(50);
        comboBox.setMinWidth(120);
        comboBox.setPromptText("SPEED");
        Text line[]=new Text[6];
        line[0]=new Text("procedure Bubble Sort(Array,n) :");
        line[1]=new Text("for i=0 to n-1 :");
        line[2]=new Text("   for j=i+1 to n-1 ");
        line[3]=new Text("       if Array[i]>Array[j]");
        line[4]=new Text("           swap(Array[i],Array[j])");
        line[5]=new Text("end procedure");
        for(int i=0;i<6;i++)
        {
            line[i].setX(830);
            line[i].setY(200+30*i);
            line[i].setFill(Color.WHITE);
            line[i].setFont(Font.font("Segoe Script",20));
        }




        root.getChildren().addAll(line);
        root.getChildren().add(back);
        root.getChildren().add(bt1);
        root.getChildren().addAll(c);
        root.getChildren().add(swap_text);
        root.getChildren().addAll(text);
        root.getChildren().add(whichpos);
        root.getChildren().add(scrollPane);
        stage.setScene(scene);
        root.getChildren().add(comboBox);
        root.getChildren().add(imageView1[0]);
        stage.show();
        Thread a1;
        int finalTempo = tempo;

      //  thread.wait();
        new Thread(()-> {
            Thread thread;
            thread=Thread.currentThread();
            int[] er={0};
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
            back.setOnAction(e->
            {
                Main main=new Main();
                try {
                    main.then(stage);
                } catch (Exception e1) {
                    e1.printStackTrace();
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
            int swap=0;
            for (int i = 0; i < n; i++) {

                whichpos.setText(whichpos1 + String.valueOf(i));
                line[1].setFill(Color.BLUE);
                line[1].setFont(Font.font("Segoe Script",23));
                try {
                    Thread.sleep(speed[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                line[1].setFill(Color.WHITE);
                line[1].setFont(Font.font("Segoe Script",20));
                for (int j = i + 1; j < n; j++) {

                    c[j].setFill(Color.BLUE);
                    line[2].setFill(Color.BLUE);
                    line[2].setFont(Font.font("Segoe Script",23));
                    try {
                        Thread.sleep(speed[0]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    line[2].setFill(Color.WHITE);
                    line[2].setFont(Font.font("Segoe Script",20));
                    c[j].setFill(Color.RED);
                    if (a[i] > a[j]) {
                        line[3].setFill(Color.BLUE);
                        line[3].setFont(Font.font("Segoe Script",23));
                        try {
                            Thread.sleep(speed[0]);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        line[3].setFill(Color.WHITE);
                        line[3].setFont(Font.font("Segoe Script",20));

                        swap++;
                        int t;
                        t = a[i];
                        a[i] = a[j];
                        a[j] = t;
                        line[4].setFill(Color.BLUE);
                        line[4].setFont(Font.font("Segoe Script",23));
                        Circle tc = new Circle();
                        Text tt = new Text();
                        ParallelTransition p = new ParallelTransition();
                        SequentialTransition s = new SequentialTransition();
                        TranslateTransition t1, t2, t3, t4;
                        p = new ParallelTransition();
                        t1 = new TranslateTransition();
                        s = new SequentialTransition();
                        t1.setByY(80);
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(c[i]);
                        //s.getChildren().add(t1);
                        p.getChildren().add(t1);
                        t1 = new TranslateTransition();
                        t1.setByY(80);
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(text[i]);
                        p.getChildren().add(t1);
                        s.getChildren().add(p);

                        p = new ParallelTransition();
                        t1 = new TranslateTransition();
                        t1.setByY(-80);
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(c[j]);
                        p.getChildren().add(t1);
                        t1 = new TranslateTransition();
                        t1.setByY(-80);
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(text[j]);
                        p.getChildren().add(t1);
                        s.getChildren().add(p);
                        p = new ParallelTransition();
                        t1 = new TranslateTransition();
                        t1.setByX(80 * (j - i));
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(c[i]);
                        p.getChildren().add(t1);
                        t1 = new TranslateTransition();
                        t1.setByX(80 * (j - i));
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(text[i]);
                        p.getChildren().add(t1);
                        s.getChildren().add(p);

                        p = new ParallelTransition();
                        t1 = new TranslateTransition();
                        t1.setByX(-80 * (j - i));
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(c[j]);
                        p.getChildren().add(t1);
                        t1 = new TranslateTransition();
                        t1.setByX(-80 * (j - i));
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(text[j]);
                        p.getChildren().add(t1);
                        s.getChildren().add(p);


                        p = new ParallelTransition();
                        t1 = new TranslateTransition();
                        t1.setByY(-80);
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(c[i]);
                        p.getChildren().add(t1);
                        t1 = new TranslateTransition();
                        t1.setByY(-80);
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(text[i]);
                        p.getChildren().add(t1);
                        s.getChildren().add(p);

                        p = new ParallelTransition();
                        t1 = new TranslateTransition();
                        t1.setByY(80);
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(c[j]);
                        p.getChildren().add(t1);
                        t1 = new TranslateTransition();
                        t1.setByY(80);
                        t1.setDuration(Duration.millis(speed[0]));
                        t1.setCycleCount(1);
                        t1.setNode(text[j]);
                        p.getChildren().add(t1);
                        s.getChildren().add(p);

                        tc = c[i];
                        c[i] = c[j];
                        c[j] = tc;
                        tt = text[i];
                        text[i] = text[j];
                        text[j] = tt;
                        s.play();
                        try {
                            Thread.sleep(speed[0]*7);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        line[4].setFill(Color.WHITE);
                        line[4].setFont(Font.font("Segoe Script",20));
                        swap_text.setText(new String("Total swap till now: "+String.valueOf(swap)));
                        tt1[even].setText("Array["+i+"]"+" and Array["+j+"] are swapped");
                        even++;
                    }

                }
                rectangle.setVisible(false);
                tt1[even].setText("Element for position "+i+" is fixed");
                even++;
                c[i].setFill(Color.GREEN);

                try {
                    Thread.sleep(speed[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            whichpos.setText("YOUR ARRAY'S BEEN SORTED!");
            tt1[even].setText("Array sorted.");
            even++;
            line[5].setFill(Color.BLUE);
            line[5].setFont(Font.font("Segoe Script",23));
            bt1.setDisable(true);
            comboBox.setDisable(true);
            try {
                Thread.sleep(speed[0]);
            }
            catch(InterruptedException ex)
            {
                ;
            }

        }).start();


    }

}
