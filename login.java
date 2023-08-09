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
import javafx.stage.Stage;


public class login extends Application
{
    public TextField name1;
    public TextField pass1;


    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Welcome");
        
        
        Label name = new Label("Name");
        Label pass = new Label("Password");
         name1=new TextField();
          pass1 = new TextField();
        Button loginn=new Button("LOG IN");

        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);

        gp.addRow(0,name,name1);
        gp.addRow(1,pass,pass1);
        gp.addRow(2,loginn);

        //button even
        loginn.setOnAction(new EventHandler<ActionEvent>()
        {
        
            @Override
            public void handle(ActionEvent log) {
                account acc = new account();
                acc.loginacc(stage,name1.getText(),pass1.getText());

            }
        });
           
        Scene scene = new Scene(gp,500,300);
        stage.setScene(scene);
        stage.show();
    }    
}
