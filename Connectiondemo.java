/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Connectiondemo 
{
    static Connection conn=null;
    public static Connection getConnection()
    {
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
        	conn=DriverManager.getConnection("jdbc:mysql://localhost/lib","root","vishu");
        }
        catch(Exception e)
        {
        	JOptionPane.showMessageDialog(null,e);
        }
        return conn;
    }
}

