package sample;

import javafx.animation.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import sun.plugin2.gluegen.runtime.CPU;

import java.util.Queue;
import java.awt.*;
import java.util.LinkedList;
import java.util.Vector;

public class bfsController {
    Line[] l;Circle[] c;Text[] texts;int nos[];
    Vector[] vector;
    Text[] dis,tt1;
    int even=1;
    Button bt;
    Text event,process,queue;
    Button back,bt1;
    ComboBox comboBox;
    Text line[];
    public void bfsclicked(Button bt)
    {
        event=new Text("Already visited");
        event.setX(400);
        event.setY(670);
        event.setFill(Color.WHITE);
        event.setFont(Font.font(20));
        event.setVisible(false);

        process=new Text("Current Processing Node: ");
        process.setX(370);
        process.setY(700);
        process.setFill(Color.WHITE);
        process.setFont(Font.font("Segoe Script"));
        process.setFont(Font.font(20));
        process.setVisible(false);

        queue=new Text("Current Processing Node: ");
        queue.setX(30);
        queue.setY(770);
        queue.setFont(Font.font("Segoe Script",26));
        queue.setFill(Color.WHITE);
        queue.setVisible(false);
        Stage f=(Stage)bt.getScene().getWindow();
        Pane root = new Pane();
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
        Rectangle rectangle=new Rectangle(50,130,650,0);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.WHITE);
        root.getChildren().add(rectangle);
        new Thread(()->
        {
            new AnimationTimer()
            {
                double p=0;
                @Override
                public void handle(long now)
                {
                    p+=4;
                    rectangle.setHeight(p);
                    if(p==500)
                    {
                        stop();
                    }
                }
            }.start();
        }).start();
        vector=new Vector[51];
        for(int i=0;i<51;i++)
        {
            vector[i]=new Vector();
        }


        l=new Line[10000];
        for(int i=0;i<10000;i++)
        {
            l[i]=new Line(-1,-1,-1,-1);
        }
        dis=new Text[50];

        c=new Circle[50];
        texts=new Text[50];
        for(int i=0;i<50;i++)
        {
            c[i]=new Circle(0,0,0);
            texts[i]=new Text();
            dis[i]=new Text();
        }
        //Circle r=new Circle(50,50,10);
       // Circle r1=new Circle(500,50,10);
       // Line line=new Line(0,550,900,550);// line.setFill(Color.CRIMSON);
        line=new Text[12];
        line[0]=new Text("procedure BFS");
        line[1]=new Text("Push root to Queue");
        line[2]=new Text("  while Queue is not empty :");
        line[3]=new Text("      Parent=Queue's first element");
        line[4]=new Text("      Pop Queue");
        line[5]=new Text("      for every Neighbour of Parent :");
        line[6]=new Text("          if Neighbour is visited: continue ");
        line[7]=new Text("          if distance[Parent]+1<distance[Neighbour]");
        line[8]=new Text("             distance[Neighbour]=distance[Parent]+1");
        line[9]=new Text("             Push Neighbour to Queue");
        line[10]=new Text("             Set Neighbour Visited");
        line[11]=new Text("end procedure");
        for(int i=0;i<12;i++)
        {
            line[i].setX(745);
            line[i].setY(200+30*i);
            line[i].setFill(Color.WHITE);
            line[i].setFont(Font.font("Segoe Script",20));
        }



        Button edge;
        edge=new Button("Add edge");
        edge.setLayoutX(472);
        edge.setLayoutY(680);
        //edge.setStyle("-fx-background-color: linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30; -fx-background-insets: 0,1,2,3,0; -fx-text-fill: #654b00; -fx-font-weight: bold; -fx-font-size: 14px; -fx-padding: 10 20 10 20;");
        edge.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");



        Text text=new Text("ENTER ROOT :");
        text.setLayoutX(291);
        text.setLayoutY(660);
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Segoe Script",20));
        text.setVisible(false);

       // event.setFill(Color.WHITE);
        event.setFont(Font.font("Segoe Script",24));
        process.setFill(Color.RED);
        process.setFont(Font.font("Segoe Script",20));

        Text alert=new Text("Root not found");
        alert.setLayoutX(462);
        alert.setLayoutY(760);
        alert.setFont(Font.font("Segoe Script",20));
        alert.setFill(Color.RED);
        alert.setVisible(false);

        TextField textField=new TextField();
        textField.setLayoutX(462);
        textField.setLayoutY(637);
        textField.setVisible(false);

        root.getChildren().add(alert);
        root.getChildren().addAll(textField,text);
        root.getChildren().addAll(l);
        root.getChildren().addAll(c);

        root.getChildren().add(edge);
        root.getChildren().addAll(texts);
        root.getChildren().addAll(dis);
        root.getChildren().add(event);
        root.getChildren().add(process);


        javafx.scene.control.ScrollPane scrollPane=new ScrollPane();
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

        back=new Button("Back To Home");
        back.setLayoutX(130);
        back.setLayoutY(30);

        bt1=new Button("PAUSE");
        bt1.setLayoutX(1170);
        bt1.setLayoutY(30);
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "0.5X",
                        "0.7X",
                        "1.0X",
                        "1.2X",
                        "1.4X",
                        "1.5X"
                );
        comboBox = new ComboBox(options);
        comboBox.setLayoutX(1170);
        comboBox.setLayoutY(90);
        bt1.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        back.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        comboBox.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4;-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        comboBox.setMaxHeight(50);
        comboBox.setMaxWidth(120);
        comboBox.setMinHeight(50);
        comboBox.setMinWidth(120);
        comboBox.setPromptText("SPEED");
        root.getChildren().addAll(back,bt1,comboBox);
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
        root.getChildren().add(imageView1[0]);
        root.getChildren().add(scrollPane);
        root.getChildren().addAll(line);
        root.getChildren().add(queue);
        Scene scene=new Scene(root,1300,800);
        f.setScene(scene);
        f.show();

        new Thread(()-> {
            int wewe[] = {100};
            nos = new int[1];
            nos[0] = 0;
            //textField.set
            Thread thread = Thread.currentThread();
            int paneMove[] = {0};
            imageView1[0].setOnMouseClicked(e ->
            {
                ParallelTransition parallelTransition = new ParallelTransition();
                TranslateTransition translateTransition[] = new TranslateTransition[4];
                for (int i = 0; i < 4; i++) {
                    translateTransition[i] = new TranslateTransition();
                }
                translateTransition[0].setNode(scrollPane);
                translateTransition[1].setNode(back);
                translateTransition[2].setNode(imageView1[0]);
                translateTransition[3].setNode(queue);
                if (paneMove[0] % 2 == 0) {
                    System.out.println("oya");
                    ;
                    translateTransition[0].setByX(300);
                    translateTransition[1].setByX(300);
                    translateTransition[2].setByX(300);
                    translateTransition[3].setByX(300);
                } else {
                    translateTransition[0].setByX(-300);
                    translateTransition[1].setByX(-300);
                    translateTransition[2].setByX(-300);
                    translateTransition[3].setByX(-300);
                    System.out.println("eta");
                }
                paneMove[0]++;
                translateTransition[0].setDuration(Duration.seconds(0.5));
                translateTransition[1].setDuration(Duration.seconds(0.5));
                translateTransition[2].setDuration(Duration.seconds(0.5));
                translateTransition[3].setDuration(Duration.seconds(0.5));
                parallelTransition.getChildren().addAll(translateTransition);
                parallelTransition.play();
            });


            back.setOnAction(e ->
            {
                Main main = new Main();
                try {
                    main.then(f);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });

            rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    if (wewe[0] == 100) {
                        int x;


                        for (x = 0; x < 50; x++) {
                            if (c[x].getRadius() == 0) {
                                break;
                            }
                        }
                        if (x < 50) {
                            Point pointer = MouseInfo.getPointerInfo().getLocation();
                            System.out.println("pointer " + pointer.getX() + " " + pointer.getY());

                            c[x].setCenterX(pointer.getX() - f.getX());
                            c[x].setCenterY(pointer.getY() - f.getY() - 20);
                            nos[0]++;
                            c[x].setRadius(25);
                            texts[x].setY(c[x].getCenterY() + 6);
                            if (x < 9) {
                                texts[x].setX(c[x].getCenterX() - 5);


                            } else {

                                texts[x].setX(c[x].getCenterX() - 10);
                            }


                            texts[x].setText(String.valueOf(x + 1));
                            texts[x].setFill(Color.WHITE);
                            texts[x].setVisible(true);
                            texts[x].setFont(Font.font(20));
                            //texts[x].set

                            System.out.println("center " + c[x].getCenterX() + " " + c[x].getCenterY());

                            System.out.println("f " + f.getX() + " " + f.getY());
                        }
                    }
                    else {
                            ;
                        }

                }
            });
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (wewe[0] == 101) {
                        System.out.println("first");
                        Point pointer = MouseInfo.getPointerInfo().getLocation();
                        System.out.println(pointer.getX() + " " + pointer.getY());
                        double q = pointer.getX(), w = pointer.getY();
                        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                System.out.println("second");
                                Point pointer1 = MouseInfo.getPointerInfo().getLocation();
                                System.out.println(pointer1.getX() + " " + pointer1.getY());
                                int a = -1;
                                for (int i = 0; i < 50; i++) {
                                    if (q - f.getX() <= c[i].getCenterX() + 25 && q - f.getX() >= c[i].getCenterX() - 25 & w - f.getY() - 20 <= c[i].getCenterY() + 25 && w - f.getY() - 20 >= c[i].getCenterY() - 25) {
                                        a = i;
                                        break;
                                    }
                                }
                                int b = -1;
                                for (int i = 0; i < 50; i++) {
                                    if (pointer1.getX() - f.getX() <= c[i].getCenterX() + 25 && pointer1.getX() - f.getX() >= c[i].getCenterX() - 25 && pointer1.getY() - f.getY() - 20 <= c[i].getCenterY() + 25 && pointer1.getY() - f.getY() - 20 >= c[i].getCenterY() - 25) {
                                        b = i;
                                        break;
                                    }
                                }
                                // Reflection reflection=new Reflection();
                                if (a != -1 && b != -1) {
                                    for (int i = 0; i < 10000; i++) {
                                        System.out.println(i);
                                        if (l[i].getStartX() == -1) {
                                            l[i].setStartX(c[a].getCenterX());
                                            l[i].setStartY(c[a].getCenterY());
                                            l[i].setEndX(c[b].getCenterX());
                                            l[i].setEndY(c[b].getCenterY());
                                            vector[a].add(b);
                                            vector[b].add(a);
                                            break;
                                        }
                                    }
                                }
                            }


                        });
                    }
                }
            });

            edge.setOnAction(e ->
            {
                if (wewe[0] == 102) {
                    int n = Integer.parseInt(textField.getText());
                    System.out.println("n " + n);
                    if (n <= nos[0]) {
                        textField.setVisible(false);
                        text.setVisible(false);
                        alert.setVisible(false);
                        edge.setVisible(false);
                        try {
                            showBFS(n);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }

                    } else {
                        alert.setVisible(true);
                        wewe[0] = 101;
                    }
                } else if (wewe[0] == 101) {
                    textField.setVisible(true);
                    text.setVisible(true);
                    wewe[0] = 102;
                    edge.setText("Show BFS");
                } else if (wewe[0] == 100) {
                    wewe[0] = 101;
                    edge.setText("Next");
                }

            });
        }).start();

    }


    public void showBFS(int root) throws InterruptedException {
        System.out.println("dwodowkd");
        queue.setVisible(true);
        root--;
        int n=nos[0];
        boolean[] vis=new boolean[51];
        for(int i=0;i<n;i++)
        {
            for(int g=0;g<vector[i].size();g++)
            {
                System.out.printf("%d ",vector[i].get(g));
            }
            System.out.println();
        }
        for(int i=0;i<n;i++)
        {
            dis[i].setText("INF");
            dis[i].setX(c[i].getCenterX()-10);
            dis[i].setY(c[i].getCenterY()-35);
            dis[i].setVisible(true);
        }
        int koto[]=new int[n];
        for(int i=0;i<n;i++)
        {
            koto[i]=1000000;
        }
        koto[root]=0;
        dis[root].setText("0");
        tt1[even].setText("Distance of "+(root+1)+" set to 0");
        even++;
        tt1[even].setText((root+1)+" is marked visited");
        even++;
        vis[root]=true;
        c[root].setFill(Color.DARKRED);
        Queue<Integer> q = new LinkedList<>();
        String sp;
        line[1].setFill(Color.BLUE);
        System.out.println("ekhane");;
        q.add(root);
        sp=new String("Queue : ");
        for(int i=0;i<q.size();i++)
        {
            sp+=String.valueOf(((LinkedList<Integer>) q).get(i)+1);
            if(i!=q.size()-1)
            {
                sp+=",";
            }
        }
        System.out.println("queue "+sp);
        queue.setText(sp);
        Thread.sleep(1000);
        line[1].setFill(Color.WHITE);
        try { Thread.sleep(1000); } catch (InterruptedException e){}
        new Thread(()->
        {

            int[] speed = {1000};
            comboBox.setOnAction(e ->
            {
                String qe = (String) comboBox.getValue();
                qe = qe.substring(0, 3);
                System.out.println(qe);
                double d = Double.parseDouble(qe);
                System.out.println(d);
                speed[0] = (int) (1000 / d);
                System.out.println(speed[0]);
            });
            int[] er = {0};
            Thread thread=Thread.currentThread();
            bt1.setOnAction(e ->
            {
                er[0]++;
                if (er[0] % 2 == 1) {
                    bt1.setText("RESUME");
                    thread.suspend();

                } else {
                    bt1.setText("Pause");
                    thread.resume();

                }
            });
            while (!q.isEmpty())
            {
                line[2].setFill(Color.BLUE);
                try {
                    Thread.sleep(speed[0]/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                line[2].setFill(Color.WHITE);

                int s=q.peek();
                tt1[even].setText("Node "+(s+1)+" is processing");
                even++;
                line[3].setFill(Color.BLUE);
                try {
                    Thread.sleep(speed[0]/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                line[3].setFill(Color.WHITE);
                System.out.println(s);
                process.setText("Current Processing node: "+String.valueOf(s+1));
                process.setFill(Color.RED);
                process.setVisible(true);
                ((LinkedList<Integer>) q).pop();
                String sp2;
                sp2=new String("Queue : ");
                for(int i=0;i<q.size();i++)
                {
                    sp2+=String.valueOf(((LinkedList<Integer>) q).get(i)+1);
                    if(i!=q.size()-1)
                    {
                        sp2+=",";
                    }

                }
                line[4].setFill(Color.BLUE);
                System.out.println("queue "+sp2);
                queue.setText(sp2);
                try { Thread.sleep(speed[0]); } catch (InterruptedException e){}
                line[4].setFill(Color.WHITE);
                for(int i=0;i<vector[s].size();i++)
                {
                    line[5].setFill(Color.BLUE);

                    int u=(int)vector[s].get(i);
                    int r;
                    for( r=0;r<10000;r++)
                    {
                        if(l[r].getStartX()==c[s].getCenterX()&&l[r].getStartY()==c[s].getCenterY()&&l[r].getEndX()==c[u].getCenterX()&&l[r].getEndY()==c[u].getCenterY())
                        {
                            break;
                        }
                        else if(l[r].getStartX()==c[u].getCenterX()&&l[r].getStartY()==c[u].getCenterY()&&l[r].getEndX()==c[s].getCenterX()&&l[r].getEndY()==c[s].getCenterY())
                        {
                            break;
                        }
                    }
                    FadeTransition fade = new FadeTransition();
                    fade.setDuration(Duration.millis(speed[0]));
                    fade.setFromValue(10);
                    fade.setToValue(0.5);
                    fade.setNode(l[r]);
                    fade.play();
                    try { Thread.sleep(speed[0]*2); } catch (InterruptedException e) { ; }
                    ScaleTransition scaleTransition=new ScaleTransition();
                    scaleTransition.setByX(0.5);
                    scaleTransition.setByY(0.5);
                    scaleTransition.setNode(c[u]);
                    scaleTransition.setCycleCount(2);
                    scaleTransition.setDuration(Duration.millis(speed[0]));
                    scaleTransition.setAutoReverse(true);
                    scaleTransition.play();
                    try { Thread.sleep(speed[0]*2); } catch (InterruptedException e){}
                    line[5].setFill(Color.WHITE);
                    if(vis[u]){
                        line[6].setFill(Color.BLUE);
                        try {
                            Thread.sleep(speed[0]);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        line[2].setFill(Color.WHITE);
                        event.setVisible(true);
                        try { Thread.sleep(speed[0]); } catch (InterruptedException e){}
                        event.setVisible(false);
                        line[6].setFill(Color.WHITE);
                        continue;
                    }
                    else
                    {
                        if(koto[u]>koto[s]+1) {
                            line[7].setFill(Color.BLUE);
                            try {
                                Thread.sleep(speed[0]);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            line[7].setFill(Color.WHITE);
                            vis[u] = true;
                            koto[u] = koto[s] + 1;
                            line[8].setFill(Color.BLUE);
                            dis[u].setText(String.valueOf(koto[u]));
                            tt1[even].setText("Distance of "+(u+1)+" set to "+koto[u]);
                            even++;
                            try {
                                Thread.sleep(speed[0]);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            line[8].setFill(Color.WHITE);
                            line[9].setFill(Color.BLUE);
                            ((LinkedList<Integer>) q).add(u);
                            try {
                                Thread.sleep(speed[0]/2);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            line[9].setFill(Color.WHITE);
                            line[10].setFill(Color.BLUE);
                            c[u].setFill(Color.DARKRED);
                            tt1[even].setText("Node "+(u+1)+" is marked visited");
                            even++;
                            vis[u]=true;
                            try {
                                Thread.sleep(speed[0]);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            line[10].setFill(Color.WHITE);
                            String sp1;
                            sp1 = new String("Queue : ");

                            for (int w = 0; w < q.size(); w++) {
                                sp1 += String.valueOf(((LinkedList<Integer>) q).get(w) + 1);
                                if (w != q.size() - 1) {
                                    sp1 += ",";
                                }

                            }
                            System.out.println("queue " + sp1);
                            queue.setText(sp1);
                            try {
                                Thread.sleep(speed[0]);
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }


            }
            tt1[even].setText("Procedure ended");
            even++;
            event.setVisible(true);
            line[11].setFill(Color.BLUE);
            event.setText("BFS DONE!!");
            event.setFill(Color.GREEN);
            queue.setVisible(false);
            process.setVisible(false);
            bt1.setDisable(true);
            comboBox.setDisable(true);
            for(int i=0;i<n;i++)
            {
                System.out.println("p "+koto[i]);
            }


        }).start();

    }
}
