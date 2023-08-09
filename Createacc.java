package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
import javafx.stage.Stage;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
public class Createacc extends Application{
    final String user="root";
	final String passw="1234";
	final String db_url="jdbc:mysql://127.0.0.1:3306/App";
    public TextField f1;
    public TextField f2;
    public TextField enter_bname;
    public  TextField enter_bno ;
    public TextField enter_cname;
    public  TextField enter_cno ;


    @Override
    public void start(Stage stage) throws Exception{

        stage.setTitle("CREATING ACCOUNT");
        GridPane gd=new GridPane();
        Label l1=new Label("Enter the ID(First Name)");
         f1=new TextField();
        Label l2=new Label("Enter The Password");
         f2=new TextField();
        Label bname = new Label("bike name");
        Label bno = new Label("bike number");
        Label cno = new Label("car number");
        Label cname = new Label("car name");
        Label warn=new Label("BEFORE SUBMITTING 1ST YEAR PREMIUM SHOULD BE PAYED THAT IS Rs.xxx");
         enter_bname = new TextField();
         enter_bno = new TextField();
         enter_cname = new TextField();
         enter_cno = new TextField();



        Button bike = new Button("Bike");
        Button car = new Button("Car");
        Button both =new Button("BIKE & CAR");

        gd.setAlignment(Pos.CENTER);
        gd.setHgap(10);gd.setVgap(10);
        gd.addRow(0,l1,f1);
        gd.addRow(1,l2,f2);
        gd.addRow(2,bike,car,both);


        //events for buttons
        bike.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent bi)
            {
                gd.getChildren().removeAll(car,both,bike);
                gd.addRow(3,bname,enter_bname);
                gd.addRow(4,bno,enter_bno);
                gd.addRow(5, warn);
                bike.setText("SUBMIT");
                gd.addRow(5,bike);
                bike.setOnAction(new EventHandler<ActionEvent>()
                    {
                        @Override
                        public void handle(ActionEvent bi1)
                        {
                            account acc= new account();
                            acc.createacc(stage,1,f1.getText(),f2.getText(),enter_bname.getText(),enter_bno.getText(),null,null);
                        }
                    });
                Scene scene = new Scene(gd,800,600);
                stage.setScene(scene);
                stage.show();
                    
            }
        });
        car.setOnAction(new EventHandler<ActionEvent>()
        {
           
            public void handle(ActionEvent ca) 
            {
                gd.getChildren().removeAll(car,both,bike);
                gd.addRow(3,cname,enter_cname);
                gd.addRow(4,cno,enter_cno);
                gd.addRow(5, warn);
                car.setText("SUBMIT");
                gd.addRow(6,car);
                car.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent ca1)
                    {
                        account acc=new account();
                        acc.createacc(stage,2,f1.getText(),f2.getText(),null,null,enter_cname.getText(),enter_cno.getText());
                    }
                });
                Scene scene=new Scene(gd,800,600);
                stage.setScene(scene);
                stage.show();
        
            }
        });
        
        both.setOnAction(new EventHandler<ActionEvent>()
        {
           @Override
           public void handle(ActionEvent bot)
           {
               gd.getChildren().removeAll(car,both,bike);
               gd.addRow(3,bname,enter_bname);
               gd.addRow(4,bno,enter_bno);
               gd.addRow(5,cname,enter_cname);
               gd.addRow(6,cno,enter_cno);
               gd.addRow(8, warn);
               bike.setText("SUBMIT");
               gd.addRow(7,bike);
                bike.setOnAction(new EventHandler<ActionEvent>()
                    {
                        @Override
                        public void handle(ActionEvent bi1)
                        {
                            account acc= new account();
                            try{
                            acc.createacc(stage,f1.getText(),f2.getText(),enter_bname.getText(),enter_bno.getText(),enter_cname.getText(),enter_cno.getText());
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    });
                Scene scene = new Scene(gd,800,600);
                stage.setScene(scene);
                stage.show();
           } 
        });

        
        Scene scene = new Scene(gd,800,600);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
