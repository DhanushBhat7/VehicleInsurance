package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
//import java
//import jext.Text;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class pay extends Application{
    @Override
    public void start(Stage stage) throws Exception
    {
        final String usersql="root";
        final String passsql="1234";
        final String db_url="jdbc:mysql://127.0.0.1:3306/App";
        stage.setTitle("Paying");
        Label lb = new Label("Enter Amount");
        Text tf = new Text();
        Button pay = new Button("Pay");
        
        account acc = new account();
        Connection con;
        Statement stmt;
        try{
            con = DriverManager.getConnection(db_url,usersql,passsql);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from table2 where id ="+acc.id+";");
            while(rs.next())
            {
                tf.setText(rs.getString(5));
            }
        }
        catch(Exception e){e.printStackTrace();}
    
        GridPane gd=new GridPane();
        gd.setHgap(10);gd.setVgap(15);
        gd.setAlignment(Pos.CENTER);
        gd.addRow(0,lb,tf);                                                            //1.login_det-CONATINS ID PASS OPT1,OPT2
        gd.addRow(1,pay);                                                              //2.abt_vehi-CONTAINS VEHICLE PLaTE MODEL.
                                                                                       //3.

        //button events
        pay.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent pay)
            {
                afterlogin afl = new afterlogin();
                try{
                    Connection con = DriverManager.getConnection(db_url,usersql,passsql);
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate("update payclaim set paid=paid+"+Integer.parseInt(tf.getText())+" where id=\""+acc.id+"\";");               //create table details
                    System.out.println("Successfully paid");
                    try{
                    afl.start(stage);
                    }
                    catch(Exception e){e.printStackTrace();}                }
                catch(Exception e)
                {e.printStackTrace();}
            }
        });

        Scene scene = new Scene(gd,700,500);
        stage.setScene(scene);
        stage.show();
    }
}
