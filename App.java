package application;

// import java.util.Scanner;

//import javax.lang.model.util.ElementScanner6;

//import javax.lang.model.util.ElementScanner14;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;/
// import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
// import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
// import javafx.scene.layout.VBox;
// import javafx.scene.text.Text;
import javafx.stage.Stage;


   
 



public class App extends Application{
 public static void main(String[] args) {
 
     launch(args);
  
}

@Override
public void start(Stage mystage) throws Exception{
    mystage.setTitle("Home");
 //   Label lb = new Label("Welcome to Insurance Company");
    Text t = new Text (10, 20, "Welcome to Insurance Company");
    Button login = new Button("Login");
    Button create = new Button("Create");

    GridPane gp = new GridPane();
    gp.setAlignment(Pos.CENTER);
    // gp.setHgap(10);
    gp.setVgap(15);
    t.setFont(Font.font ("Verdana", 20));

    gp.addRow(0,t);
    gp.addRow(1,login);
    gp.addRow(2,create);

    //adding button events
    //for login
    login.setOnAction(new EventHandler<ActionEvent>(){

        @Override
        public void handle(ActionEvent log)
        {
            
          account a1 = new account();
            a1.rectify(1,mystage);
          // Login lg = new Login();
            // lg.start(mystage);
        }
    });
    create.setOnAction(new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent cre)
        {
            account acc = new account();
                acc.rectify(2,mystage);
        }
    });



    Scene scene = new Scene(gp,500,300);
    mystage.setScene(scene);
    mystage.show();
}

}
