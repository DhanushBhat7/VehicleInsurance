package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.geometry.Pos;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;

public class claim extends Application{

    public void start(Stage mystage) throws Exception
    {
        final String user="root";
        final String passw="1234";
        final String db_url="jdbc:mysql://127.0.0.1:3306/App";
        mystage.setTitle("CLAIMING");
        Button claim = new Button("claim");

        GridPane gd=new GridPane();
        gd.addRow(0,claim);
        account acc= new account();

        claim.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent claimae) {
                
            try{
          //  Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
            Connection  con=DriverManager.getConnection(db_url,user,passw);
            Statement stmt= con.createStatement();
            stmt.executeUpdate("update payclaim set paid=0 where id=\""+acc.id+"\";");
            }
            catch(Exception e){e.printStackTrace();}
            System.out.println("You Have SuccessFully CLaimed The insuranse Money");
            
            
            afterlogin afl = new afterlogin();
            try{
            afl.start(mystage);
            }
            catch(Exception e){e.printStackTrace();}
            }
            
        });


    }

}
