/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Assignment2 {

    
    public static void main(String[] args) throws SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        //Connection cn=null;
        try(Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment2","root","8824220629");
                Statement stmt = cn.createStatement();
                )
        {
            System.out.println("These are intial enrties in students table");
            ResultSet rs = stmt.executeQuery("select *from students order by Eid");
            while(rs.next())
                System.out.println(rs.getString("Eid")+" "+rs.getString("name")+" "+rs.getString("father_name")
            +" "+rs.getString("address")+" "+rs.getFloat("cgpa")+" "+rs.getInt("age")+" "+rs.getLong("mobile"));
        /* String sqlinfile = "load data local infile '/home/akhilesh/mysql_data/student.txt' into table students LINES TERMINATED BY '\\n'";
         System.out.println("The SQL query is: " + sqlinfile);  // Echo for debugging
         int countInserted = stmt.executeUpdate(sqlinfile);
         System.out.println(countInserted + " records inserted.\n");*/
      String choice =null;
      Scanner scan = new Scanner(System.in);
      System.out.println("                     MENU"                );
      System.out.println();
      System.out.println();
      System.out.println("              Enter a to add  :"               );
      System.out.println("              Enter b to delete  :"            );
      System.out.println("              Enter c to edit  :"              );
      System.out.println("              Enter d to update:"              );
      System.out.println("              Enter e to Search Informtion:"   );
      System.out.println("              Enter f to Display in ASCENDING:");
      {
            do{
            choice = scan.nextLine();
            switch (choice)
            { 
                case "a":
                    System.out.println("Enter the values of each data field");
                    String id,nm,fnm,ad,a;
                    long mb=0;
                    float cg=0;
                    System.out.println("Enter the values of Eid");
                    id=scan.nextLine();
                    System.out.println("Enter the name");
                    nm=scan.nextLine();
                    System.out.println("Enter the father name");
                    fnm=scan.nextLine();
                    System.out.println("Enter the address");
                    ad=scan.nextLine();
                    System.out.println("Enter the age");
                    a=scan.nextLine();
                    System.out.println("Enter the mobile number");
                    mb=scan.nextLong();
                    System.out.println("Enter the cgpa");
                    cg=scan.nextFloat();
                    String sqlInsert = "insert into students (Eid,name, father_name, address,age,mobile,cgpa) "  // need a space
                                            + "values ('"+id+"','"+nm+"','"+fnm+"','"+ad+"','"+a+"','"+mb+"','"+cg+"')";
                    System.out.println("The SQL query is: " + sqlInsert);  // Echo for debugging
                    int countInserted = stmt.executeUpdate(sqlInsert);
                    System.out.println(countInserted + " records inserted.\n");
                    break;
                case "b":
                    //System.out.println("Enter the Field to be deleted");
                  //  String fld=scan.nextLine();
                    System.out.println("Enter the Eid to be deleted");
                    String dl=scan.nextLine();
                
                    String sqlDelete = "delete from students where Eid='"+dl+"' ";
                    System.out.println("The SQL query is: " + sqlDelete);  // Echo for debugging
                    int countDeleted = stmt.executeUpdate(sqlDelete);
                    System.out.println(countDeleted + " records deleted.\n");
                    break;
                case "c":
                    /*System.out.println("Enter the Column to be dropped");
                    String drop = scan.nextLine();
                    String sqlAlter1 = "ALTER TABLE students  DROP i ";
                    stmt.executeUpdate(sqlAlter1);*/
                    System.out.println("Enter the Column to be added");
                    String add = scan.nextLine();
                    String sqlAlter2 = "ALTER TABLE students  ADD added_col INT ";
                    stmt.executeUpdate(sqlAlter2);
                    System.out.println("Table added");
                    break;
                    
                case "d":
                    System.out.println("Enter the Eid to be Updated");
                    String ei=scan.nextLine();
                    System.out.println("Enter the field to be Updated");
                    String set=scan.nextLine();
                    System.out.println("Enter the field to be Updated");
                    String setv=scan.nextLine();
                   // long setl=scan.nextLong();
                    //float setf = scan.nextFloat();
                    //int seti=scan.nextInt();
                    String sqlupdate1 = "update students set "+set+"='"+setv+"' where Eid='"+ei+"' ";
                    /*String sqlupdate2 = "update students set father_name='"+set+".' where Eid='"+ei+"' ";
                    String sqlupdate3 = "update students set address='"+set+"' where Eid='"+ei+"' ";
                    String sqlupdate4 = "update students set age='"+set+"' where Eid='"+ei+"' ";
                    String sqlupdate5 = "update students set mobile='"+set+"' where Eid='"+ei+"' ";
                    String sqlupdate6 = "update students set cgpa='"+set+"' where Eid='"+ei+"' ";*/
                    System.out.println("The SQL query is: " + sqlupdate1);
                    int countupdate = stmt.executeUpdate(sqlupdate1);
                    /*countupdate = stmt.executeUpdate(sqlupdate2);
                    countupdate = stmt.executeUpdate(sqlupdate3);
                    countupdate = stmt.executeUpdate(sqlupdate4);
                    countupdate = stmt.executeUpdate(sqlupdate5);
                    countupdate = stmt.executeUpdate(sqlupdate6);*/
                    System.out.println(countupdate+ " records updated.\n");
                    break;
                case "e":
                   /* System.out.println("Enter the Eid to be Updated");
                    String ei=scan.nextLine();*/
                    System.out.println("Enter the Eid whose information is to be Searched");
                    String val=scan.nextLine();
                    String strSelect = "SELECT * from students where Eid='"+val+"'";
                    //System.out.println("The SQL query is: " + strSelect); // Echo For debugging
                    System.out.println();
                    //int rowcount=0;
                    ResultSet rset = stmt.executeQuery(strSelect);
                    while(rset.next()) {   // Move the cursor to the next row
                    String Eeid = rset.getString("Eid");
                    String nnm = rset.getString("name");
                    String ffnm = rset.getString("father_name");
                    String adr = rset.getString("address");
                    float ccgp = rset.getFloat("cgpa");
                    int    age  = rset.getInt("age");
                    long    mmb  = rset.getLong("mobile");
                    System.out.println(Eeid+ ", " + nnm + ", "+ffnm+","+adr+","+age+","+mmb+","+ccgp);
                    // ++rowcount;
                    }
                    break;
                case "f":
                    //System.out.println("Enter the Eid whose information is to be Searched");
                    //String val=scan.nextLine();
                    String sstrSelect = "SELECT * from students order by name,age ASC ";
                    ResultSet rrset = stmt.executeQuery(sstrSelect);
                    while(rrset.next()) {   // Move the cursor to the next row
                    String snnm = rrset.getString("name");
                    /*String Eeid = rset.getString("Eid");
                    String nnm = rset.getString("name");
                    String ffnm = rset.getString("father_name");
                    String adr = rset.getString("address");
                    float ccgp = rset.getFloat("cgpa");
                    int    age  = rset.getInt("age");
                    long    mmb  = rset.getLong("mobile");*/
                    System.out.println(snnm);
                    }
                    break;
                    
                
                
            } 
        
        }while(!choice.equals("exit"));
                
        }
      
          
          
          
          
          
          
          
          
          
          
          
      
        //catch(Exception e){
          //  System.out.println("Connection NOT established");
        //}
        
        }
}
}

   
