package Library;
import Library.Connectiondemo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Modifybook
{
	JFrame f=new JFrame("Modify Book");
	Modifybook()
	
	{
	
       	
		JLabel c,l1,l2,l3,l4,l5;
		final JTextField BookID,Author,Publisher,Quantity, BookName;
		 final JButton g=new JButton("Search");
		g.setBounds(450,120,100,30);f.add(g);
		g.setForeground(Color.BLUE);g.setBackground(Color.cyan);
		g.setFont(new Font ("Times New Roman",Font.BOLD,22));
		c=new JLabel("Modify Book");
		l1=new JLabel("Book ID");
		l2=new JLabel("Book Name");
		l3=new JLabel("Author");
		l4=new JLabel("Publisher");
		l5=new JLabel("Quantity");
		c.setFont(new Font ("Times New Roman",Font.BOLD,46));
		c.setForeground(Color.cyan);
		l1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l3.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l4.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l5.setFont(new Font ("Times New Roman",Font.BOLD,22));
		l1.setForeground(Color.BLUE);l2.setForeground(Color.BLUE);l3.setForeground(Color.BLUE);
		l4.setForeground(Color.BLUE);l5.setForeground(Color.BLUE);
		c.setBounds(200,60,300,50);
		l1.setBounds(150,170,100,30);
		l2.setBounds(150,230,120,30);
		l3.setBounds(150,290,100,30);
		l4.setBounds(150,350,100,30);
		l5.setBounds(150,410,100,30);f.add(c);
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);
		BookID=new JTextField();
		BookName=new JTextField();
		Author=new JTextField();
		Publisher=new JTextField();
		Quantity=new JTextField();
		BookID.setBounds(350,170,200,30);
		BookName.setBounds(350,230,200,30);
		Author.setBounds(350,290,200,30);
		Publisher.setBounds(350,350,200,30);
		Quantity.setBounds(350,410,200,30);
		f.add(BookID);f.add(BookName);f.add(Author);f.add(Publisher);f.add(Quantity);
		final JButton b1;
		JButton b2;
		b1=new JButton("Update");
		b2=new JButton("Back");
		b1.setForeground(Color.BLUE);b2.setForeground(Color.BLUE);b1.setBackground(Color.cyan);b2.setBackground(Color.cyan);
		b1.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b2.setFont(new Font ("Times New Roman",Font.BOLD,22));
		b1.setBounds(150,500,120,30);
		b2.setBounds(400,500,120,30);
		f.add(b1);f.add(b2);
		JLabel ll=new JLabel();
		ll.setIcon(new ImageIcon("\\c:\\l17.jpg"));
		ll.setBounds(0,0,700,700);
		f.add(ll);
		f.setSize(700,700);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		g.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				 try{
				        Connection conn=Connectiondemo.getConnection();
				        PreparedStatement ps=conn.prepareStatement("select * from addnewbooks where callno='"+BookID.getText()+"'");
				        ResultSet rs=ps.executeQuery();
				        while(rs.next())
				        {
				        BookID.setText(rs.getString(1));
				        BookName.setText(rs.getString(2));
				        Author.setText(rs.getString(3));
				        Publisher.setText(rs.getString(4));
				        Quantity.setText(rs.getString(5));
				        BookID.setEditable(false);
				        }
				        }catch(Exception e){
				        JOptionPane.showMessageDialog(null, e);
				        }
			}
			});
		
				
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent args0)
			{
				if(BookID.getText().equals("")||BookName.getText().equals("")||Author.getText().equals("")||Publisher.getText().equals("")||Quantity.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill all Columns");	
				}
				else
				{
				try
				{
					Connection conn=Connectiondemo.getConnection();
					PreparedStatement ps=conn.prepareStatement("update addnewbook set BookID='"+BookID+"',BookName='"+BookName+"',Author='"+Author+"',Publisher='"+Publisher+"',Quantity='"+Quantity+"' where BookID='"+BookID+"'");  
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Librarian Detail Update Suceessfully!");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent args0)
			{
				new Librariansection();
				f.dispose();
			}
		});
	}
	public static void main(String[] args) 
	{
		new Modifybook();
	}

}
