package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class MergeController implements EventHandler<ActionEvent> {
    int p,i;int[] array;int s;int tempo;int o=0;
    Text line[];
    Text tt[];
    int even=1;
    Circle[] c;
    int[] speed={1000};
    Line[] a1;
    Text[] text;
    @FXML
    Button next,a_submit;
    Stage f;
    @FXML
    TextField T,t0,t1,t2,t3,t4,t5,t6,t7;
    @FXML
    Text alert_for_size,a0,a11,a2,a3,a4,a5,a6,a7,alert_for_field;
    TextField t[];
    Text a[];
    public void mergeclicked(Button bubblesort) throws Exception {

        Node node = FXMLLoader.load(getClass().getResource("smerge.fxml"));
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
            a[1]=a11;
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

    public void showsort() throws java.lang.InterruptedException {
        line=new Text[15];
        line[0]=new Text("procedure MergeSort(Array,begin,end)");
        line[1]=new Text("  if begin < end :");
        line[2]=new Text("       MergeSort (Array,begin,mid)");
        line[3]=new Text("       MergeSort (Array,mid+1,end)");
        line[4]=new Text("       Merge Both Part");
        line[5]=new Text("end procedure");
        line[6]=new Text("");
        line[7]=new Text("procedure Merge(Array,begin,end,mid)");
        line[8]=new Text("  start1=begin,start2=mid+1");
        line[9]=new Text("  while all element not taken :");
        line[10]=new Text("      if Array[start1] < Array[start2] :");
        line[11]=new Text("         take Array[start1],start1++");
        line[12]=new Text("      else : ");
        line[13]=new Text("         take Array[start2],start2++");
        line[14]=new Text("end procedure");
        for(int i=0;i<15;i++)
        {
            line[i].setX(830);
            line[i].setY(200+30*i);
            line[i].setFill(Color.WHITE);
            line[i].setFont(Font.font("Segoe Script",20));
        }
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
        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setMaxWidth(300);
        scrollPane.setMaxHeight(800);
        scrollPane.setMinHeight(800);
        scrollPane.setMinWidth(300);
        scrollPane.setLayoutX(-300);
        scrollPane.setStyle("-fx-background-color: RED");
        scrollPane.setStyle("-fx-background:WHITE");

        VBox vBox=new VBox();
        tt=new Text[400];
        for(int i=0;i<400;i++)
        {
            tt[i]=new Text();
            tt[i].setFont(Font.font("Segoe Script",20));
        }
        tt[0].setText("Event Log:                                    ");
        vBox.getChildren().addAll(tt);
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
            group.getChildren().add(imageView1[0]);
        }

        catch (Exception e)
        {
            System.out.println("mor");
        }
        group.getChildren().addAll(line);
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
        comboBox.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4;-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        comboBox.setMaxHeight(50);
        comboBox.setMaxWidth(120);
        comboBox.setMinHeight(50);
        comboBox.setMinWidth(120);
        comboBox.setPromptText("SPEED");
        group.getChildren().add(comboBox);
        Button back=new Button("Back To Home");
        back.setLayoutX(130);
        back.setLayoutY(30);
        group.getChildren().add(back);
        back.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");
        Button bt1=new Button("PAUSE");
        bt1.setLayoutX(1170);
        bt1.setLayoutY(30);
        group.getChildren().add(bt1);
        bt1.setStyle("-fx-background-color: linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%), linear-gradient(#020b02, #3a3a3a), linear-gradient(#b9b9b9 0%, #c2c2c2 20%, #afafaf 80%, #c8c8c8 100%), linear-gradient(#f5f5f5 0%, #dbdbdb 50%, #cacaca 51%, #d7d7d7 100%); -fx-background-insets: 0,1,4,5; -fx-background-radius: 9,8,5,4; -fx-padding: 15 30 15 30; -fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #333333; -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1)");

        c=new Circle[5000];
        text=new Text[5000];
        a1=new Line[5000];
        o=0;
        for(int i=0;i<5000;i++)
        {
            c[i]=new Circle();
            text[i]=new Text();
            a1[i]=new Line(0,0,0,0);
        }

        Stage stage = (Stage)a_submit.getScene().getWindow();
        int n=i;
        int[] a=array;
        tempo=(n+1)/2;
        tempo=tempo*40;
        tempo=450-tempo-40;
        double avg=0,start=0;
        for(int i=0;i<n;i++)
        {
            c[i] = new Circle(tempo+40 * (i + 1), 130, 20);
            avg+=tempo+40 * (i + 1);
            if(i==0)
            {
                start=c[i].getCenterX();
            }
            c[i].setFill(Color.RED);
            c[i].setSmooth(true);
            text[i] = new Text();
            text[i].setText(String.valueOf(a[i]));
            if(a[i]<10)
                text[i].setX(tempo+40 * (i + 1) - 2);
            else if(a[i]<100)
                text[i].setX(tempo+40 * (i + 1) - 2-5);
            else
                text[i].setX(tempo+40 * (i + 1) - 2-10);
            text[i].setY(134);
        }
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ie)
        {
        }
        avg/=n;
        s=n-1;
        //=new arrows(avg,100,avg-n*15,200-20,10);
        double r[]={avg},t[]={start};
        new Thread(()-> {
            int[] er={0};
            Thread thread=Thread.currentThread();
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
                thread.stop();
            });
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
            try {
                sort(a, 0, n - 1, 1, r[0],t[0]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bt1.setDisable(true);
            comboBox.setDisable(true);
            tt[even].setText("Array sorted.");
            even++;
        }).start();

        group.getChildren().addAll(a1);
        group.getChildren().addAll(c);
        group.getChildren().addAll(text);
        group.getChildren().add(scrollPane);
        stage.setScene(new Scene(group,1300,800));
        stage.show();
    }
    void sort(int a[], int l, int r,int level,double centmid,double start) throws InterruptedException {
            System.out.println("s " + s);

            if (l < r) {
                line[1].setFill(Color.BLUE);
                Thread.sleep(speed[0]);
                line[1].setFill(Color.WHITE);
                int lol = r - l + 1;
                if (lol <= 2) {
                    lol = 1;
                } else if (lol <= 4) {
                    lol = 2;
                } else if (lol <= 8) {
                    lol = 3;
                }
                lol *= 2;
                // Find the middle point
                int m = (l + r) / 2;
                double u = centmid - (r - l + 1) * 20;
                double x = 0, y = 0, xstart = 0, ystart = 0;
                a1[o].setStartX(centmid);
                a1[o].setStartY(level*100+30);
                a1[o].setEndX(centmid - (r - l + 1) * 20);
                a1[o].setEndY((level + 1) * 100 - 20+30);
                a1[o].setStrokeWidth(3);
                o++;

                for (int i = m; i >= l; i--) {
                    s++;
                    c[s].setCenterY((level + 1) * 100+30);
                    c[s].setCenterX(u);
                    if (i == l) {
                        xstart = c[s].getCenterX();
                    }

                    x += c[s].getCenterX();
                    c[s].setRadius(20);
                    c[s].setFill(Color.RED);
                    text[s].setText(String.valueOf(a[i]));
                    if(a[i]<10)
                        text[s].setX(u);
                    else if(a[i]<100)
                        text[s].setX(u-5);
                    else
                        text[s].setX(u-10);
                    text[s].setY((level + 1) * 100 + 4+30);
                    u -= 40;
                }
                line[2].setFill(Color.BLUE);
                Thread.sleep(speed[0]);
                line[2].setFill(Color.WHITE);
                try {
                    Thread.sleep(speed[0]);
                }
                catch (InterruptedException ie)
                {
                }
                x /= (m - l + 1);
                u = centmid + (r - l + 1) * 20;
                a1[o].setStartX(centmid);
                a1[o].setStartY(level*100+30);
                a1[o].setEndX(centmid+(r-l+1)*20);
                a1[o].setEndY((level+1)*100-20+30);
                a1[o].setStrokeWidth(3);
                o++;

                for (int i = m + 1; i <= r; i++) {
                    s++;
                    c[s].setCenterY((level + 1) * 100+30);
                    c[s].setCenterX(u);
                    if (i == m + 1) {
                        ystart = c[s].getCenterX();
                    }
                    y += c[s].getCenterX();
                    c[s].setRadius(20);
                    c[s].setFill(Color.RED);
                    text[s].setText(String.valueOf(a[i]));
                    if(a[i]<10)
                         text[s].setX(u);
                    else if(a[i]<100)
                        text[s].setX(u-5);
                    else
                        text[s].setX(u-10);
                    text[s].setY((level + 1) * 100 + 4+30);
                    u += 40;
                }
                line[3].setFill(Color.BLUE);

                String temp1=new String(),temp2=new String(),temp3=new String();
                for(int i=l;i<=r;i++)
                {
                    temp1=temp1+String.valueOf(a[i]);
                    if(i<r)
                    {
                        temp1+=",";
                    }
                }
                for(int i=l;i<=(l+r)/2;i++)
                {
                    temp2=temp2+String.valueOf(a[i]);
                    if(i<(l+r)/2)
                    {
                        temp2+=",";
                    }
                }
                for(int i=(l+r)/2+1;i<=r;i++)
                {
                    temp3=temp3+String.valueOf(a[i]);
                    if(i<r)
                    {
                        temp3+=",";
                    }
                }
                String string="{"+temp1+"} is divided to {"+temp2+"} and {"+temp3+"}";
                tt[even].setText(string);
                even++;
                Thread.sleep(speed[0]);
                line[3].setFill(Color.WHITE);
                try {
                    Thread.sleep(speed[0]);
                }
                catch (InterruptedException ie)
                {
                }
                double z = c[s].getCenterX();
                y /= (r - (m + 1) + 1);


                sort(a, l, m, level + 1, x, xstart);
                sort(a, m + 1, r, level + 1, y, ystart);
                temp2=new String();
                temp3=new String();
                for(int i=l;i<=(l+r)/2;i++)
                {
                    temp2=temp2+String.valueOf(a[i]);
                    if(i<(l+r)/2)
                    {
                        temp2+=",";
                    }
                }
                for(int i=(l+r)/2+1;i<=r;i++)
                {
                    temp3=temp3+String.valueOf(a[i]);
                    if(i<r)
                    {
                        temp3+=",";
                    }
                }
                merge(a,l,m,r);
                int p=how(m-l+1),q=how(r-(m+1)+1);

                a1[o].setEndX(centmid);
                a1[o].setEndY((level+lol)*100-20+30);
                a1[o].setStartX(centmid - (r - l + 1) * 20);
                a1[o].setStartY((level + 1) * 100 +20+(p)*100+30);
                a1[o].setStrokeWidth(3);
                o++;
                a1[o].setEndX(centmid);
                a1[o].setEndY((level+lol)*100-20+30);
                a1[o].setStartX(centmid + (r - l + 1) * 20);
                a1[o].setStartY((level + 1) * 100 +20+(q)*100+30);
                a1[o].setStrokeWidth(3);
                o++;

                lol += level;
                double tyy = start;
                line[4].setFill(Color.BLUE);
                for (int ii = l; ii <= r; ii++) {
                    s++;
                    c[s].setCenterY(lol * 100+30);
                    c[s].setCenterX(tyy);
                    c[s].setRadius(20);
                    c[s].setFill(Color.RED);
                    text[s].setText(String.valueOf(a[ii]));
                    if(a[ii]<10)
                        text[s].setX(tyy - 2);
                    else if(a[ii]<100)
                        text[s].setX(tyy-2-5);
                    else
                        text[s].setX(tyy-2-10);
                    text[s].setY(lol * 100 + 4+30);
                    tyy += 40;
                    try {
                        Thread.sleep(speed[0]/2);
                    }
                    catch (InterruptedException ie)
                    {
                    }
                }
                temp1=new String();
                for(int i=l;i<=r;i++)
                {
                    temp1=temp1+String.valueOf(a[i]);
                    if(i<r)
                    {
                        temp1+=",";
                    }
                }

                tt[even].setText("{"+temp2+"} and {"+temp3+"} are merged to {"+temp1+"}");
                even++;
                line[4].setFill(Color.WHITE);
                line[5].setFill(Color.BLUE);
                try {
                    Thread.sleep(speed[0]);
                }
                catch (InterruptedException ie)
                {
                }
                line[5].setFill(Color.WHITE);
            }
    }
    int how(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2)
        {
            return 2;
        }
        else if(n<=4)
        {
            return 4;
        }
        else if(n<=8)
        {
            return 6;
        }
        return 0;
    }

    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }



}
