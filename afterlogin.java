package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class afterlogin extends Application{
    
    final String JDBCdrive="com.mysql.cj.jdbc.Driver";
	final String user="root";
	final String passw="1234";
	final String db_url="jdbc:mysql://127.0.0.1:3306/App";
	Connection con;
	Statement stmt;

    String check1;
    String check2;

    account ac=new account();

    public void start(Stage stage) throws Exception{
        stage.setTitle("Welcome");

        Label top12=new Label("THIS IS THE AFTER LOGIN PAGE");
        Button pay1 = new Button("Pay");
        Button claim1=new Button("Claim");
        
        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);
    
        gp.addRow(0,top12);
        // gp.addRow(,view);
        gp.addRow(1,pay1);
        gp.addRow(2,claim1);

    /*    account acc= new account();
        if(acc.choice==1)
        {
            top12.setText("You have Bike Insurance");
        }
        else if(acc.choice==2)
        {
            top12.setText("You have Car Insurance");
        }
        else if(acc.choice==3)
        {
            top12.setText("YOU HAVE BOTH BIKE CAR INSURANCE");
        }  
        else{
            top12.setText("ENTER A VALID OPTION");
        }      
*/
        //adding button events
        try{
    		
    		con=DriverManager.getConnection(db_url,user,passw);
    		stmt= con.createStatement();
    		ResultSet rs=stmt.executeQuery("Select bname,cname from loginoo where id='"+ac.permnaid+"' and pass='"+ac.permnapassw+"'");
    		if(rs.getString(1)=="0")
            {
                top12.setText("YOU HAVE CAR INSURANCE");
            }
            if(rs.getString(2)=="0")
            {
                top12.setText("YOU HAVE BIKE INSURANCE");
            }
            if(rs.getString(1)!="0" && rs.getString(2)!="0")
            {
                top12.setText("YOU HAVE BOTH CAR AND BIKE INSURANCE");
            }
           
     }
     catch(Exception e)
     {
    	 e.printStackTrace();
     }

        
        pay1.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent payoo) {
                vehicle vh = new vehicle();
                vh.pay(stage);
            }
        });       
        claim1.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent claimo) {
                vehicle vh = new vehicle();
                vh.claim(stage);
            }
            
        }); 
        
        
        Scene scene = new Scene(gp,500,400);
        stage.setScene(scene);
        stage.show();
    }
}
