
package application;

import java.util.Scanner;

//import javax.lang.model.util.ElementScanner6;

//import javax.lang.model.util.ElementScanner14;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
import javafx.stage.Stage;



class account{
	final String JDBCdrive="com.mysql.cj.jdbc.Driver";
	final String usersql="root";
	final String passsql="1234";
	final String db_url="jdbc:mysql://127.0.0.1:3306/App";
	// Connection con;
	// Statement stmt;
	int choice,id;
 int w;

 public String permnaid;
 public String permnapassw;
 Scanner scan=new Scanner(System.in);

int createacc(Stage stage,int x,String id,String passwk,String bname,String bno,String cname,String cno)
{
    login lg = new login();
    Createacc cr=new Createacc();
    // Connection con;
    // Statement stmt;
    try{
        Connection con = DriverManager.getConnection(db_url,usersql,passsql);
        Statement stmt = con.createStatement();  
        if(x==1)
        {   
            // String id=cr.f1.getText();
            // String passwk=cr.f2.getText();
            // String bname=cr.enter_bname.getText();
            // String bno=cr.enter_bno.getText();
            try{
                int row=stmt.executeUpdate("Insert into logino values('"+id+"','"+passwk+"','"+bname+"','"+bno+"',0,0);");
                int row1=stmt.executeUpdate("Insert into payclaim values(\""+id+"\",600,1);");
                lg.start(stage);
            }
            catch(Exception e){e.printStackTrace();}

        }
        else if(x==2)
        {
                
            // String id=cr.f1.getText();
            // String passwk=cr.f2.getText();
            // String cname=cr.enter_cname.getText();
            // String cno=cr.enter_cno.getText();
            try{
                int row=stmt.executeUpdate("Insert into logino values('"+id+"','"+passwk+"',0,0,'"+cname+"','"+cno+"');");
                int row1=stmt.executeUpdate("Insert into payclaim values(\""+id+"\",1500,1);");
                lg.start(stage);
            }
            catch(Exception e){e.printStackTrace();}


        }
        else if(x==3)
        {
                    
            // String id=cr.f1.getText();
            // String passwk=cr.f2.getText();
            // String cname=cr.enter_cname.getText();
            // String cno=cr.enter_cno.getText();
            // String bname=cr.enter_bname.getText();
            // String bno=cr.enter_bno.getText();
            try{
                int row=stmt.executeUpdate("Insert into logino values('"+id+"','"+passwk+"','"+bname+"','"+bno+"','"+cname+"','"+cno+"');");
                int row1=stmt.executeUpdate("Insert into payclaim values(\""+id+"\",1500,1);");
                lg.start(stage);
            }
            catch(Exception e){e.printStackTrace();}
        }
    }
    catch(Exception e){e.printStackTrace();}
    
    return 0;
}
   /* try{
       

        stmt.executeUpdate("insert into table2 values();");
        System.out.println("Successfully added record");
        lg.start(stage);
        }
        catch(Exception e){e.printStackTrace();}
        return 0;
        */


{
    //  int createacc() 
    //  {
    //      System.out.println("ENter the USERNAME(ONLY FIRST NAME)");
    //      String user_name=scan.nextLine();
    //      System.out.println("ENTER THE PASSWORD");
    //      String pass=scan.nextLine();
    //       System.out.println("Enter 1)For 3rd Party System\n2)For 1st PArty INsurance");
    //      int opt1=scan.nextInt();
    //      System.out.println("SELECT YOUR PREMIUM TYPE\n");
    //      System.out.println("1)Only for Bike\n2)Only for Car\n3)For both Car and Bike");
    //      int opt2=scan.nextInt();
    //     //WRITE THE INFO INTO SQL 
    //     try{
    //         Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
    //         con=DriverManager.getConnection(db_url,user,passw);
    //         stmt= con.createStatement();
    //         System.out.println("INSERTING VALUES INTO TABLE");
    //         int row=stmt.executeUpdate("Insert into login_det values('"+user_name+"','"+pass+"','"+opt1+"','"+opt2+"');");
            
    //         System.out.println(row);
    //         con.close();
    //     }
    //     catch(Exception e)
    //     {
    //         System.out.println("CANNOT INSERT INTO TABLE LOGIN DET "+e);
    //     }
    //         System.out.println("PRESS ANY KEY TO CONTINUE\n");
    //         String xsasa=scan.next();
    //         if(opt2==1)
    //         {
    //             System.out.println("ENTER THE BIKE NO\n");
    //             int bplate=scan.nextInt();
    //             System.out.println("ENTER THE MODEL FOR THE BIKE\n");
    //             int bmodel=scan.nextInt();
    //             //WRITE THE INFO TO SQL
    //             try{
    //                     Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
    //                     con=DriverManager.getConnection(db_url,user,passw);
    //                     stmt= con.createStatement();
    //                     System.out.println("INSERTING VALUES INTO TABLE");
    //                     int row1=stmt.executeUpdate("Insert into login_det values('"+bplate+"','"+bmodel+"',null,null,null,null,null,null);");
                        
    //                 System.out.println(row1);
    //                     con.close();
    //                 }
    //             catch(Exception e)
    //             {
    //                 System.out.println(e);
    //             }
    //         }
    //         else if(opt2==2)
    //         {
    //             System.out.println("ENTER THE CAR NO\n");
    //             int cplate=scan.nextInt();
    //             System.out.println("ENTER THE MODEL NO FOR THE CAR\n");
    //             int cmodel=scan.nextInt();
    //             //WRITE THE INFO TO SQL
                
    //             try{
    //                 Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
    //                 con=DriverManager.getConnection(db_url,user,passw);
    //                 stmt= con.createStatement();
    //                 System.out.println("INSERTING VALUES INTO TABLE");
    //                 int row2=stmt.executeUpdate("Insert into login_det values(null,null'"+cplate+"','"+cmodel+"',null,null,null,null);");
                    
    //             System.out.println(row2);
    //                 con.close();
    //             }
    //         catch(Exception e)
    //         {
    //             System.out.println(e);
    //         }
    //         }
    //         else if(opt2==3)
    //         {
    //             System.out.println("ENTER THE BIKE NO\n");
    //             int bplate=scan.nextInt();
    //             System.out.println("ENTER THE MODEL FOR THE BIKE\n");
    //             int bmodel=scan.nextInt();
    //             System.out.println("ENTER THE CAR NO\n");
    //             int cplate=scan.nextInt();
    //             System.out.println("ENTER THE MODEL NO FOR THE CAR\n");
    //             int cmodel=scan.nextInt();
    //             //WRITE THE INFO TO SQL

    //             try{
    //                 Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
    //                 con=DriverManager.getConnection(db_url,user,passw);
    //                 stmt= con.createStatement();
    //                 System.out.println("INSERTING VALUES INTO TABLE");
    //                 int row3=stmt.executeUpdate("Insert into login_det values(null,null,null,null,'"+bplate+"','"+bmodel+"','"+cplate+"','"+cmodel+"');");
                    
    //             System.out.println(row3);
    //                 con.close();
    //             }
    //         catch(Exception e)
    //         {
    //             System.out.println(e);
    //         }
                
                
                
    //         }
    //         else {
    //             System.out.println("ENTER A VALID CHOICE\n");
    //             createacc();
    //         }
    //         System.out.println("IN ORDER TO ACTIVATE YOUR ACCOUNT YOU WILL NEED TO PAY THE PREMIUM FOR THE 1ST YEAR\n");
    //         if(opt2==1)
    //         {
    //             System.out.println("YOUR YEARLY INSURANCE AMOUNT WILL BE RS.6000\n");
    //         }
    //     else if(opt2==2)
    //         {
    //             System.out.println("YOUR YEARLY INSURANCE AMOUNT WILL BE RS.8000\n");
    //         }
    //         else if(opt2==3)
    //         {
    //             System.out.println("YOUR YEARLY INSURANCE AMOUNT WILL BE RS.13000\n");
    //         }
    //         System.out.println("DO YOU WISH TO PAY IT Y/N\n");
    //         String yesorno=scan.next();
    //         if(yesorno=="Y"||yesorno=="y")
    //         {
    //             System.out.println("Paying the amount for month 2021\nPress any key to continue\n");
    //             String simplykey=scan.next();
    //             System.out.println("ACCOUNT CREATED SUCCESSFULLY\n");
    //             return 0;
    //         }
    //         if(yesorno=="N"||yesorno=="n")
    //         {
    //             System.out.println("ACCOUNT CREATION FAILED\n");
    //             return -1;
                
    //         }
    //     return opt2;
            
    //     }
}
 void loginacc(Stage stage,String user,String pass) 
 {
	 int checko=0;//0 equals its false no records found
    login lg = new login();
    // System.out.println("Enter the username");
    // String user=lg.name1.getText();
    // System.out.println("Enter password");
    // String pass = lg.pass1.getText();

     
     try{           //{}
    		// Class c1=Class.forName("com.mysql.cj.jdbc.Driver");
    	    Connection con=DriverManager.getConnection(db_url,usersql,passsql);
    		Statement stmt= con.createStatement();
    		ResultSet rs=stmt.executeQuery("Select * from logino");
    		while(rs.next())
    		{
    			if(user.equals(rs.getString(1)) && pass.equals(rs.getString(2)))
    			{	checko=1;
                    permnaid=user;
                    permnapassw=pass;
    				System.out.println("USER SUCCESSFULLY LOGGED IN\n");
    				System.out.println("WELCOME "+user);
                    // id= Integer.parseInt(rs.getString(1));
                   // choice =rs.getInt(3);//enter the column here 1 bike 2 car 3 bothAND 
                    break;
    			}
    		
    		}
            if(checko == 0)
            {
                System.out.println("Invalid login details");
            }
                con.close();
            if(checko == 1)
            {
                afterlogin al = new afterlogin();
                try{
                    al.start(stage);
                }
                catch(Exception e){e.printStackTrace();}
            }
     }
     catch(Exception e)
     {
    	 System.out.println(e);
     }
     
     //now open connection and check for password and username
     //if both are equal then only allow 
     //or else display error message

     // here save value of one column in a variable like so
     //its required becasue we will use to determine which insurance they have
//-->remove this comment w = rs.getInt(column_name); column name indicates which column to save 
     
 }


 int rectify(int x,Stage mystage)//this rectify method needs to be outside the account class
 {                  //if you want just put it outside or in temp class and remove the comment
     //account obj = new account();
     System.out.println("Itcamehere");

     if(x==1)
     {
         System.out.println("Itcamehere");
        //  loginacc();
        login lg = new login();
        try{
        lg.start(mystage);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     else if(x==2)
     {
    //      Createacc cr = new Createacc();
    //      try{
    //      cr.start(mystage);}
    // catch(Exception e){e.printStackTrace();}
         Createacc ac = new Createacc();
         try{
            ac.start(mystage);
         }
         catch(Exception e){e.printStackTrace();}
     }
     else if(x==3)
     {
         System.out.println("THANK YOU FOR USING INSURANCE COMPANY\n");
         System.exit(1);
     }
     return 0;
 }
 
}


class vehicle extends account
{
 
 int pay(Stage stage){
         pay p = new pay();
         try{
             p.start(stage);
         }catch(Exception e){e.printStackTrace();}
         //write the result in sql and display its result

         
     	return 0;
     }
     void claim(Stage stage) {
         claim cl = new claim();
         try{
             cl.start(stage);
         }catch(Exception e){e.printStackTrace();}
         
}
}



//      class two extends vehicle{
//          two(int a){//constructor
//              if(a==1)
//              {
//                  pay();
//              }
//              else if(a==2)
//              {
//                  claim();
//          }
//      }
     
//  }
 
//  class four extends vehicle{
//      four(){
//          //constructor
         
//          // label3:
//          System.out.println("Enter\n1)For paying the premium for this month\n2)Claiming the Insurance amount\n3)Go back to Previous Menu\n");
//          int opt34=scan.nextInt();
//          if(opt34==1)
//          {
//              pay();
//          }
//          else if(opt34==2)
//          {
//              claim();
//          }
//          else if(opt34==3)
//          {
//              return;
//          }               
//          else
//          {
//              four t = new four();
//          }
//      }
//  }      


// create table payclaim(id references(table id p),date date,amount int);